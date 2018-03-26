package com.chen.ssm.po;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.chen.ssm.utils.group.GroupA;
import com.chen.ssm.utils.group.GroupB;

public class Items {
    private Integer id;

    @Size(min=1,max=10,message="{items.name.length.error}",groups={GroupA.class}) // 名称在1-10字符之间
    private String name;

    private Float price;

    private String pic;

    @NotNull(message="{items.createtime.is.null}",groups={GroupB.class}) // 创建日期不能为空
    private Date createtime;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}