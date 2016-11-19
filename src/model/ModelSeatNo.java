/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.SeatNo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import library.ConnectDatabaseSQL;

/**
 *
 * @author DELL
 */
public class ModelSeatNo {
    private Connection conn;
    private ConnectDatabaseSQL lcdb;
    private PreparedStatement pst;
    private ResultSet rs;

    public int addSeatNo(int idFlightSchedule, int numberSeatNo) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        for(int i = 1; i<= numberSeatNo; i++){
            String nameSeatNo = "SeatNo " + i;
            String sql = "INSERT INTO seatNo(name, idFlightSchedule, status) VALUES (?,?,0)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, nameSeatNo);
                pst.setInt(2, idFlightSchedule);
                pst.executeUpdate();
                result ++;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(result == numberSeatNo){
            result = numberSeatNo;
        }else{
            result = 0;
        }
        return result;
    }

    public ArrayList<SeatNo> getList(int idFlightSchedule) {
        lcdb = new ConnectDatabaseSQL();
        ArrayList<SeatNo> alSeatNo = new ArrayList<>();
        conn = lcdb.getConnectData();
        String sql = "SELECT * FROM seatNo WHERE idFlightSchedule = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idFlightSchedule);
            rs = pst.executeQuery();
            while (rs.next()) {
                SeatNo seatNo = new SeatNo(rs.getInt("id"), rs.getString("name"), rs.getInt("idFlightSchedule"), rs.getBoolean("status"));
                alSeatNo.add(seatNo);
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
        return alSeatNo;
    }

    public int updateSeatNo(int idSeatNo) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();

        String sql = "UPDATE seatNo SET status = 1 WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idSeatNo);
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

    public int removeSeatNo(int idSeatNo) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "UPDATE seatNo SET status = 0 WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idSeatNo);
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
