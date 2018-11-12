package form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ViewServlet1")
public class ViewServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();  
        out.println("<a href='index1.jsp'>Add new student details</a>");  
        out.println("<h1>Add new student details</h1>");
    	List<Student> list=StuDao.getAllStudent();  
    	out.print("<table border='2' width='100'");
    	out.print("<tr><th>Id</th><th>Name</th><th>Address</th><th>Email</th> <th>Update</th><th>Delete</th></tr>");
    	for(Student s:list)
    				out.print("<tr>"
    				+"<td>"+s.getId()+"</td>"
    				+"<td>"+s.getName()
    				+"<td>"+s.getAddress()
    				+"</td><td>"+s.getEmail()+"</td>"
    				+"<td><a href='EditServlet?id="+s.getId()+"'>edit</a></td>"
    				+ "<td><a href='DeleteServlet?id="+s.getId()+"'>delete</a></td></tr>");  
    	out.print("</table>");
    	out.close();
   }
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
