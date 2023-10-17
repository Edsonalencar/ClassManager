package com.classmanager.DAO;

import com.classmanager.enums.DisciplineStatus;
import com.classmanager.model.Class;
import com.classmanager.model.Discipline;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplineDAO extends BaseDAO {
    private Connection con = getConection();

    public void register(Discipline discipline) {
        String sql = "INSERT INTO discipline (name, code, status) VALUES (?, ?, ?);";

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
        String sql = "UPDATE discipline SET name = ?, code = ?, status = ? WHERE id = ?;";

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
        String sql = "DELETE FROM discipline WHERE id = ?;";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Discipline>  getByName(String name) {
        String sql = "SELECT * FROM discipline WHERE name LIKE ?;";
        List<Discipline> disciplines = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1,  "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getLong("id"));
                discipline.setName(rs.getString("name"));
                discipline.setCode(rs.getString("code"));
                discipline.setStatus(DisciplineStatus.valueOf(rs.getString("status")));

                disciplines.add(discipline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disciplines;
    }

    public List<Discipline>  getByStatus(DisciplineStatus status) {
        String sql = "SELECT * FROM discipline WHERE status = ?;";
        List<Discipline> disciplines = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1,  status.toString());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getLong("id"));
                discipline.setName(rs.getString("name"));
                discipline.setCode(rs.getString("code"));
                discipline.setStatus(DisciplineStatus.valueOf(rs.getString("status")));

                disciplines.add(discipline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disciplines;
    }

    public List<Discipline>  getByCode(String code) {
        String sql = "SELECT * FROM discipline WHERE code LIKE ?;";
        List<Discipline> disciplines = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1,  "%" + code + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getLong("id"));
                discipline.setName(rs.getString("name"));
                discipline.setCode(rs.getString("code"));
                discipline.setStatus(DisciplineStatus.valueOf(rs.getString("status")));

                disciplines.add(discipline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disciplines;
    }

    public  List<Discipline> getAll() {
        String sql = "SELECT * FROM discipline;";
        List<Discipline> disciplines = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getLong("id"));
                discipline.setName(rs.getString("name"));
                discipline.setCode(rs.getString("code"));
                discipline.setStatus(DisciplineStatus.valueOf(rs.getString("status")));

                disciplines.add(discipline);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disciplines;
    }
}

