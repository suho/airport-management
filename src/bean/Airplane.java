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
public class Airplane {
    private int id;
    private String name;
    private String startPlace;
    private String finishPlace;

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

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getFinishPlace() {
        return finishPlace;
    }

    public void setFinishPlace(String finishPlace) {
        this.finishPlace = finishPlace;
    }

    public Airplane(int id, String name, String startPlace, String finishPlace) {
        this.id = id;
        this.name = name;
        this.startPlace = startPlace;
        this.finishPlace = finishPlace;
    }

    public Airplane(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    
}
