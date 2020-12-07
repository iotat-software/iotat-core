package cn.iotat.core.http;

import cn.iotat.core.bean.ToString;

import java.util.Collection;

public class PageResponse<T extends Collection<?>> extends BaseResponse<T> {

    private static final long serialVersionUID = -309914133460188848L;

    private PageInfo pageInfo = new PageInfo();

    public static <T extends Collection<?>> PageResponse<T> success(T data, int pageNo, int pageSize, int total) {
        PageResponse<T> response = (PageResponse<T>) BaseResponse.success(data);
        response.setPageNo(pageNo);
        response.setPageSize(pageSize);
        response.setTotal(total);
        int totalPage = total / pageSize;
        response.setTotalPage(totalPage);
        response.setHasNext(totalPage > pageNo);
        return response;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public int getPageNo() {
        return this.pageInfo.pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageInfo.pageNo = pageNo;
    }

    public int getPageSize() {
        return this.pageInfo.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageInfo.pageSize = pageSize;
    }

    public boolean isHasNext() {
        return this.pageInfo.hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.pageInfo.hasNext = hasNext;
    }

    public int getTotal() {
        return this.pageInfo.total;
    }

    public void setTotal(int total) {
        this.pageInfo.total = total;
    }

    public int getTotalPage() {
        return this.pageInfo.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.pageInfo.totalPage = totalPage;
    }

    private class PageInfo extends ToString {
        private int pageNo;
        private int pageSize;
        private boolean hasNext;
        private int total;
        private int totalPage;

    }
}
