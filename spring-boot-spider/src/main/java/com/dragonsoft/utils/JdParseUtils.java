package com.dragonsoft.utils;

import com.dragonsoft.domain.GoodsModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/11/14 16:51
 */
public class JdParseUtils {
    public static List<GoodsModel> getData(String html, String keyword) {
        //获取的数据，存放在集合中
        List<GoodsModel> data = new ArrayList<GoodsModel>();
        //采用Jsoup解析
        Document doc = Jsoup.parse(html);
        //采取html标签中的内容
        Elements elements = doc.select("li[class=gl-item]");
        for (Element ele : elements) {
            String itemId = ele.attr("data-sku");
            String itemPrice = ele.select("div[class=p-price]").select("strong").select("i").text();
            //书籍类产品
            String itemName = ele.select("div[class~=p-name?]").select("em").text();
            String commentNumber = ele.select("div[class=p-commit]").text();
            //本来是要获取图片的url但是未获取到，使用a标签里面的href代替
            String imgurl =ele.select("div[class=p-img]").select("a").attr("href");
            boolean b=imgurl.startsWith("https:");
            if(b==false){
                imgurl="https:"+imgurl;
            };
            String itemurl = "https://item.jd.com/" + itemId + ".html";
            String type = keyword;
            String shopname = "";
            String shopurl = "";
            if (ele.select("div[class=p-shop]").select("a[class=curr-shop]").text().length() != 0) {
                shopname = ele.select("div[class=p-shop]").select("a[class=curr-shop]").text();
                shopurl = "https:" + ele.select("div[class=p-shop]").select("a[class=curr-shop]").attr("href");
            } else {
                shopname = "京东自营";
                shopurl = "https://mall.jd.com/index-" + ele.select("div[class=p-shop]").attr("data-shopid") + ".html";
            }
            String crawl_time = TimeUtils.GetNowDate("yyyy-MM-dd HH:mm:ss");
            //创建一个对象，这里可以看出，使用Model的优势，直接进行封装
            GoodsModel jdModel = new GoodsModel();
            //对象的值
            jdModel.setItemId(itemId);
            jdModel.setItemName(itemName);
            jdModel.setItemPrice(itemPrice);
            jdModel.setCommentNumber(commentNumber);
            jdModel.setItemImgUrl(imgurl);
            jdModel.setItemUrl(itemurl);
            jdModel.setShopName(shopname);
            jdModel.setShopUrl(shopurl);
            jdModel.setCrawlerTime(crawl_time);
            jdModel.setType(type);
            //将每一个对象的值，保存到List集合中
            data.add(jdModel);
        }
        return data;
    }
}
