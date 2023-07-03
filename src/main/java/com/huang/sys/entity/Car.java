package com.huang.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangrd
 * @since 2023-07-01
 */
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String vin;

    private String model;

    private String type;

    private String factory;

    private LocalDateTime inTime;

    private Double sellPrice;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }
    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }
    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
            "vin=" + vin +
            ", model=" + model +
            ", type=" + type +
            ", factory=" + factory +
            ", inTime=" + inTime +
            ", sellPrice=" + sellPrice +
        "}";
    }
}
