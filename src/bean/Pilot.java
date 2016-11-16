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
public class Pilot {
    private int id;
    private String name;
    private int idEmloyee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdEmloyee() {
        return idEmloyee;
    }

    public void setIdEmloyee(int idEmloyee) {
        this.idEmloyee = idEmloyee;
    }

    public Pilot(int id, String name, int idEmloyee) {
        this.id = id;
        this.name = name;
        this.idEmloyee = idEmloyee;
    }

    public Pilot(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
