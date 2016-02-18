package com.wengyingjian.weixin.common.enums;

/**
 * Created by wengyingjian on 16/2/18.
 */
public enum TuringResponseType {
    TEXT("100000", "文字"),
    LINK("200000", "链接"),
    NEWS("302000", "新闻"),
    COOKBOOK("308000", "菜谱"),

    ERROR_KEY("40001", "参数key错误"),
    ERROR_INFO_EMPTY("40002", "请求内容info为空"),
    ERROR_USE_OUT("40004", "当天请求次数已使用完"),
    ERROR_DATA_FORMAT("40007", "数据格式异常");


    private String code;
    private String desc;

    private TuringResponseType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
