package com.example.CollegeSearch3;

public class MetaData {

    private long total;
    private long page;
    private long per_page;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getPer_page() {
        return per_page;
    }

    public void setPer_page(long per_page) {
        this.per_page = per_page;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "total=" + total +
                ", page=" + page +
                ", per_page=" + per_page +
                '}';
    }
}
