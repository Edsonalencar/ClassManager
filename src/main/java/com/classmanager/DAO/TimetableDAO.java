package com.classmanager.DAO;

import com.classmanager.model.Timetable;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TimetableDAO extends BaseDAO {
    private Connection con = getConection();

    public void register(Timetable timetable) {
        String sql = "INSERT INTO timetable (start_time, end_time) VALUES (?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setObject(1, timetable.getStart_time());
            pstmt.setObject(2, timetable.getEnd_time());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}

