package com.courier.service;

import com.courier.dao.DeliveryDao;
import com.courier.model.Delivery;

import java.util.List;

public class DeliveryService {
    private DeliveryDao deliveryDAO;

    public DeliveryService() {
        deliveryDAO = new DeliveryDao();
    }

    public void scheduleDelivery(Delivery delivery) {
        deliveryDAO.scheduleDelivery(delivery);
    }

    public void updateDeliveryStatus(int deliveryId, String status) {
        deliveryDAO.updateDeliveryStatus(deliveryId, status);
    }

    public List<Delivery> getDeliveryHistory() {
        return deliveryDAO.getDeliveryHistory();
    }
}
