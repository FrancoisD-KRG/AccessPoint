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
		String q = req.getParameter("q");
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("The paramter q was \"" + q + "\".");
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

		Socket socket;
		PrintStream output;

		try {
			socket = new Socket("localhost", 9090);
			output = new PrintStream(socket.getOutputStream());
			output.print(command);
			output.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
