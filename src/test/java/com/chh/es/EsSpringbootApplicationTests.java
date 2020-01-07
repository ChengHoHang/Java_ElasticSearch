package com.chh.es;

import com.chh.es.entity.MySqlBlog;
import com.chh.es.repository.EsBlogRepository;
import com.chh.es.repository.MySqlBlogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EsSpringbootApplicationTests {

    @Autowired
    MySqlBlogRepository mySqlBlogRepository;

    @Autowired
    EsBlogRepository esBlogRepository;

    @Test
    public void contextLoads() {
        List<MySqlBlog> all = mySqlBlogRepository.queryAll();
        for (MySqlBlog mySqlBlog : all) {
            System.out.println(mySqlBlog.getCreateTime());
        }
    }

}
