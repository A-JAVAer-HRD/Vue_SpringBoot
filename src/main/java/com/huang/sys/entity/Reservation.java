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
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String rId;

    private LocalDateTime rTime;

    private String uId;

    private String vin;

    private String state;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }
    public LocalDateTime getrTime() {
        return rTime;
    }

    public void setrTime(LocalDateTime rTime) {
        this.rTime = rTime;
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
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Reservation{" +
            "rId=" + rId +
            ", rTime=" + rTime +
            ", uId=" + uId +
            ", vin=" + vin +
            ", state=" + state +
        "}";
    }
}
