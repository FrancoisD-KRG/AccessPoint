package main.java.com.access; /**
 * Created by francoisdziedzinl on 08/12/2014.
 */
import java.io.*;
import java.net.Socket;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("This is not the page you're looking for.");
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("You entered the command: " + command);
		out.println("</body>");
		out.println("</html>");

		try {
			Socket socket = new Socket("localhost", 9090);
			OutputStreamWriter outStream = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			outStream.write(command);
			outStream.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		if (command.equals("kill")) {
			System.exit(0);
		}
	}
}
