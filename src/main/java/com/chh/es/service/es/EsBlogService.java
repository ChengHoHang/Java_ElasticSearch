package com.chh.es.service.es;

import com.chh.es.entity.EsBlog;
import com.chh.es.repository.EsBlogRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EsBlogService {

    @Autowired
    EsBlogRepository esBlogRepository;

    public Object search(String keyWord) {
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        builder.should(QueryBuilders.matchPhraseQuery("title", keyWord));
        builder.should(QueryBuilders.matchPhraseQuery("content", keyWord));
        Page<EsBlog> search = (Page<EsBlog>) esBlogRepository.search(builder);
        return search.getContent();
    }
}
