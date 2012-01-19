package net.marioosh.gwt.server;

import net.marioosh.gwt.client.GreetingService;
import net.marioosh.gwt.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {

  public String greetServer(String input) throws IllegalArgumentException {
	  return "Hello";
  }

}
