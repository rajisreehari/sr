package com.sr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.sr.dao.ThingDto;
import com.sr.service.ThingService;

@Controller
public class SearchController {
	@Autowired
	private ThingService thingService;
	
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("phrase") String phrase) throws NoSuchRequestHandlingMethodException {
    	List<ThingDto> results = thingService.search(phrase);
        return "sr/search_results";
    }

}
