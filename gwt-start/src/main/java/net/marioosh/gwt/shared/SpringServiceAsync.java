package net.marioosh.gwt.shared;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface SpringServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see net.marioosh.gwt.shared.SpringService
     */
    void springTest( AsyncCallback<java.lang.String> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static SpringServiceAsync instance;

        public static final SpringServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (SpringServiceAsync) GWT.create( SpringService.class );
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint( GWT.getModuleBaseURL() + "spring" );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
