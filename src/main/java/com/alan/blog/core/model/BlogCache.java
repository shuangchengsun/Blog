package com.alan.blog.core.model;

import com.alan.blog.Exception.ParamErrorException;
import com.alan.blog.model.Blog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BlogCache {
    private static BlogCache instance = new BlogCache();

    private Map<Long, Blog> cache = new ConcurrentHashMap<>(16);
    private int max;
    private BlogCache(){
        max = 1024;
    }
    public static BlogCache getInstance(){
        return instance;

    }
    public boolean containBlog(Long id){
        return cache.containsKey(id);
    }
    public Blog getBlog(Long id){
        if(id == null || !containBlog(id)){
            return null;
        }
        Blog blog = cache.get(id);
        blog.setViews(1+blog.getViews());
        return blog;
    }
    public void setBlog(Blog blog){
        if(blog == null)
            throw new ParamErrorException("param blog is null");
        else {
            if(cache.size()<max)
                cache.put(blog.getId(),blog);
        }
    }
}
