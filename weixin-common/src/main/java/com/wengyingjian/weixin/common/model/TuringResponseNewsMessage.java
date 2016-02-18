package com.wengyingjian.weixin.common.model;

import com.wengyingjian.weixin.common.model.generic.TuringResponseGereralMessage;

import java.io.Serializable;
import java.util.List;

/**
 * 回复新闻
 * Created by wengyingjian on 16/2/18.
 */
public class TuringResponseNewsMessage extends TuringResponseGereralMessage {

    private List<News> list;

    public static class News implements Serializable{
        private String article;//文章标题
        private String source;//来源
        private String icon;//图标
        private String detailurl;//详细信息url

        public String getArticle() {
            return article;
        }

        public void setArticle(String article) {
            this.article = article;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getDetailurl() {
            return detailurl;
        }

        public void setDetailurl(String detailurl) {
            this.detailurl = detailurl;
        }
    }

    public List<News> getList() {
        return list;
    }

    public void setList(List<News> list) {
        this.list = list;
    }
}
