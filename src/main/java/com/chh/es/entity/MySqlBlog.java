package com.chh.es.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * CREATE TABLE `blog` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `title` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
 *   `author` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL,
 *   `content` mediumtext COLLATE utf8_unicode_ci,
 *   `createTime` datetime DEFAULT NULL,
 *   `updateTime` datetime DEFAULT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
 */
@Data
@Table(name = "blog")
@Entity
public class MySqlBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    @Column(columnDefinition = "mediumtext")
    private String content;
    private Date createTime;
    private Date updateTime;
}
