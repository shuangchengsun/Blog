package com.alan.blog.web.api;


import com.alan.blog.model.Tag;
import com.alan.blog.service.TagService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tag")
@Controller
public class TagsApi {

    @Autowired
    TagService tagService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @PostMapping("/add")
    public String addTag(@RequestBody Tag tag) {
        tag.setBlogs(null);
        if (tag.getName() != null && tag.getName().length() != 0) {
            /*符合标准就保存，否则跳过这一步*/
            logger.info("receive tag -----" + tag.getName());
            Tag saveTag = tagService.saveTag(tag);
            String json;
            if (saveTag != null) {
                json = "{\"message\" : \"OK\"}";
            }else{
                json = "{\"message\" : \"ERROR\"}";
            }
            return json;
        }else{
            return "{\"message\" : \"ERROR\"}";
        }
    }


    @ResponseBody
    @GetMapping("/getAll")
    public String getAll() {
        List<Tag> tags = tagService.getAll();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(tags);
            System.out.println(json);
            return json;
        } catch (JsonProcessingException exception) {
            logger.error("cache the JsonProcessingException, the tagList can not be write into a json string");
            return "{\"message\" : \"JsonProcessingException\"}";
        }
    }
}
