package com.dragonsoft.service;
import com.dragonsoft.domain.GoodsModel;
import com.dragonsoft.utils.HttpUtils;
import com.dragonsoft.utils.JdParseUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/11/14 16:52
 */
@Service
public class SpiderServiceImpl implements SpiderService {

    /**
     * 爬取数据
     * @param keyword 关键字
     * @param lowPrice  最低价格
     * @param highPrice 最高价格
     * @param totalPages 爬取的总页数
     * @return
     */
    @Override
    public int gather(String keyword, int lowPrice, int highPrice, int totalPages) {
        for (int i = 1; i <= totalPages; i++) {
            String html = null;
            try {
                html = HttpUtils.getRawHtml(keyword, i, lowPrice, highPrice);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<GoodsModel> dataslist = JdParseUtils.getData(html, keyword);
            //循环输出抓取的数据
            for (GoodsModel jd : dataslist) {
                System.out.println("itemId:" + jd.getItemId() + "\t" + "itemName:" + jd.getItemName() + "\t" + "itemPrice:" + jd.getItemPrice() + "\tcommentnumber:" + jd.getCommentNumber() +"\timgurl:"+jd.getItemImgUrl()+ "\titemurl:" + jd.getItemUrl() + "\tshopname:" + jd.getShopName() + "\tshopurl:" + jd.getShopUrl() + "\tcrawl_time:" + jd.getCrawlerTime()+"\ttype:"+jd.getType());
            }
        }
        return 0;
    }
}
