package net.marioosh.gwt.server;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@Controller
@RequestMapping("/**/greet.rpc")
public class GwtRpcController extends RemoteServiceServlet implements org.springframework.web.servlet.mvc.Controller {

	@Autowired
    private ServletContext servletContext;

    @Autowired
    private RemoteService remoteService;

    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        super.doPost(request, response);
        return null;
    }

    @Override
    public String processCall(String payload) throws SerializationException {
        try {

            RPCRequest rpcRequest = RPC.decodeRequest(payload,
                    this.remoteService.getClass());

            // delegate work to the spring injected service
            return RPC.invokeAndEncodeResponse(this.remoteService, rpcRequest
                    .getMethod(), rpcRequest.getParameters());
        } catch (IncompatibleRemoteServiceException ex) {
            getServletContext()
                    .log(
                            "An IncompatibleRemoteServiceException was thrown while processing this call.",
                            ex);
            return RPC.encodeResponseForFailure(null, ex);
        }
    }

    @Override
    public ServletContext getServletContext() {
        return servletContext;
    }

}