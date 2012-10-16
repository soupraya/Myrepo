package com.soupraya.server;

import com.soupraya.client.GreetingService;
import com.soupraya.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import java.io.*;
import java.util.*;
import java.net.*;
import com.google.gwt.http.client.*;
import com.google.gwt.http.client.URL;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
	

	
	    private String ConnectZoho()
	    {    
	           String authtoken = "118e4371851e32ecbbf4f7a4ef0211d8";
	           String targetURL = "https://crm.zoho.com/crm/private/xml/Leads/getRecords"; 
	           String paramname = "content";
	            
	           RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(targetURL));
	           try {
	        	   Request request = builder.sendRequest(null, new RequestCallback() {
	        	     public void onError(Request request, Throwable exception) {
	        	        // Couldn't connect to server (could be timeout, SOP violation, etc.)     
	        	     }

	        	     public void onResponseReceived(Request request, Response response) {
	        	       if (200 == response.getStatusCode()) {
	        	           // Process the response in response.getText()
	        	       } else {
	        	         // Handle the error.  Can get the status text from response.getStatusText()
	        	       }
	        	     }       
	        	   });
	        	 } catch (RequestException e) {
	        	   // Couldn't connect to server        
	        	 }
	           
			return paramname;
	            
	            
/*	            PostMethod post = new PostMethod(targetURL);
	            post.setParameter("authtoken",authtoken);
	            post.setParameter("scope","crmapi");
	            HttpClient httpclient = new HttpClient();
	            PrintWriter myout = null;

	            -------------------------------------- Execute the http request--------------------------------
	            try 
	            {
	                long t1 = System.currentTimeMillis();
	                int result = httpclient.executeMethod(post);
	                System.out.println("HTTP Response status code: " + result);
	                System.out.println(">> Time taken " + (System.currentTimeMillis() - t1));
	            -------------------------------------- Execute the http request--------------------------------
	                
	                 ---------------------------writing the response to a file--------------------
	                myout = new PrintWriter(new File("response.xml"));
	                myout.print(post.getResponseBodyAsString());
	                ---------------------------writing the response to a file--------------------
	                
	                -----------------------Get response as a string ----------------
	                String postResp = post.getResponseBodyAsString();
	                System.out.println("postResp=======>"+postResp);
	                 ---------------------Get response as a string ----------------------------
	                 if(postResp.equals("Invalid Ticket Id"))
	                 {
	                     // generate new auth token and call the API
	                 } 
	            }
	            catch(Exception e)
	            {
	                e.printStackTrace();
	            }    
	            finally 
	            {
	                myout.close();
	                post.releaseConnection();
	            }
	        }

	    }*/ 
  
}
}
