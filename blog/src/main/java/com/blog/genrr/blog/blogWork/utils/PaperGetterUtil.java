package com.blog.genrr.blog.blogWork.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.genrr.blog.blogWork.entity.Papers;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author nsplnpbjy
 */
@Slf4j
public class PaperGetterUtil {

    public static void saver(BaseMapper baseMapper,String paperName,String html,String auth){
        Papers papers = new Papers(paperName,html,auth);
        if (baseMapper.selectOne(new LambdaQueryWrapper<Papers>().eq(Papers::getName,paperName).and(wrapper->wrapper.eq(Papers::getAuth,auth)))==null){
            baseMapper.insert(papers);
        }
        else {
            log.info("已避免重复下载: "+paperName);
        }
    }

    //马列通用（有文集网页）
    public static void paperGetter(BaseMapper baseMapper,String url,String auth){
        Document document = null;
        try{
            document = Jsoup.connect(url).get();
        } catch (Exception e) {
            log.warn("主站连接失败");
            return;
        }
        Element div = document.select("div").first();
        Element innerDiv = div.select("div").first();
        Element table = innerDiv.selectFirst("table");
        Elements as = table.select("a[href]");
        String href = url.substring(0,url.lastIndexOf('/')+1);
        for (Element a :
                as) {
                String nextHref = href+a.attr("href");
                Document innerDocument = null;
                try{
                    innerDocument = Jsoup.connect(nextHref).get();
                } catch (Exception e) {
                    log.warn("连接失败: "+nextHref);
                    break;
                }
                Elements paperAs = innerDocument.select("a[href]");
                Elements temPaperAs = new Elements();
                for (int i = 0;i<4;i++){
                    temPaperAs.add(paperAs.get(i));
                }
                paperAs.removeAll(temPaperAs);
            for (Element paper :
                    paperAs) {
                Document paperDoc = null;
                String paperName = paper.text();
                paperName = paperName.replace("…","");
                String nextNextHref = nextHref.replace("index.htm","")+paper.attr("href");
                try{
                    paperDoc = Jsoup.connect(nextNextHref).get();
                } catch (Exception e) {
                    log.warn("连接失败: "+nextNextHref);
                    break;
                }
                String imgMainUrl = nextNextHref.substring(0,nextNextHref.lastIndexOf("/")+1);
                Elements imgs = paperDoc.select("img[src]");
                for (Element img :
                        imgs) {
                    img.attr("src",imgMainUrl+img.attr("src"));
                    log.info("图片地址已修改为: "+img.attr("src"));
                }
                log.info("正在下载:"+paperName);
                PaperGetterUtil.saver(baseMapper,paperName, paperDoc.html(),auth);
            }

        }

    }

    //无文集网页通用
    //待编写
    //
}
