package com.dragonsoft.service;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/11/14 16:52
 */
public interface SpiderService {
    /**
     * 爬取数据
     * @param word 关键字
     * @param lowPrice  最低价格
     * @param highPrice 最高价格
     * @param totalPages 爬取的总页数
     * @return
     */
    int gather(String word, int lowPrice, int highPrice, int totalPages);
}
