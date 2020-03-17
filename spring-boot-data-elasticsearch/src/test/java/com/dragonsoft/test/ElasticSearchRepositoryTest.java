package com.dragonsoft.test;

import com.dragonsoft.dao.ElasticSearchDao;
import com.dragonsoft.domain.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @author ronin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ElasticSearchRepositoryTest {

    @Autowired
    private ElasticSearchDao elasticSearchDao;

    /**
     * 保存
     */
    @Test
    public void fun1(){
        //给Es中索引,保存一个文档
        Article article = new Article();
        article.setId(2);
        article.setTitle("好消息2");
        article.setAutor("张三");
        article.setContent("这是好消息的正文内容");
//        elasticSearchDao.save(article);
        elasticSearchDao.index(article);
    }

    /**
     * 查询所有
     */
    @Test
    public void fun2(){
        Iterable<Article> articles = elasticSearchDao.findAll();
        System.out.println("----------------------------------------");
        articles.forEach(item -> System.out.println(item));
        System.out.println("----------------------------------------");
    }

    /**
     * 根据指定的id进行查询
     */
    @Test
    public void fun3(){
        Optional<Article> article = elasticSearchDao.findById(1);
        System.out.println("------------------------------------");
        System.out.println(article.get());
        System.out.println("------------------------------------");
    }

    /**
     * 根据指定的id进行查询
     */
    @Test
    public void fun4(){
        List<Article> articles = elasticSearchDao.findByTitleLike("好消");
        System.out.println("------------------------------------");
        articles.forEach(item -> System.out.println(item));
        System.out.println("------------------------------------");
    }
}
