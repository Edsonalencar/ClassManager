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
    private StudentDAO studentDAO = new StudentDAO();

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
                }

                return aclass;
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

    public boolean registerStudentInClass(Long studentId, Long classId) {
        String sql = "INSERT INTO student_class (student_id, class_id ) VALUES (?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setLong(1, studentId);
            pstmt.setLong(2, classId);

            pstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void deleteStudentInClass(Long id) {
        String sql = "DELETE FROM student_class WHERE student_id = ?";

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

                ArrayList<Student> students = studentDAO.findStudentsByClass(aClass.getId());
                aClass.setStudents(students);

                return aClass;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Class> getAll() {
        String sql = "SELECT * FROM class;";
        List<Class> classes = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Class newClass = new Class();

                newClass.setId(rs.getLong("id"));
                newClass.setLocal(rs.getString("local"));
                newClass.setPeriod(rs.getString("semester"));
                newClass.setStatus(ClassStatus.valueOf(rs.getString("status")));

                Teacher teacher = teacherDAO.getById(rs.getLong("teacher_id"));
                Timetable timetable = timetableDAO.getById(rs.getLong("timetable_id"));
                Discipline discipline = disciplineDAO.getById(rs.getLong("discipline_id"));

                newClass.setTeacher(teacher);
                newClass.setTimetable(timetable);
                newClass.setDiscipline(discipline);

                ArrayList<Student> students = studentDAO.findStudentsByClass(newClass.getId());
                newClass.setStudents(students);

                classes.add(newClass);
            }

            return classes;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Class> findClassByStudent(long id) {
        List<Class>  classes = new ArrayList<>();
        String sql = "SELECT class_id FROM student_class WHERE student_id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Class newClass = getById(rs.getLong("class_id"));
                classes.add(newClass);
            }

            return classes;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public  List<Class>findClassByTeacher(long id) {
        List<Class> classes = new ArrayList<>();
        String sql = "SELECT * FROM class WHERE teacher_id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Class aClass = new Class();

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

                ArrayList<Student> students = studentDAO.findStudentsByClass(aClass.getId());
                aClass.setStudents(students);

                classes.add(aClass);
            }

            return classes;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public  List<Class>findClassByNameOrTeacher(String name, long teacherId) {
        List<Class> classes = new ArrayList<>();
        String sql = "SELECT * FROM class WHERE name LIKE ? OR teacher_id = ?;";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            pstmt.setLong(2, teacherId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Class aClass = new Class();

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

                ArrayList<Student> students = studentDAO.findStudentsByClass(aClass.getId());
                aClass.setStudents(students);

                classes.add(aClass);
            }

            return classes;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
