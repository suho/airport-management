/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bean.Employee;
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
public class ModelEmployee {
    private Connection conn;
    private ConnectDatabaseSQL lcdb;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    public ArrayList<Employee> getList() {
        lcdb = new ConnectDatabaseSQL();
        ArrayList<Employee> alEmployee = new ArrayList<>();
        conn = lcdb.getConnectData();
        String sql = "SELECT * FROM employees";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"), rs.getString("fullName"), rs.getString("avatar"), rs.getDate("birthday"), rs.getString("gender"), rs.getString("idCard"), rs.getString("religion"), rs.getString("ethnicMinority"), rs.getString("department"), rs.getString("position"), rs.getFloat("salary"), rs.getString("email"), rs.getString("address"), rs.getString("phone"), rs.getString("permission"));
                alEmployee.add(employee);
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
        return alEmployee;
    }
    
    public ArrayList<Employee> getListDepartment() {
        lcdb = new ConnectDatabaseSQL();
        ArrayList<Employee> alDepartment = new ArrayList<>();
        conn = lcdb.getConnectData();
        String sql = "SELECT id, name FROM employees";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),rs.getString("department"));
                alDepartment.add(employee);
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
        return alDepartment;
    }

    public int addEmployee(Employee objEmployee) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "INSERT INTO employees(fullName, avatar, birthday, gender, idCard, religion, ethnicMinority, department, position, salary, phone, email, address, permission) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, objEmployee.getFullName());
            pst.setString(2, objEmployee.getAvatar());
            pst.setDate(3, (Date)objEmployee.getBirthday());
            pst.setString(4, objEmployee.getGender());
            pst.setString(5, objEmployee.getIdCard());
            pst.setString(6, objEmployee.getReligion());
            pst.setString(7, objEmployee.getEthicMinority());
            pst.setString(8, objEmployee.getDepartment());
            pst.setString(9, objEmployee.getPosition());
            pst.setFloat(10, objEmployee.getSalary());
            pst.setString(11, objEmployee.getPhone());
            pst.setString(12, objEmployee.getEmail());
            pst.setString(13, objEmployee.getAddress());
            pst.setString(14, objEmployee.getPermission());
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

    public int editEmployee(Employee objEmployee) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "UPDATE employees SET fullName = ?, avatar = ?, birthday = ?, gender = ?, idCard = ?, religion = ?, ethnicMinority = ?, department = ?, position = ?, salary = ?, phone = ?, email = ?, address = ?, permission = ? WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, objEmployee.getFullName());
            pst.setString(2, objEmployee.getAvatar());
            pst.setDate(3, (Date)objEmployee.getBirthday());
            pst.setString(4, objEmployee.getGender());
            pst.setString(5, objEmployee.getIdCard());
            pst.setString(6, objEmployee.getReligion());
            pst.setString(7, objEmployee.getEthicMinority());
            pst.setString(8, objEmployee.getDepartment());
            pst.setString(9, objEmployee.getPosition());
            pst.setFloat(10, objEmployee.getSalary());
            pst.setString(11, objEmployee.getPhone());
            pst.setString(12, objEmployee.getEmail());
            pst.setString(13, objEmployee.getAddress());
            pst.setString(14, objEmployee.getPermission());
            pst.setInt(15, objEmployee.getId());
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

    public Employee getEmployee(int idUser) {
        lcdb = new ConnectDatabaseSQL();
        Employee objEmployee = null;
        conn = lcdb.getConnectData();
        String sql = "SELECT * FROM employees WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idUser);
            rs = pst.executeQuery();
            while (rs.next()) {
                objEmployee = new Employee(rs.getInt("id"), rs.getString("fullName"), rs.getString("avatar"), rs.getDate("birthday"), rs.getString("gender"), rs.getString("idCard"), rs.getString("religion"), rs.getString("ethnicMinority"), rs.getString("department"), rs.getString("position"), rs.getFloat("salary"), rs.getString("email"), rs.getString("address"), rs.getString("phone"), rs.getString("permission"));
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
        return objEmployee;
    }

    public int deleteEmployee(int id) {
        int result = 0;
        lcdb = new ConnectDatabaseSQL();
        conn = lcdb.getConnectData();
        String sql = "DELETE FROM employees WHERE id = ?";
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
