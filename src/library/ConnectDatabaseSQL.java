/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ConnectDatabaseSQL {
    private Connection con = null;
	private Statement stm = null;

	public String makeURL() {
		StringBuilder url = new StringBuilder();
                url.append("jdbc:sqlserver://localhost:1433;databasename=airport_management;username=sa;password=123456");
		return url.toString();
	}

	public Connection getConnectData(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(this.makeURL());
			stm = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("khong nap duoc driver" + e);
		}
		return con;
	}
    public static void main(String[] args) {
        ConnectDatabaseSQL a = new ConnectDatabaseSQL();
        try {
            System.out.println("library.ConnectDatabaseSQL.main()" + a.getConnectData());
        } catch (Exception ex) {
            Logger.getLogger(ConnectDatabaseSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
