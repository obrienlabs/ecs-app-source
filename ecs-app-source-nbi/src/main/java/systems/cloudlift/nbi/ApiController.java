package systems.cloudlift.nbi;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
// http://localhost:8080/nbi/api
public class ApiController {

    private final AtomicLong counter = new AtomicLong();
	private static final CharSequence PASS = "PASS";
	private static final CharSequence FAIL = "FAIL";
    
   /* @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Api process(@RequestParam(
    		value="action", required=true, defaultValue="undefined") String action,
    		 HttpServletRequest request) {
    	String message = PASS.toString();
    	message = message +  " remoteAddr: " +
        	request.getRemoteAddr() + " localAddr: " + 
    		request.getLocalAddr() + " remoteHost: " +
        	request.getRemoteHost() + " serverName: " + 
    		request.getServerName();
     	Api api = new Api(counter.incrementAndGet(), message);
     	
    	System.out.println(counter + " " + this.getClass().getCanonicalName() + " remoteAddr: " +
        	request.getRemoteAddr() + " localAddr: " + 
    		request.getLocalAddr() + " remoteHost: " +
        	request.getRemoteHost() + " serverName: " + 
    		request.getServerName());// + " requestedSessionId: " + 
        	//request.getRequestedSessionId() + " X-FORWARDED-FOR: " +
    		//request.getHeader("X-FORWARDED-FOR"));

    	return api;
    } */
    
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Api process(@RequestParam(
    		value="action", required=true, defaultValue="undefined") String action,
    		 HttpServletRequest request) {
    	String message = PASS.toString();
    	message = message +  " remoteAddr: " +
        	request.getRemoteAddr() + " localAddr: " + 
    		request.getLocalAddr() + " remoteHost: " +
        	request.getRemoteHost() + " serverName: " + 
    		request.getServerName();
     	Api api = new Api(counter.incrementAndGet(), message);
     	
    	System.out.println(counter + " " + this.getClass().getCanonicalName() + " remoteAddr: " +
        	request.getRemoteAddr() + " localAddr: " + 
    		request.getLocalAddr() + " remoteHost: " +
        	request.getRemoteHost() + " serverName: " + 
    		request.getServerName());// + " requestedSessionId: " + 
        	//request.getRequestedSessionId() + " X-FORWARDED-FOR: " +
    		//request.getHeader("X-FORWARDED-FOR"));

    	return api;
    } 
    
}
