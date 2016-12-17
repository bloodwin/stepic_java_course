package main;

import servlets.AllRequestsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Anna Bloodwina
 *
 * Lesson 1
 * @version 1.0.201612011534
 *
 */
public class Main {

    private static Logger log = Logger.getGlobal();

    public static void main(String args[]) throws Exception {
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        log.info("Server started");
        server.join();

    }
}
