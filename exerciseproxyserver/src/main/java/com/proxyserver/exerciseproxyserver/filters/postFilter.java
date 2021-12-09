package com.proxyserver.exerciseproxyserver.filters;

import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class postFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(postFilter.class); //logger to print headers

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true; // run function exec true
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext rctx = RequestContext.getCurrentContext(); // RequestContext to get request information
		StringBuffer logS=new StringBuffer(); // buffer to save info to logger
		logS.append("\n*****************New Request*****************\n"); // delimiter
		logS.append(String.format("Server: %s Method: %s Path: %s \n",rctx.getRequest().getServerName(),rctx.getRequest().getMethod(),rctx.getRequest().getRequestURI()));
		Enumeration<String> enumera= rctx.getRequest().getHeaderNames(); // full headers array
		
		String header;
        while (enumera.hasMoreElements())
        {
            header=enumera.nextElement();
            logS.append(String.format("Header: %s = %s \n",header,rctx.getRequest().getHeader(header))); // full logger headers
        };         
        log.info(logS.toString());
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post"; // filter post exec
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
