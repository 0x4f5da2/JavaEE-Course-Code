package com.chenzhicheng.course.javaee.exp3_1.model;

import java.io.Serializable;

public class OneWeekHistoryBean implements Serializable {
    private String productcode;
    private String productname;
    private String productsource;
    private String shopdate;

    public OneWeekHistoryBean(String productcode, String productname, String productsource, String shopdate) {
        this.productcode = productcode;
        this.productname = productname;
        this.productsource = productsource;
        this.shopdate = shopdate;
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

    public String getShopdate() {
        return shopdate;
    }

    public void setShopdate(String shopdate) {
        this.shopdate = shopdate;
    }
}




