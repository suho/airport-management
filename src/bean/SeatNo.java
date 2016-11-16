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
public class SeatNo {
    private int id;
    private String name;
    private int idFlightSchedule;
    private boolean status;

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

    public int getIdFlightSchedule() {
        return idFlightSchedule;
    }

    public void setIdFlightSchedule(int idFlightSchedule) {
        this.idFlightSchedule = idFlightSchedule;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public SeatNo(int id, String name, int idFlightSchedule, boolean status) {
        this.id = id;
        this.name = name;
        this.idFlightSchedule = idFlightSchedule;
        this.status = status;
    }
    
}
