package com.dragonsoft.exception;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ronin
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        errorAttributes.put("company","dragon");
        Map<String,Object> ext = (Map<String,Object>)requestAttributes.getAttribute("ext", 0);
        errorAttributes.put("ext",ext);
        return errorAttributes;
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("company","dragon");
//        return map;
    }
}
