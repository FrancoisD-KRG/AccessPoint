package main.java.com.access; /**
 * Created by francoisdziedzinl on 08/12/2014.
 */

import main.java.com.access.rest.Hello;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class HelloWorld
{
	public static void main(String[] args) throws Exception
	{

		Server server = new Server(8080);
		ServletHandler servlethandler = new ServletHandler();
		servlethandler.addServletWithMapping(HelloServlet.class, "/*");
/*
		ServletHolder sh = new ServletHolder(ServletContainer.class);
		sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
		sh.setInitParameter("com.sun.jersey.config.property.packages", "rest");//Set the package where the services reside
		sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
*/
		ResourceHandler resourcehandler = new ResourceHandler();
		resourcehandler.setDirectoriesListed(true);
		resourcehandler.setResourceBase("out/production/Test3/");
		resourcehandler.setWelcomeFiles(new String[]{"main/resources/webapp/index.html"});

		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new AbstractHandler[] { resourcehandler, servlethandler });
		server.setHandler(handlers);

		server.start();
		server.join();
		/*

		ResourceConfig resourceConfig = new ResourceConfig();
		resourceConfig.packages(Hello.class.getPackage().getName());
		ServletContainer servletContainer = new ServletContainer(resourceConfig);
		ServletHolder sh = new ServletHolder(servletContainer);
*/
	}
}
