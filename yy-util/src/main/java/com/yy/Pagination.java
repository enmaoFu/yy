package com.yy;

import org.springframework.util.StringUtils;

/**
 * 分页
 *
 * @author Administrator
 */
public class Pagination {

    /**
     * 总页数
     */
    private Integer pageNum;

    /**
     * 总条数
     */
    private Integer total;

    /**
     * 当前页码
     */
    private Integer start;

    /**
     * 显示条数
     */
    private Integer display;


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }


    public static Pagination setPagingValue(int start, int display, int total) {
        Pagination pagination = new Pagination();
        // 总页数
        int pageNum = 0;
        if (StringUtils.isEmpty(start)) {
            start = 0;
        }
        if (StringUtils.isEmpty(display)) {
            display = 0;
        }
        if (StringUtils.isEmpty(total)) {
            total = 0;
        }
        if (display > 0) {
            if (total % display > 0) {
                pageNum = total / display + 1;
            } else {
                pageNum = total / display;
            }
        }
        pagination.setTotal(total);
        pagination.setStart(start);
        pagination.setDisplay(display);
        pagination.setPageNum(pageNum);
        return pagination;
    }


}
