package com.chenzhicheng.course.javaee.exp3_1.model;

import java.io.Serializable;

public class ProductBean implements Serializable {
    private String productcode;
    private String productname;
    private String productsource;
    private String productid;

    public ProductBean(String productcode, String productname, String productsource, String productid) {
        this.productcode = productcode;
        this.productname = productname;
        this.productsource = productsource;
        this.productid = productid;
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

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }
}
