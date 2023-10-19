package com.classmanager.DAO;

import com.classmanager.enums.DisciplineStatus;
import com.classmanager.model.Class;
import com.classmanager.model.Discipline;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class DisciplineDAO extends BaseDAO {
    private Connection con = getConection();

    public void register(Discipline discipline) {
        String sql = "INSERT INTO discipline (name, status, code) VALUES (?, ?, ?);";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, discipline.getName());
            pstmt.setString(2, discipline.getStatus().toString());
            pstmt.setString(3, generateDisciplinaCode());

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

    public Discipline getById(long id) {
        String sql = "SELECT * FROM discipline WHERE id = ?;";
        Discipline discipline = new Discipline();

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1,  id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                discipline.setId(rs.getLong("id"));
                discipline.setName(rs.getString("name"));
                discipline.setCode(rs.getString("code"));
                discipline.setStatus(DisciplineStatus.valueOf(rs.getString("status")));

                return discipline;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
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

    public List<Discipline>  getByNameOrCodeOrStatus(String name, String code, DisciplineStatus status) {
        List<Discipline> disciplines = new ArrayList<>();
        String sql = "SELECT * FROM discipline WHERE name LIKE ? OR code LIKE ? OR status LIKE ?;";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1,  "%" + name + "%");
            pstmt.setString(2,  "%" + code + "%");
            pstmt.setString(3,  "%" + status + "%");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getLong("id"));
                discipline.setName(rs.getString("name"));
                discipline.setCode(rs.getString("code"));
                discipline.setStatus(DisciplineStatus.valueOf(rs.getString("status")));

                disciplines.add(discipline);
            }

            return disciplines;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String generateDisciplinaCode() {
        Calendar calendar = Calendar.getInstance();
        int anoAtual = calendar.get(Calendar.YEAR);

        Random random = new Random();
        int variavelNumerica = random.nextInt(10000);

        String codigoDisciplina = String.format("%04d%05d", anoAtual, variavelNumerica);

        return codigoDisciplina;
    }
}

