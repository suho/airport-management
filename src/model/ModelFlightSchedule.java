/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.FlightSchedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.ConnectDatabaseSQL;
import library.ConvertDate;

/**
 *
 * @author DELL
 */
public class ModelFlightSchedule {
    private ConvertDate convertDate;
    private Connection conn;
    private ConnectDatabaseSQL lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    public ModelFlightSchedule(){
        convertDate = new ConvertDate();
    }
    
    public ArrayList<FlightSchedule> getList() {
        lcdb = new ConnectDatabaseSQL();
        ArrayList<FlightSchedule> alFlightSchedule = new ArrayList<>();
        conn = lcdb.getConnectData();
        String sql = "SELECT flightSchedules.id, flightSchedules.name as nameFlightSchedule, finishTime, startTime, finishTime,airPlanes.name as nameAirplane,pilots.name as namePilot, numberSeatNo, idAirplane, flightSchedules.idPilot, status FROM flightSchedules,airPlanes,pilots WHERE flightSchedules.idAirplane=airPlanes.id AND flightSchedules.idPilot = pilots.id AND flightSchedules.status = 'false' ORDER BY flightSchedules.id DESC";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                FlightSchedule item = new FlightSchedule(rs.getInt("id"), rs.getString("nameFlightSchedule"), rs.getTimestamp("startTime"), rs.getTimestamp("finishTime"), rs.getString("nameAirplane"), rs.getString("namePilot"), rs.getInt("numberSeatNo"), rs.getInt("idAirplane"), rs.getInt("idPilot"), rs.getBoolean("status"));
                alFlightSchedule.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return alFlightSchedule;
    }
    
    public ArrayList<FlightSchedule> getListFlightSchedule(){
        lcdb = new ConnectDatabaseSQL();
        ArrayList<FlightSchedule> alFlightSchedule = new ArrayList<>();
        conn = lcdb.getConnectData();
        String sql = "SELECT flightSchedules.id, flightSchedules.name FROM flightSchedules";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                FlightSchedule item = new FlightSchedule(rs.getInt("id"), rs.getString("nameFlightSchedule"));
                alFlightSchedule.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return alFlightSchedule;
    }

    public int addFlightSchedule(FlightSchedule objFlightSchdule) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "INSERT INTO flightSchedules(name,startTime,finishTime,idAirplane,idPilot, numberSeatNo, status) VALUES (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, objFlightSchdule.getName());
            pst.setTimestamp(2, objFlightSchdule.getStartTime());
            pst.setTimestamp(3, objFlightSchdule.getFinishTime());
            pst.setInt(4, objFlightSchdule.getIdAirplane());
            pst.setInt(5, objFlightSchdule.getIdPilot());
            pst.setInt(6, objFlightSchdule.getNumberSeatNo());
            pst.setBoolean(7, false);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if(rs.next()){
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int editFlightSchedule(FlightSchedule objFlightSchdule) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "UPDATE flightSchedules SET name = ?, startTime = ?, finishTime = ?, idAirplane = ?, idPilot = ?, numberSeatNo = ? WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, objFlightSchdule.getName());
            pst.setTimestamp(2, objFlightSchdule.getStartTime());
            pst.setTimestamp(3, objFlightSchdule.getFinishTime());
            pst.setInt(4, objFlightSchdule.getIdAirplane());
            pst.setInt(5, objFlightSchdule.getIdPilot());
            pst.setInt(6, objFlightSchdule.getNumberSeatNo());
            pst.setInt(7, objFlightSchdule.getId());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public int deleteFlightSchedule(int id) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "DELETE FROM flightSchedules WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModelEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }

    public FlightSchedule getItem(int idFlightSchedule) {
        lcdb = new ConnectDatabaseSQL();
        FlightSchedule objFlightSchedule = null;
        conn = lcdb.getConnectData();
        String sql = "SELECT * FROM flightSchedules WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idFlightSchedule);
            rs = pst.executeQuery();
            while (rs.next()) {
                objFlightSchedule = new FlightSchedule(rs.getInt("id"), rs.getString("name"), rs.getTimestamp("startTime"), rs.getTimestamp("finishTime"), rs.getInt("idAirplane"), rs.getInt("idPilot"), rs.getInt("numberSeatNo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return objFlightSchedule;
    }

    public int doneFlightSchedule(int id) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "UPDATE flightSchedules SET status = 1 WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
