package com.classmanager.DAO;

import com.classmanager.model.Address;
import com.classmanager.model.Student;
import com.classmanager.model.Timetable;
import com.classmanager.model.Usuario;

import java.sql.*;

import java.sql.Connection;

public class TimetableDAO extends BaseDAO {
    private Connection con = getConection();

    public Timetable register(Timetable timetable) {
        String sql = "INSERT INTO timetable (start_time, end_time) VALUES (?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setObject(1, timetable.getStart_time());
            pstmt.setObject(2, timetable.getEnd_time());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();

                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    timetable.setId((long) generatedId);
                }

                return timetable;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(Timetable timetable) {
        String sql = "UPDATE timetable SET start_time = ?, end_time = ? WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setObject(1, timetable.getStart_time());
            pstmt.setObject(2, timetable.getEnd_time());
            pstmt.setLong(3, timetable.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM timetable WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Timetable getById(Long id) {
        String sql = "SELECT * FROM timetable WHERE id = ?";
        Timetable tb = new Timetable();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                tb.setId(rs.getLong("id"));
                tb.setStart_time(rs.getDate("start_time").toLocalDate());
                tb.setEnd_time(rs.getDate("end_time").toLocalDate());

                return tb;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

