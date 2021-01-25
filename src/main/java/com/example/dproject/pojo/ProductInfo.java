package com.example.dproject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*实体类
* */
@Entity
@Table(name="product_info")
public class ProductInfo {
    @Id
    @Column(name = "product_id")
    private Integer productId;                   //id
    @Column(name = "product_name")
    private String productName;                 //商品名称
    @Column(name = "product_price")
    private Double productPrice;                //单价
    @Column(name = "product_stock")
    private Integer productStock;               //库存
    @Column(name = "product_description")
    private String productDescription;          //描述
    @Column(name = "product_icon")
    private String productIcon;                 //小图
    @Column(name = "product_status")
    private Integer productStatus;               //商品状态
    @Column(name = "category_type")
    private Integer categoryType;                 //类目编号
    @Column(name = "create_time")
    private String createTime;                  //创建时间
    @Column(name = "update_time")
    private String updateTime;                  //修改时间

    //get,set方法
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getProductType() {
        return categoryType;
    }

    public void setProductType(Integer productType) {
        this.categoryType = categoryType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
