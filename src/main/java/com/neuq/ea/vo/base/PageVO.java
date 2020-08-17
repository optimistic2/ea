package com.neuq.ea.vo.base;


import java.util.List;

public class PageVO<T> extends BaseVO {

    private int pageNum;
    private int pageSize;
    private int total;
    private boolean hasMore;

    private List<T> data;

    public PageVO() {
    }

    public PageVO(List<T> data) {
        this.data = data;
    }

    public PageVO(int pageNum, int pageSize, int total, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}