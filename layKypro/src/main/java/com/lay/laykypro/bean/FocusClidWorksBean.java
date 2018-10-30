package com.lay.laykypro.bean;

import java.util.List;

public class FocusClidWorksBean<T> {
    public boolean adExist;
    public int count;
    public List<ItemBean<T>> itemList;
    public String nextPageUrl;
    public int total;

    public static class ItemBean<T> {
        public int adIndex;
        public T data;
        public int id;
        public String type;

    }
}
