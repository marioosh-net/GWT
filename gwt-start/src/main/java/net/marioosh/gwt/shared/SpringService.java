package net.marioosh.gwt.shared;

import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("spring")
public interface SpringService extends RemoteService {
	public String springTest();
}
