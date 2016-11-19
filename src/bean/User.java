/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author DELL
 */
public class User {
    private String username;
    private String password;
    private int idEmployee;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public User(String username, String password, int idEmployee) {
        this.username = username;
        this.password = password;
        this.idEmployee = idEmployee;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
}
