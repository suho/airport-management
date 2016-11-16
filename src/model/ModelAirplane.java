/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Airplane;
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
public class ModelAirplane {
    private Connection conn;
    private ConnectDatabaseSQL lcdb;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;

    public ArrayList<Airplane> getList() {
        lcdb = new ConnectDatabaseSQL();
        ArrayList<Airplane> alAirplanes = new ArrayList<>();
        conn = lcdb.getConnectData();
        String sql = "SELECT * FROM airplanes";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Airplane airplane = new Airplane(rs.getInt("id"), rs.getString("name"), rs.getString("startPlace"), rs.getString("finishPlace"));
                alAirplanes.add(airplane);
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
        return alAirplanes;
    }

    public int addAirplane(Airplane objAirplane) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "INSERT INTO airplanes(name, startPlace, finishPlace) VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, objAirplane.getName());
            pst.setString(2, objAirplane.getStartPlace());
            pst.setString(3, objAirplane.getFinishPlace());
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

    public int deleteAirplane(int id) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "DELETE FROM airplanes WHERE id = ?";
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

    public int editAirplane(Airplane item) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "UPDATE airplanes SET name = ?, startPlace = ?, finishPlace = ? WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, item.getName());
            pst.setString(2, item.getStartPlace());
            pst.setString(3, item.getFinishPlace());
            pst.setInt(4, item.getId());
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
