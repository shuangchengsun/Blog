package com.alan.blog.service.impl;

import com.alan.blog.dao.repository.TagRepository;
import com.alan.blog.model.Tag;
import com.alan.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;


    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTagByName(String tagName) {
        return tagRepository.findByName(tagName);
    }

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }
}
