/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvcp.model;

/**
 *
 * @author Prasadi
 */
public class OrderDetailModel {
    
    private String orderId;
    private String ItemCode;
    private Integer qty;
    private Double discount;

    public OrderDetailModel() {
    }

    public OrderDetailModel(String orderId, String ItemCode, Integer qty, Double discount) {
        this.orderId = orderId;
        this.ItemCode = ItemCode;
        this.qty = qty;
        this.discount = discount;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the ItemCode
     */
    public String getItemCode() {
        return ItemCode;
    }

    /**
     * @param ItemCode the ItemCode to set
     */
    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    /**
     * @return the qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    /**
     * @return the discount
     */
    public Double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetailModel{" + "orderId=" + orderId + ", ItemCode=" + ItemCode + ", qty=" + qty + ", discount=" + discount + '}';
    }
    
    
}
