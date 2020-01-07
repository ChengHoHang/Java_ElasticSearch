package com.chh.es.controller;

import com.chh.es.entity.MySqlBlog;
import com.chh.es.service.es.EsBlogService;
import com.chh.es.service.mysql.MySqlBlogService;
import com.chh.es.utils.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
public class DataController {

    @Autowired
    MySqlBlogService mySqlBlogService;

    @Autowired
    EsBlogService esBlogService;

    @GetMapping("/blogs")
    public Object blog() {
        return mySqlBlogService.findAll();
    }

    @PostMapping("/search")
    public Object search(@RequestBody Param param) {
        HashMap<String, Object> map = new HashMap<>();
        StopWatch watch = new StopWatch();
        watch.start();
        if (param.getType().equalsIgnoreCase("mysql")) {
            map.put("list", mySqlBlogService.search(param.getKeyWord()));
        } else if (param.getType().equalsIgnoreCase("es")) {
            map.put("list", esBlogService.search(param.getKeyWord()));
        } else {
            return "i don't understand";
        }
        watch.stop();
        map.put("duration", watch.getTotalTimeMillis());
        return map;
    }

    @GetMapping("/blog/{id}")
    public Object findById(@PathVariable("id") Integer id) {
        Optional<MySqlBlog> byId = mySqlBlogService.findById(id);
        return byId.get();
    }
}
