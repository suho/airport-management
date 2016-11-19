/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import library.ConnectDatabaseSQL;
import library.LibraryString;

/**
 *
 * @author DELL
 */
public class ModelUser {
    private Connection conn;
    private ConnectDatabaseSQL lcdb;
    private PreparedStatement pst;
    private ResultSet rs;
    private LibraryString lbString;

    public int checkUser(User objUser) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, objUser.getUsername());
            pst.setString(2, objUser.getPassword());
            rs = pst.executeQuery();
            if(rs.next()){
                result = rs.getInt("idEmployee");
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

    public int addItem(User objUser) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "INSERT INTO users(username, password, idEmployee) VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, objUser.getUsername());
            pst.setString(2, lbString.md5(objUser.getPassword()));
            pst.setInt(3, 1);
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

    public int editItem(User objUser) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "UPDATE users SET password = ? WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, objUser.getPassword());
            pst.setInt(2, 1);
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
