package com.chh.es.repository;

import com.chh.es.entity.MySqlBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MySqlBlogRepository extends JpaRepository<MySqlBlog, Integer> {

    @Query("select e from MySqlBlog e order by e.createTime desc")
    List<MySqlBlog> queryAll();

    @Query("select e from MySqlBlog e where e.title like concat('%', :keyword, '%')" +
            "or e.content like concat('%', :keyword, '%')")
    List<MySqlBlog> searchBlog(@Param("keyword") String keyWord);
}
