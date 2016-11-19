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
public class Ticket {
    private int id;
    private int idPassenger;
    private int idFlightSchedule;
    private int idSeatNo;
    private String namePassenger;
    private String nameFlightSchedule;
    private String nameSeatNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public int getIdFlightSchedule() {
        return idFlightSchedule;
    }

    public String getNamePassenger() {
        return namePassenger;
    }

    public void setNamePassenger(String namePassenger) {
        this.namePassenger = namePassenger;
    }

    public String getNameFlightSchedule() {
        return nameFlightSchedule;
    }

    public void setNameFlightSchedule(String nameFlightSchedule) {
        this.nameFlightSchedule = nameFlightSchedule;
    }

    public String getNameSeatNo() {
        return nameSeatNo;
    }

    public void setNameSeatNo(String nameSeatNo) {
        this.nameSeatNo = nameSeatNo;
    }
    
    public void setIdFlightSchedule(int idFlightSchedule) {
        this.idFlightSchedule = idFlightSchedule;
    }

    public int getIdSeatNo() {
        return idSeatNo;
    }

    public void setIdSeatNo(int idSeatNo) {
        this.idSeatNo = idSeatNo;
    }

    public Ticket(int id, int idPassenger, int idFlightSchedule, int idSeatNo) {
        this.id = id;
        this.idPassenger = idPassenger;
        this.idFlightSchedule = idFlightSchedule;
        this.idSeatNo = idSeatNo;
    }

    public Ticket(int id, String namePassenger, String nameFlightSchedule, String nameSeatNo) {
        this.id = id;
        this.namePassenger = namePassenger;
        this.nameFlightSchedule = nameFlightSchedule;
        this.nameSeatNo = nameSeatNo;
    }

    public Ticket(int id, String namePassenger, String nameFlightSchedule, String nameSeatNo, int idPassenger, int idFlightSchedule, int idSeatNo) {
        this.id = id;
        this.namePassenger = namePassenger;
        this.nameFlightSchedule = nameFlightSchedule;
        this.nameSeatNo = nameSeatNo;
        this.idPassenger = idPassenger;
        this.idFlightSchedule = idFlightSchedule;
        this.idSeatNo = idSeatNo;
    }
    
}
