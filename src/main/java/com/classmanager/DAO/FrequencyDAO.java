package com.classmanager.DAO;

import com.classmanager.model.Class;
import com.classmanager.model.Frequency;
import com.classmanager.model.Student;
import com.classmanager.model.Timetable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
public class FrequencyDAO extends BaseDAO {
    private Connection con = getConection();
    private StudentDAO studentDAO = new StudentDAO();
    private ClassDAO classDAO = new ClassDAO();

    public Frequency register(Frequency frequency) {
        String sql = "INSERT INTO frequency (day, present, student_id, class_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, Date.valueOf(frequency.getDay()));
            pstmt.setBoolean(2, frequency.isPresent());
            pstmt.setLong(3, frequency.getStudent().getId());
            pstmt.setLong(4, frequency.getaClass().getId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();

                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    frequency.setId((long) generatedId);
                }

                return frequency;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(Frequency frequency) {
        String sql = "UPDATE frequency SET day = ?, present = ? WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, frequency.getDay().toString());
            pstmt.setBoolean(2, frequency.isPresent());
            pstmt.setLong(3, frequency.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM frequency WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Frequency getById(Long id) {
        String sql = "SELECT * FROM frequency WHERE id = ?";
        Frequency frequency = new Frequency();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                frequency.setId(rs.getLong("id"));
                frequency.setDay(rs.getDate("day").toLocalDate());
                frequency.setPresent(rs.getBoolean("present"));

                Student student = studentDAO.findStudentsByUser(frequency.getStudent().getUser());

                return frequency;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
