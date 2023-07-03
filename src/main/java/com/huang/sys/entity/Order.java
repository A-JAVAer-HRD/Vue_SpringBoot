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
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String oId;

    private LocalDateTime saleTime;

    private String uId;

    private String vin;

    private String mId;

    private String amount;

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }
    public LocalDateTime getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(LocalDateTime saleTime) {
        this.saleTime = saleTime;
    }
    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
            "oId=" + oId +
            ", saleTime=" + saleTime +
            ", uId=" + uId +
            ", vin=" + vin +
            ", mId=" + mId +
            ", amount=" + amount +
        "}";
    }
}
