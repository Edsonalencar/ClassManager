package com.classmanager.DAO;

import com.classmanager.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO extends BaseDAO {
    private Connection con = getConection();

    public Address create(Address address) {
        String sql = "INSERT INTO address (city, state, district, number) VALUES (?, ?, ?, ?);";

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, address.getCity());
            pstmt.setString(2, address.getState());
            pstmt.setString(3, address.getDistrict());
            pstmt.setInt(4, address.getNumber());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    address.setId((long) generatedId);
                    return address;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Address update(Address address) {
        String sql = "UPDATE address SET city = ?, state = ?, district = ?, number = ? WHERE id = ?;";

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, address.getCity());
            pstmt.setString(2, address.getState());
            pstmt.setString(3, address.getDistrict());
            pstmt.setInt(4, address.getNumber());
            pstmt.setLong(5, address.getId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    address.setId((long) generatedId);
                    return address;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM address WHERE id = ?;";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Address getById(Long id) {
        String sql = "SELECT * FROM address WHERE id = ?;";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Address address = new Address();
                address.setId(rs.getLong("id"));
                address.setCity(rs.getString("city"));
                address.setState(rs.getString("state"));
                address.setDistrict(rs.getString("district"));
                address.setNumber(rs.getInt("number"));

                return address;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Address> getAll() {
        String sql = "SELECT * FROM address;";
        List<Address> addresses = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Address address = new Address();
                address.setId(rs.getLong("id"));
                address.setCity(rs.getString("city"));
                address.setState(rs.getString("state"));
                address.setDistrict(rs.getString("district"));
                address.setNumber(rs.getInt("number"));

                addresses.add(address);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addresses;
    }

    public int getAddressIdIfExists(Address address) {
        String sql = "SELECT id " +
                "FROM address " +
                "WHERE city = ? AND state = ? AND district = ? AND number = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, address.getCity());
            pstmt.setString(2, address.getState());
            pstmt.setString(3, address.getDistrict());
            pstmt.setInt(4, address.getNumber());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}