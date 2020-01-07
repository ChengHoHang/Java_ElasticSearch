package com.chh.es.service.mysql;

import com.chh.es.entity.MySqlBlog;
import com.chh.es.repository.MySqlBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MySqlBlogService {

    @Autowired
    MySqlBlogRepository mySqlBlogRepository;

    public List<MySqlBlog> findAll() {
        return mySqlBlogRepository.queryAll();
    }

    public Optional<MySqlBlog> findById(Integer id) {
        return mySqlBlogRepository.findById(id);
    }

    public Object search(String keyWord) {
        return mySqlBlogRepository.searchBlog(keyWord);
    }
}
