package com.training.app.dao.jdbc;

import com.training.app.dao.base.TripDao;
import com.training.app.model.Place;
import com.training.app.model.Trip;
import com.training.app.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTripDao implements TripDao {

    @Override
    public List<Trip> findAll() {
        List<Trip> tripList = new ArrayList<>();
        String query = "SELECT t.id, t.price, p1.id departure_id, p1.name departure_name, p2.id arrival_id, p2.name arrival_name FROM Trip t JOIN Place p1 ON p1.id = t.id JOIN Place p2 ON p2.id = t.id";
        try (PreparedStatement pst = ConnectionManager.getConnection().prepareStatement(query)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Trip trip = mapToTrip(rs);
                tripList.add(trip);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tripList;
    }


    private Trip mapToTrip(ResultSet rs) throws SQLException {
        Trip trip = new Trip();
        trip.setId(rs.getLong("id"));
        trip.setPrice(rs.getLong("price"));

        Place departurePlace = new Place();
        departurePlace.setId(rs.getLong("departure_id"));
        departurePlace.setName(rs.getString("departure_name"));
        trip.setDeparture(departurePlace);

        Place arrivalPlace = new Place();
        arrivalPlace.setId(rs.getLong("arrival_id"));
        arrivalPlace.setName(rs.getString("arrival_name"));
        trip.setArrival(arrivalPlace);
        return trip;
    }

    @Override
    public Long create(Trip object) {
        return null;
    }

    @Override
    public Trip findById(Long aLong) {
        return null;
    }

    @Override
    public boolean update(Trip object) {
        return false;
    }


}
