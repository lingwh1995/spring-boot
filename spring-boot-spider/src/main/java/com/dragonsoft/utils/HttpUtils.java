package com.dragonsoft.utils;

import com.google.common.collect.Lists;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/11/14 16:50
 */
public class HttpUtils {
    public HttpEntity getEntityByHttpGetMethod(String url) {
        //初始化httpclient
        HttpClient httpClient = HttpClients.custom().build();
        //使用的请求方法
        HttpGet httpget = new HttpGet(url);
        //请求头配置
        httpget.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        httpget.setHeader("Accept-Encoding", "gzip, deflate");
        httpget.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        httpget.setHeader("Cache-Control", "max-age=0");
        //这项内容很重要
        httpget.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36");
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpget);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取网页内容流
        HttpEntity httpEntity = response.getEntity();
        return httpEntity;
    }

    public String getHTMLContentByHttpGetMethod(String url, String code) {
        //获取Html内容
        try {
            return EntityUtils.toString(getEntityByHttpGetMethod(url), code);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 请求页面html文件
     * @param keyword 关键字
     * @param currentPage 当前页码
     * @param firstprice
     * @param endprive
     * @return
     * @throws URISyntaxException
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String getRawHtml(String keyword, int currentPage, int firstprice, int endprive) throws URISyntaxException, IOException {
        int page = currentPage * 2 - 1;
        String url = "https://search.jd.com/s_new.php";
        List<NameValuePair> nameAndValueList = new ArrayList<NameValuePair>();
        nameAndValueList.add(new BasicNameValuePair("keyword", keyword));
        nameAndValueList.add(new BasicNameValuePair("enc", "utf-8"));
        nameAndValueList.add(new BasicNameValuePair("qrst", "1"));
        nameAndValueList.add(new BasicNameValuePair("rt", "1"));
        nameAndValueList.add(new BasicNameValuePair("stop", "1"));
        nameAndValueList.add(new BasicNameValuePair("vt", "2"));
        nameAndValueList.add(new BasicNameValuePair("wq", keyword));
        nameAndValueList.add(new BasicNameValuePair("ev", "exprice_" + firstprice + "-" + endprive + "^"));
        nameAndValueList.add(new BasicNameValuePair("uc", "0"));
        nameAndValueList.add(new BasicNameValuePair("page", page + ""));
        URI uri = new URIBuilder(url).addParameters(nameAndValueList).build();
        HttpClientContext httpClientContext = HttpClientContext.create();
        //请求头添加
        List<Header> headerList = Lists.newArrayList();
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9," +
                "image/webp,image/apng,*/*;q=0.8"));
        headerList.add(new BasicHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"));
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate"));
        headerList.add(new BasicHeader(HttpHeaders.CACHE_CONTROL, "max-age=0"));
        headerList.add(new BasicHeader(HttpHeaders.CONNECTION, "keep-alive"));
        headerList.add(new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4,ja;q=0.2," +
                "de;q=0.2"));
        headerList.add(new BasicHeader(HttpHeaders.HOST, "search.jd.com"));
        headerList.add(new BasicHeader(HttpHeaders.REFERER, "https://search.jd.com/search"));
        //httpClient初始化
        HttpClient httpClient = HttpClients.custom().setDefaultHeaders(headerList).build();
        //获取响应内容
        HttpUriRequest httpUriRequest = RequestBuilder.get().setUri(uri).build();
        httpClient.execute(httpUriRequest, httpClientContext);
        HttpResponse httpResponse = httpClient.execute(httpUriRequest, httpClientContext);
        //获取返回结果中的实体
        HttpEntity entity = httpResponse.getEntity();
        return "<html>" + EntityUtils.toString(entity) + "</html>";
    }
}

