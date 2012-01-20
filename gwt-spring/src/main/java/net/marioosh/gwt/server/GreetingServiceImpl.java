package net.marioosh.gwt.server;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.marioosh.gwt.client.GreetingService;
import net.marioosh.gwt.shared.FieldVerifier;
import net.marioosh.gwt.shared.model.dao.UserDAO;
import net.marioosh.gwt.shared.model.entities.User;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
@Service("remoteService")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {

	@Autowired
	private UserDAO userDAO;
	
  public String greetServer(String input) throws IllegalArgumentException {
	  return userDAO+"";
  }
  
}
