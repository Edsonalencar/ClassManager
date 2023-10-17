package com.classmanager.DAO;

import com.classmanager.model.Discipline;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DisciplineDAO extends BaseDAO {
    private Connection con = getConection();

    public void register(Discipline discipline) {
        String sql = "INSERT INTO discipline (name, code, status) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, discipline.getName());
            pstmt.setString(2, discipline.getCode());
            pstmt.setString(3, discipline.getStatus().toString());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Discipline discipline) {
        String sql = "UPDATE discipline SET name = ?, code = ?, status = ? WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, discipline.getName());
            pstmt.setString(2, discipline.getCode());
            pstmt.setString(3, discipline.getStatus().toString());
            pstmt.setLong(4, discipline.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM discipline WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Discipline get(String name) {
        String sql = "SELECT * FROM discipline WHERE name = ?";
        Discipline discipline = null;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                discipline = new Discipline();
                discipline.setId(rs.getLong("id"));
                discipline.setName(rs.getString("name"));
                discipline.setCode(rs.getString("code"));
                //discipline.setStatus(enums.DisciplineStatus.valueOf(rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return discipline;
    }

    public void getAll() {
        String sql = "SELECT * FROM discipline";
        Discipline discipline = null;

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

