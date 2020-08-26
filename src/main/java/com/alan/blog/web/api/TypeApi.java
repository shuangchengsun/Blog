package com.alan.blog.web.api;


import com.alan.blog.model.Type;
import com.alan.blog.service.TypeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/type")
@Controller
public class TypeApi {

    @Autowired
    private TypeService typeService;

    private String errorMessage = "{\"message\" : \"ERROR\"}";
    private String okMessage = "{\"message\" : \"OK\"}";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/getAll")
    @ResponseBody
    public String getAll(){
        List<Type> typeList = typeService.getAllType();
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(typeList);
        }catch (JsonProcessingException e) {
            logger.error("types 转json错误");
            return null;
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestBody Type type){
        if(type.getName() == null || type.getName().length() == 0){
            return errorMessage;
        } else{
            type.setBlogs(null);
            Type saveType = typeService.saveType(type);
            if(saveType != null){
                return okMessage;
            }else {
                return errorMessage;
            }
        }
    }
}
