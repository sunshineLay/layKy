package com.lay.laykypro.bean.text;

import com.google.gson.Gson;

public class VideoTextItemBean {

    /**
     * actionUrl :
     * dataType : TextCard
     * id : 0
     * text : 相关推荐
     * type : header4
     */

    public String actionUrl;
    public String dataType;
    public int id;
    public String text;
    public String type;

    public String getActionUrl() {
        return actionUrl;
    }

    public String getDataType() {
        return dataType;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        String toJson = new Gson().toJson(new VideoTextItemBean());
        return toJson;
    }
}
