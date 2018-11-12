package form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String address=request.getParameter("addrss");  
        String email=request.getParameter("email");  
          
          
        Student s=new Student();  
        s.setId(id);  
        s.setName(name);  
        s.setAddress(address);  
        s.setEmail(email);  
         
          
        int mark=StuDao.update(s);  
        if(mark>0){  
            response.sendRedirect("ViewServlet1");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  

	

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
