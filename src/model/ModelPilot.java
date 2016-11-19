/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Pilot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import library.ConnectDatabaseSQL;
import library.ConvertDate;
import library.LibraryString;

/**
 *
 * @author DELL
 */
public class ModelPilot {
    private Connection conn;
    private ConnectDatabaseSQL lcdb;
    private Statement st;
    private ResultSet rs;

    public ArrayList<Pilot> getList() {
        lcdb = new ConnectDatabaseSQL();
        ArrayList<Pilot> alPilots = new ArrayList<>();
        conn = lcdb.getConnectData();
        String sql = "SELECT * FROM pilots";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Pilot pilot = new Pilot(rs.getInt("id"), rs.getString("name"));
                alPilots.add(pilot);
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
        return alPilots;
    }
}
