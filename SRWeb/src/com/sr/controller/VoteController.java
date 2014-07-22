package com.sr.controller;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.sr.service.ThingService;

@Controller
public class VoteController {
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	@Autowired
	private ThingService thingService;
	
	@Secured("ROLE_USER")
    @RequestMapping(value = "/vote", method = RequestMethod.GET)
    public void vote(@RequestParam("id") String id, @RequestParam("rate") String rate, 
    		HttpServletRequest request, HttpServletResponse response) 
    		throws NoSuchRequestHandlingMethodException, IOException {
    	
    	final String ip = request.getRemoteAddr();
        final String browser = request.getHeader("user-agent");
    	logger.info("Voting for ID: " + id + " RATE: " + rate + " from IP: " + ip + " from browser: " + browser);
    	thingService.vote(new BigInteger(id), new Double(rate));
    	response.getWriter().println(thingService.getVote(new BigInteger(id)));
    }

}
