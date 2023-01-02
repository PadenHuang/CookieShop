package model;

import java.util.List;

public class Page {
    private int pageNumber; //页码
    private int pageSize;   //页码大小——设置每页可以放置多少个订单
    private int totalCount;  //总订单数
    private int totalPage;  //总页数

    private List<Object> list; //订单集合

    public void SetPageSizeAndTotalCount(int pageSize,int totalCount)
    {
        this.pageSize=pageSize;
        this.totalCount=totalCount;
        totalPage= (int)Math.ceil((double)totalCount/pageSize); //Java Math.ceil() 方法可对一个数进行上舍入，返回值大于或等于给定的参数，俗称 天花板取整
    }
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Object> getList() {
        return list;
    }

    //page里面设置存放订单
    public void setList(List<Object> list) {
        this.list = list;
    }
}
