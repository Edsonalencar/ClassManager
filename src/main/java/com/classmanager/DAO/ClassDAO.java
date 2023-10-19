package com.classmanager.DAO;

import com.classmanager.enums.ClassStatus;
import com.classmanager.model.*;
import com.classmanager.model.Class;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO extends BaseDAO {
    private Connection con = getConection();
    private TimetableDAO timetableDAO = new TimetableDAO();
    private DisciplineDAO disciplineDAO = new DisciplineDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();

    public Class register(Class aclass) {
        String sql = "INSERT INTO class (local, semester, status, discipline_id, teacher_id, timetable_id ) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, aclass.getLocal());
            pstmt.setString(2, aclass.getPeriod());
            pstmt.setString(3, aclass.getStatus().toString());
            pstmt.setLong(4, aclass.getDiscipline().getId());
            pstmt.setLong(5, aclass.getTeacher().getId());

            Timetable tb = timetableDAO.register(aclass.getTimetable());
            pstmt.setLong(6, tb.getId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();

                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    aclass.setId((long) generatedId);

                    return aclass;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(Class aclass) {
        String sql = "UPDATE class SET local = ?, semester = ?, status = ?, teacher_id = ? WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, aclass.getLocal());
            pstmt.setString(2, aclass.getPeriod());
            pstmt.setString(3, aclass.getStatus().toString());
            pstmt.setLong(4, aclass.getTeacher().getId());
            pstmt.setLong(5, aclass.getId());

            timetableDAO.update(aclass.getTimetable());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM class WHERE id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Class getById(Long id) {
        String sql = "SELECT * FROM class WHERE id = ?";
        Class aClass = new Class();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                aClass.setId(rs.getLong("id"));
                aClass.setLocal(rs.getString("local"));
                aClass.setPeriod(rs.getString("semester"));
                aClass.setStatus(ClassStatus.valueOf(rs.getString("status")));

                Teacher teacher = teacherDAO.getById(rs.getLong("teacher_id"));
                Timetable timetable = timetableDAO.getById(rs.getLong("timetable_id"));
                Discipline discipline = disciplineDAO.getById(rs.getLong("discipline_id"));

                aClass.setTeacher(teacher);
                aClass.setTimetable(timetable);
                aClass.setDiscipline(discipline);

                return aClass;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    public List<Class> findClassByTeacher(String teacherName) {
        List<Class> classes = new ArrayList<>();

        String sql = "SELECT c.* FROM class c " +
                "INNER JOIN teacher t ON c.teacher_id = t.id " +
                "WHERE t.name = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, teacherName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Class aClass = new Class();
                // Preencher o objeto 'aClass' com os dados da consulta


                classes.add(aClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return classes;
    }
}
