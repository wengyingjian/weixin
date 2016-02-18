package com.wengyingjian.weixin.common.model;

import com.wengyingjian.weixin.common.model.generic.TuringResponseGereralMessage;

import java.io.Serializable;
import java.util.List;

/**
 * 回复菜谱
 * Created by wengyingjian on 16/2/18.
 */
public class TuringResponseCookbookMessage extends TuringResponseGereralMessage {

    private List<Cookbook> list;

    public static class Cookbook implements Serializable{

        private String name;//名称
        private String icon;//图标
        private String info;//原料
        private String detailurl;//详细说明链接

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getDetailurl() {
            return detailurl;
        }

        public void setDetailurl(String detailurl) {
            this.detailurl = detailurl;
        }
    }

    public List<Cookbook> getList() {
        return list;
    }

    public void setList(List<Cookbook> list) {
        this.list = list;
    }
}
