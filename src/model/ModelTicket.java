/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.ConnectDatabaseSQL;

/**
 *
 * @author DELL
 */
public class ModelTicket {
    private Connection conn;
    private ConnectDatabaseSQL lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public int addRegisterFlightSchedule(Ticket objRegisterFlightSchedule) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();

        String sql = "INSERT INTO tickets(idPassenger, idFlightSchedule, idSeatNo) VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, objRegisterFlightSchedule.getIdPassenger());
            pst.setInt(2, objRegisterFlightSchedule.getIdFlightSchedule());
            pst.setInt(3, objRegisterFlightSchedule.getIdSeatNo());
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()){
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

    public ArrayList<Ticket> getList() {
       lcdb = new ConnectDatabaseSQL();
        ArrayList<Ticket> alRegisterFlightSchedules = new ArrayList<>();
        conn = lcdb.getConnectData();
        String sql = "SELECT tickets.id as id, passengers.fullName as namePassenger, flightSchedules.name as nameFLightSchedule, seatNo.name as nameSeatNo, tickets.idPassenger, tickets.idFlightSchedule, tickets.idSeatNo FROM tickets,flightSchedules,passengers,seatNo WHERE tickets.idPassenger = passengers.id AND tickets.idFlightSchedule = flightSchedules.id AND tickets.idSeatNo = seatNo.id ORDER BY tickets.id DESC";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Ticket item = new Ticket(rs.getInt("id"), rs.getString("namePassenger"), rs.getString("nameFLightSchedule"), rs.getString("nameSeatNo"), rs.getInt("idPassenger"), rs.getInt("idFlightSchedule"), rs.getInt("idSeatNo"));
                alRegisterFlightSchedules.add(item);
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
        return alRegisterFlightSchedules;
    }

    public int editSeatNo(int idTicket, int idIntegerSeatNo) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "UPDATE tickets SET idSeatNo = ? WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idIntegerSeatNo);
            pst.setInt(2, idTicket);
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
    public int deleteTicket(int id) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "DELETE FROM tickets WHERE id = ?";
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
    public int deleteTicketPassenger(int id) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "DELETE FROM tickets WHERE idPassenger = ?";
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
}
