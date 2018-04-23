package com.chenzhicheng.course.javaee.exp3_1.model;

import java.io.Serializable;

public class AllHistoryBean implements Serializable {
    private String productcode;
    private String productname;
    private String productsource;
    private String num;

    public AllHistoryBean(String productcode, String productname, String productsource, String num) {
        this.productcode = productcode;
        this.productname = productname;
        this.productsource = productsource;
        this.num = num;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductsource() {
        return productsource;
    }

    public void setProductsource(String productsource) {
        this.productsource = productsource;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
