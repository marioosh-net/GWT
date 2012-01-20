package net.marioosh.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface HtmlServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see net.marioosh.gwt.client.HtmlService
     */
    void pageInfo( java.lang.String url, AsyncCallback<java.util.Map<java.lang.String,java.lang.String>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static HtmlServiceAsync instance;

        public static final HtmlServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (HtmlServiceAsync) GWT.create( HtmlService.class );
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "html" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
