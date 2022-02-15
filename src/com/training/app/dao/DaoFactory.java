package com.training.app.dao;

import com.training.app.dao.base.PlaceDao;
import com.training.app.dao.base.TripDao;
import com.training.app.dao.jdbc.JdbcPlaceDao;
import com.training.app.dao.jdbc.JdbcTripDao;

public class DaoFactory {

    private DaoFactory() {
    }

    public static TripDao getTripDao() {
        return new JdbcTripDao();
    }

    public static PlaceDao getPlaceDao() {
        return new JdbcPlaceDao();
    }

}
