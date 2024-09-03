package com.courier.service;

import com.courier.dao.ParcelDao;
import com.courier.model.Parcel;

import java.util.List;

public class ParcelService {
    private ParcelDao parcelDAO;

    public ParcelService() {
        parcelDAO = new ParcelDao();
    }

    public void addParcel(Parcel parcel) {
        parcelDAO.addParcel(parcel);
    }

    public List<Parcel> getAllParcels() {
        return parcelDAO.getAllParcels();
    }

    public void updateParcel(Parcel parcel) {
        parcelDAO.updateParcel(parcel);
    }

    public void deleteParcel(int parcelId) {
        parcelDAO.deleteParcel(parcelId);
    }
}
