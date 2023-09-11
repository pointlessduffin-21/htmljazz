package com.Group1.MealsOnWheels.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meal_Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mo_id;
    private String order_number;
    private Long m_id;
    private Long u_id;
    private String p_id;
    private String v_id;
    private String a_id;
    private String order_date;
    private String to_address;
    private String from_address;
    private String status;

    public Meal_Order() {

    }

    public Meal_Order(Long mo_id, String order_number, Long m_id, Long u_id, String p_id, String v_id, String a_id,
                      String order_date, String to_address, String from_address, String status) {
        super();
        this.mo_id = mo_id;
        this.order_number = order_number;
        this.m_id = m_id;
        this.u_id = u_id;
        this.p_id = p_id;
        this.v_id = v_id;
        this.a_id = a_id;
        this.order_date = order_date;
        this.to_address = to_address;
        this.from_address = from_address;
        this.status = status;
    }
    public Long getMo_id() {
        return mo_id;
    }
    public void setMo_id(Long mo_id) {
        this.mo_id = mo_id;
    }
    public String getOrder_number() {
        return order_number;
    }
    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }
    public Long getM_id() {
        return m_id;
    }
    public void setM_id(Long m_id) {
        this.m_id = m_id;
    }
    public Long getU_id() {
        return u_id;
    }
    public void setU_id(Long u_id) {
        this.u_id = u_id;
    }
    public String getP_id() {
        return p_id;
    }
    public void setP_id(String p_id) {
        this.p_id = p_id;
    }
    public String getV_id() {
        return v_id;
    }
    public void setV_id(String v_id) {
        this.v_id = v_id;
    }
    public String getA_id() {
        return a_id;
    }
    public void setA_id(String a_id) {
        this.a_id = a_id;
    }
    public String getOrder_date() {
        return order_date;
    }
    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
    public String getTo_address() {
        return to_address;
    }
    public void setTo_address(String to_address) {
        this.to_address = to_address;
    }
    public String getFrom_address() {
        return from_address;
    }
    public void setFrom_address(String from_address) {
        this.from_address = from_address;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}


