package com.courier.model;

import java.util.Date;

public class Delivery {
    private int deliveryId;
    private int parcelId;
    private int customerId;
    private Date deliveryDate;
    private String deliveryStatus;
    private double deliveryCost;

    // Getters and Setters
    public int getDeliveryId() { return deliveryId; }
    public void setDeliveryId(int deliveryId) { this.deliveryId = deliveryId; }
    public int getParcelId() { return parcelId; }
    public void setParcelId(int parcelId) { this.parcelId = parcelId; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public Date getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(Date deliveryDate) { this.deliveryDate = deliveryDate; }
    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }
    public double getDeliveryCost() { return deliveryCost; }
    public void setDeliveryCost(double deliveryCost) { this.deliveryCost = deliveryCost; }
}
