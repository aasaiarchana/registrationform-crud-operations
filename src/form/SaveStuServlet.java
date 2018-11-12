package form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveStuServlet")
public class SaveStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String name = request.getParameter("stuname");
		String address = request.getParameter("stuaddr");
		String email = request.getParameter("stuemail");
		//string department=request.getParameter("studepartment"");
		//string address1
		
		s.setName(name);
		s.setAddress(address);
		s.setEmail(email);
		
		int mark = StuDao.saveDetails(s);
		if (mark > 0) {
			out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index1.jsp").include(request, response);
		} 
		else {
			out.println("unable to save records");

		}

		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	

}
