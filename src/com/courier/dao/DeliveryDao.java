package com.courier.dao;

import com.courier.model.Delivery;
import com.courier.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDao {
    private Connection connection;

    public DeliveryDao() {
        connection = DBConnection.getConnection();
    }

    public void scheduleDelivery(Delivery delivery) {
        String query = "INSERT INTO Delivery(parcel_id, customer_id, delivery_date, delivery_status, delivery_cost) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, delivery.getParcelId());
            ps.setInt(2, delivery.getCustomerId());
            ps.setDate(3, new java.sql.Date(delivery.getDeliveryDate().getTime()));
            ps.setString(4, delivery.getDeliveryStatus());
            ps.setDouble(5, delivery.getDeliveryCost());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDeliveryStatus(int deliveryId, String status) {
        String query = "UPDATE Delivery SET delivery_status=? WHERE delivery_id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, status);
            ps.setInt(2, deliveryId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Delivery> getDeliveryHistory() {
        List<Delivery> deliveries = new ArrayList<>();
        String query = "SELECT * FROM Delivery";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Delivery delivery = new Delivery();
                delivery.setDeliveryId(rs.getInt("delivery_id"));
                delivery.setParcelId(rs.getInt("parcel_id"));
                delivery.setCustomerId(rs.getInt("customer_id"));
                delivery.setDeliveryDate(rs.getDate("delivery_date"));
                delivery.setDeliveryStatus(rs.getString("delivery_status"));
                delivery.setDeliveryCost(rs.getDouble("delivery_cost"));
                deliveries.add(delivery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveries;
    }
}
