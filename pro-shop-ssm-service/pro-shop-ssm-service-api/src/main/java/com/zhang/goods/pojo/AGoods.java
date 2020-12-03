package com.zhang.goods.pojo;

import java.util.Date;

/**
 * 商品的Pojo
 */
public class AGoods
{
    private int id;
    private int cateId;
    private String title;
    private String name;
    private String brief;
    private double price;
    private int stockNum;
    private int saleNum;
    private String listImg;
    private String content;
    private byte status;
    private Date createTime;
    private Date updateTime;
    private Date pubTime;

    /* 关联关系 */
    private ACate cate ;

    public ACate getCate() {
        return cate;
    }

    public void setCate(ACate cate) {
        this.cate = cate;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getCateId()
    {
        return cateId;
    }

    public void setCateId(int cateId)
    {
        this.cateId = cateId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBrief()
    {
        return brief;
    }

    public void setBrief(String brief)
    {
        this.brief = brief;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getStockNum()
    {
        return stockNum;
    }

    public void setStockNum(int stockNum)
    {
        this.stockNum = stockNum;
    }

    public int getSaleNum()
    {
        return saleNum;
    }

    public void setSaleNum(int saleNum)
    {
        this.saleNum = saleNum;
    }

    public String getListImg()
    {
        return listImg;
    }

    public void setListImg(String listImg)
    {
        this.listImg = listImg;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public byte getStatus()
    {
        return status;
    }

    public void setStatus(byte status)
    {
        this.status = status;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public Date getPubTime()
    {
        return pubTime;
    }

    public void setPubTime(Date pubTime)
    {
        this.pubTime = pubTime;
    }
}
