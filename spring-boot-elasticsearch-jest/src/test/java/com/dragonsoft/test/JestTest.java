package com.dragonsoft.test;

import com.dragonsoft.domain.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author ronin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JestTest {

    @Autowired
    private JestClient jestClient;

    /**
     * 给ES中添加数据
     * @throws IOException
     */
    @Test
    public void fun1() throws IOException {
        //给Es中索引,保存一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAutor("张三");
        article.setContent("这是好消息的正文内容");
        Index index = new Index.Builder(article).index("test").type("news").build();
        //执行保存索引
        jestClient.execute(index);
    }

    /**
     * 从ES中查询数据
     * @throws IOException
     */
    @Test
    public void fun2() throws IOException {
        // 查询表达式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"好\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        // 构建搜索操作
        Search search = new Search.Builder(json).addIndex("test").addType("news").build();
        // 执行
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
            System.out.println("获取相关性得分:"+result.getMaxScore());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
