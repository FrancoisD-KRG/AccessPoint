package main.java.com.access; /**
 * Created by francoisdziedzinl on 08/12/2014.
 */
import java.io.*;
import java.net.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String q = req.getParameter("q");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("The paramter q was \"" + q + "\".");
		out.println("</body>");
		out.println("</html>");


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String field = request.getParameter("command1");
		String field2 = request.getParameter("field");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("You entered \"" + "field: " + field + " and field2: " + field2 + "\" into the text box.");
		out.println("</body>");
		out.println("</html>");
	}
}
