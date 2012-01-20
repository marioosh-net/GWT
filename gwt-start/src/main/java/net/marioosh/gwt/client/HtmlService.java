package net.marioosh.gwt.client;

import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("html")
public interface HtmlService extends RemoteService {
	public Map<String, String> pageInfo(String url);
}
