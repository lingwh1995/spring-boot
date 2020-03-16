package com.dragonsoft.test;

import com.dragonsoft.domain.Article;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ronin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ElasticSearchTemplateTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 查询单个
     */
    @Test
    public void fun1(){
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery("消息"))
                .withPageable(PageRequest.of(0, 20))
                .build();
        List<Article> articles = elasticsearchTemplate.queryForList(searchQuery, Article.class);
        System.out.println("---------------------------------------------");
        articles.forEach(item -> System.out.println(item));
        System.out.println("---------------------------------------------");
    }
}
