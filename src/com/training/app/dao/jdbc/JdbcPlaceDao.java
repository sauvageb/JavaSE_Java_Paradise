package com.training.app.dao.jdbc;

import com.training.app.dao.base.PlaceDao;
import com.training.app.model.Place;
import com.training.app.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JdbcPlaceDao implements PlaceDao {

    @Override
    public Long create(Place place) {
        String query = "INSERT INTO Place(name) VALUES(?)";
        long autoIncrKey = -1L;
        try (PreparedStatement pst = ConnectionManager.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, place.getName());
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                autoIncrKey = rs.getLong(1);
            }
            rs.close();
            ConnectionManager.getConnection().commit();
        } catch (SQLException e) {
            try {
                ConnectionManager.getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return autoIncrKey;
    }

    @Override
    public Place findById(Long id) {
        return null;
    }

    @Override
    public boolean update(Place place) {
        return false;
    }

    @Override
    public List<Place> findAll() {
        return null;
    }
}
