package com.training.app;

import com.training.app.dao.DaoFactory;
import com.training.app.dao.base.PlaceDao;
import com.training.app.model.Place;
import com.training.app.util.ConnectionManager;


public class Launcher {

    public static void main(String[] args) {
        PlaceDao placeDao = DaoFactory.getPlaceDao();
        Place newPlace = new Place("Tokyo");
        placeDao.create(newPlace);
        ConnectionManager.closeConnection();
    }
}
