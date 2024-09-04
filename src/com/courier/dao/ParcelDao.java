package com.courier.dao;

import com.courier.model.Parcel;
import com.courier.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParcelDao {
    private Connection connection;

    public ParcelDao() {
        connection = DBConnection.getConnection();
        if (connection == null) {
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    public void addParcel(Parcel parcel) {
        String query = "INSERT INTO Parcel(sender_name, sender_address, recipient_name, recipient_address, weight, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, parcel.getSenderName());
            ps.setString(2, parcel.getSenderAddress());
            ps.setString(3, parcel.getRecipientName());
            ps.setString(4, parcel.getRecipientAddress());
            ps.setDouble(5, parcel.getWeight());
            ps.setString(6, parcel.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Parcel> getAllParcels() {
        List<Parcel> parcels = new ArrayList<>();
        String query = "SELECT * FROM Parcel";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Parcel parcel = new Parcel();
                parcel.setParcelId(rs.getInt("parcel_id"));
                parcel.setSenderName(rs.getString("sender_name"));
                parcel.setSenderAddress(rs.getString("sender_address"));
                parcel.setRecipientName(rs.getString("recipient_name"));
                parcel.setRecipientAddress(rs.getString("recipient_address"));
                parcel.setWeight(rs.getDouble("weight"));
                parcel.setStatus(rs.getString("status"));
                parcels.add(parcel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        // Print all parcels
//        for (Parcel parcel : parcels) {
//            System.out.println("Parcel ID: " + parcel.getParcelId());
//            System.out.println("Sender Name: " + parcel.getSenderName());
//            System.out.println("Sender Address: " + parcel.getSenderAddress());
//            System.out.println("Recipient Name: " + parcel.getRecipientName());
//            System.out.println("Recipient Address: " + parcel.getRecipientAddress());
//            System.out.println("Weight: " + parcel.getWeight());
//            System.out.println("Status: " + parcel.getStatus());
//            System.out.println("-----------------------------");
//        }
        // Print all parcels using toString method
//        for (Parcel parcel : parcels) {
//            System.out.println(parcel);
//        }

        return parcels;
    }

    public void updateParcel(Parcel parcel) {
        String query = "UPDATE Parcel SET sender_name=?, sender_address=?, recipient_name=?, recipient_address=?, weight=?, status=? WHERE parcel_id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, parcel.getSenderName());
            ps.setString(2, parcel.getSenderAddress());
            ps.setString(3, parcel.getRecipientName());
            ps.setString(4, parcel.getRecipientAddress());
            ps.setDouble(5, parcel.getWeight());
            ps.setString(6, parcel.getStatus());
            ps.setInt(7, parcel.getParcelId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteParcel(int parcelId) {
        String query = "DELETE FROM Parcel WHERE parcel_id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, parcelId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
