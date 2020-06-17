package com.alan.blog.service;

import com.alan.blog.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TagService {

    Tag saveTag(Tag tag);
    Tag getTagByName(String tagName);
    List<Tag> getAll();

}
