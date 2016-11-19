/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Timestamp;

/**
 *
 * @author DELL
 */
public class FlightSchedule {
    private int id;
    private String name;
    private Timestamp startTime;
    private Timestamp finishTime;
    private int idAirplane;
    private int idPilot;
    private int numberSeatNo;
    private String nameAirplane;
    private String namePilot;
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

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    public int getIdAirplane() {
        return idAirplane;
    }

    public void setIdAirplane(int idAirplane) {
        this.idAirplane = idAirplane;
    }

    public int getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(int idPilot) {
        this.idPilot = idPilot;
    }

    public int getNumberSeatNo() {
        return numberSeatNo;
    }

    public void setNumberSeatNo(int numberSeatNo) {
        this.numberSeatNo = numberSeatNo;
    }

    public String getNameAirplane() {
        return nameAirplane;
    }

    public void setNameAirplane(String nameAirplane) {
        this.nameAirplane = nameAirplane;
    }

    public String getNamePilot() {
        return namePilot;
    }

    public void setNamePilot(String namePilot) {
        this.namePilot = namePilot;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public FlightSchedule(int id, String name, Timestamp startTime, Timestamp finishTime, int idAirplane, int idPilot, int numberSeatNo) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.idAirplane = idAirplane;
        this.idPilot = idPilot;
        this.numberSeatNo = numberSeatNo;
    }

    public FlightSchedule(int id, String name, int idAirplane, int idPilot, int numberSeatNo) {
        this.id = id;
        this.name = name;
        this.idAirplane = idAirplane;
        this.idPilot = idPilot;
        this.numberSeatNo = numberSeatNo;
    }

    public FlightSchedule(int id, String name, Timestamp startTime, Timestamp finishTime, String nameAirplane, String namePilot, int numberSeatNo) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.nameAirplane = nameAirplane;
        this.namePilot = namePilot;
        this.numberSeatNo = numberSeatNo;
    }

    public FlightSchedule(int id, String name, Timestamp startTime, Timestamp finishTime, String nameAirplane, String namePilot, int numberSeatNo, int idAirplane, int idPilot, boolean status) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.idAirplane = idAirplane;
        this.idPilot = idPilot;
        this.numberSeatNo = numberSeatNo;
        this.nameAirplane = nameAirplane;
        this.namePilot = namePilot;
        this.status = status;
    }

    public FlightSchedule(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
}
