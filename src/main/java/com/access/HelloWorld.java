package main.java.com.access; /**
 * Created by francoisdziedzinl on 08/12/2014.
 */

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.servlet.ServletHandler;

public class HelloWorld
{
	public static void main(String[] args) throws Exception
	{

		Server server = new Server(8080);
		ServletHandler servlethandler = new ServletHandler();
		servlethandler.addServletWithMapping(HelloServlet.class, "/*");

		ResourceHandler resourcehandler = new ResourceHandler();
		resourcehandler.setDirectoriesListed(true);
		resourcehandler.setResourceBase("/usr/share/java/accessPoint/");
		resourcehandler.setWelcomeFiles(new String[]{"main/resources/webapp/index.html"});

		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new AbstractHandler[] { resourcehandler, servlethandler });
		server.setHandler(handlers);

		server.start();
		server.join();

	}
}
