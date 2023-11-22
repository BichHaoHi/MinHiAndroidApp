package com.example.projecthk1_2023_2024.model;

import java.util.Date;

public class Export {
    private Date cteate_date;
    private String status_order;
    private String status_product;
    private boolean enable;
    private Date success_date;
    private String id_product;
    private String id_customer_confirm;
    public Export(){}

    public Export(Date cteate_date, String status_order, String status_product, boolean enable, Date success_date, String id_product, String id_customer_confirm) {
        this.cteate_date = cteate_date;
        this.status_order = status_order;
        this.status_product = status_product;
        this.enable = enable;
        this.success_date = success_date;
        this.id_product = id_product;
        this.id_customer_confirm = id_customer_confirm;
    }

    public Date getCteate_date() {
        return cteate_date;
    }

    public void setCteate_date(Date cteate_date) {
        this.cteate_date = cteate_date;
    }

    public String getStatus_order() {
        return status_order;
    }

    public void setStatus_order(String status_order) {
        this.status_order = status_order;
    }

    public String getStatus_product() {
        return status_product;
    }

    public void setStatus_product(String status_product) {
        this.status_product = status_product;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getSuccess_date() {
        return success_date;
    }

    public void setSuccess_date(Date success_date) {
        this.success_date = success_date;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getId_customer_confirm() {
        return id_customer_confirm;
    }

    public void setId_customer_confirm(String id_customer_confirm) {
        this.id_customer_confirm = id_customer_confirm;
    }
}
