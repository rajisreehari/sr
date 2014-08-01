package com.sr.controller;

import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import com.sr.dao.ThingDto;
import com.sr.dao.ThingState;
import com.sr.page.SearchResponse;
import com.sr.service.MasterService;

@Controller
public class SearchController {
	private Log4JLogger logger = new Log4JLogger(this.getClass().getName());
	
	@Autowired
	private MasterService masterService;
	
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("phrase") String phrase) throws NoSuchRequestHandlingMethodException {
    	List<ThingDto> searchResults = masterService.getThingService().search(phrase);
    	logger.info("things found: " + (searchResults != null ? searchResults.size() : 0));
    	
    	ModelAndView result = null;
    	if(searchResults != null && searchResults.size() > 0){
    		result = new ModelAndView(ViewPath.SEARCH_RESULTS, ModelName.SEARCH_RESPONSE, new SearchResponse(searchResults));
    	}else{
    		result = new ModelAndView(ViewPath.CREATE, ModelName.THING, new ThingDto(phrase, ThingState.SEARCHED_NOT_FOUND_CREATE));
    	}
        return result; //Exit
    }

}
