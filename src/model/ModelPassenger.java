/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Passenger;
import java.sql.Connection;
import java.sql.Date;
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
public class ModelPassenger {
    private Connection conn;
    private ConnectDatabaseSQL lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public ArrayList<Passenger> getList() {
        lcdb = new ConnectDatabaseSQL();
        ArrayList<Passenger> alPassenger = new ArrayList<>();
        conn = lcdb.getConnectData();
        String sql = "SELECT * FROM passengers";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Passenger item = new Passenger(rs.getInt("id"), rs.getString("passport"), rs.getString("fullName"), rs.getDate("birthday"), rs.getString("nativeCountry"), rs.getString("gender"), rs.getString("nationality"), rs.getString("phone"), rs.getString("address"));
                alPassenger.add(item);
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
        return alPassenger;
    }

    public int addPassenger(Passenger objPassenger) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "INSERT INTO passengers(passport, fullName, birthday, nativeCountry, gender, nationality, phone, address) VALUES (?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, objPassenger.getPassport());
            pst.setString(2, objPassenger.getFullName());
            pst.setDate(3, (Date) objPassenger.getBirthday());
            pst.setString(4, objPassenger.getNativeCountry());
            pst.setString(5, objPassenger.getGender());
            pst.setString(6, objPassenger.getNationality());
            pst.setString(7, objPassenger.getPhone());
            pst.setString(8, objPassenger.getAddress());
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

    public int editPassenger(Passenger objPassenger) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "UPDATE passengers SET passport = ?, fullName = ?, birthday = ?, nativeCountry = ?, gender = ?, nationality = ?, phone = ?, address = ? WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, objPassenger.getPassport());
            pst.setString(2, objPassenger.getFullName());
            pst.setDate(3, (Date) objPassenger.getBirthday());
            pst.setString(4, objPassenger.getNativeCountry());
            pst.setString(5, objPassenger.getGender());
            pst.setString(6, objPassenger.getNationality());
            pst.setString(7, objPassenger.getPhone());
            pst.setString(8, objPassenger.getAddress());
            pst.setInt(9, objPassenger.getId());
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

    public Passenger findPassenger(String passport) {
        lcdb = new ConnectDatabaseSQL();
        Passenger objPassenger = null;
        conn = lcdb.getConnectData();
        String sql = "SELECT * FROM passengers WHERE passport LIKE '" + passport + "'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                objPassenger = new Passenger(rs.getInt("id"), rs.getString("passport"), rs.getString("fullName"), rs.getDate("birthday"), rs.getString("nativeCountry"), rs.getString("gender"), rs.getString("nationality"), rs.getString("phone"), rs.getString("address"));
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
        return objPassenger;
    }
    public int deletePassenger(int id) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "DELETE FROM passengers WHERE id = ?";
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
