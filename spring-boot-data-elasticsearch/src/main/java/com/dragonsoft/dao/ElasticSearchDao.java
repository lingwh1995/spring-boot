package com.dragonsoft.dao;

import com.dragonsoft.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author ronin
 */
public interface ElasticSearchDao extends ElasticsearchRepository<Article,Integer>{
    /**
     * 根据标题查询
     * @param title 标题
     * @return
     */
    List<Article> findByTitleLike(String title);
}
