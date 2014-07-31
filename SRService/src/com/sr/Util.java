package com.sr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

final public class Util {

    /**
     * This method splits the total collection past in by the maximum 
     * number of elements allowed in any child collection.
     * @param <T>
     * 
     * @param ids
     * @param maxNumberOfElements
     * @return
     */
    public <T> Collection<Collection<T>> splitByMaxNumberOfElements(Collection<T> ids, int maxNumberOfElements) {
        if(ids == null || ids.size() <= 0){
            return null; //Exit
        }
        
        Collection<Collection<T>> result = new ArrayList<Collection<T>>();

        if(maxNumberOfElements >= ids.size()){
            result.add(ids);
            return result; //Exit
        }
        
        Collection<T> idsList = new ArrayList<T>();

        int count = 0;
        for (T dcId : ids) {

            if (count == maxNumberOfElements) {
                result.add(idsList);
                count = 1;
                idsList = new ArrayList<T>();
                idsList.add(dcId);
                continue;
            }

            idsList.add(dcId);
            count++;
        }

        result.add(idsList);
        return result; // Exit
    }
    
    public static List<String> breakupString(String original, int lengthPerPart){
    	List<String> result = new ArrayList<String>();
    	StringTokenizer st = new StringTokenizer(original, " ");
    	StringBuilder b = new StringBuilder(lengthPerPart);
    	int currentSize = 0;
    	
    	while(st.hasMoreTokens()){
    		String token = st.nextToken();
    		
    		if(token == null || token.trim().length() <= 0){
    			continue;
    		}
    		
    		//If the current token is bigger than the total amount allowed 
    		//for the entire message exit and throw a nasty message.
    		if(token.trim().length() > lengthPerPart){
    			throw new IllegalArgumentException("Shorten your phrases!"); //Exit
    		}
    		
    		if((currentSize + token.trim().length()) >= lengthPerPart){
    			result.add(b.toString().trim());
    			b = new StringBuilder(lengthPerPart);
    			b.append(token);
    			b.append(" ");
    			currentSize = token.trim().length();
    			continue;
    		}
    		
    		b.append(token);
    		b.append(" ");
    		currentSize =+ b.length();
    	}
    	
    	if(b.toString().trim().length() > 0){
    		result.add(b.toString().trim());
    	}
    	
    	return result; //Exit
    }
    
	public static String buildResponseUrl(HttpServletRequest req, String destination) {
		StringBuilder r = new StringBuilder();
		r.append(req.getScheme());
		r.append("://");
		r.append(req.getServerName());
		r.append(":");
		r.append(req.getServerPort());
		r.append(req.getContextPath());
		r.append(destination);
		return r.toString();
	}
    

}
