/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.SeatNo;
import java.util.ArrayList;
import model.ModelSeatNo;

/**
 *
 * @author DELL
 */
public class ControllerSeatNo {
    private ModelSeatNo modelSeatNo;
    
    public ControllerSeatNo(){
        modelSeatNo = new ModelSeatNo();
    }

    public int addSeatNo(int idFlightSchedule, int numberSeatNo) {
        int result = modelSeatNo.addSeatNo(idFlightSchedule, numberSeatNo);
        return result;
    }

    public ArrayList<SeatNo> getList(int idFlightSchedule) {
        ArrayList<SeatNo> alSeatNo = new ArrayList<>();
        alSeatNo = modelSeatNo.getList(idFlightSchedule);
        return alSeatNo;
    }

    public int updateSeatNo(int idSeatNo) {
        int result = modelSeatNo.updateSeatNo(idSeatNo);
        return result;
    }

    public int removeSeatNo(int idSeatNo) {
        int result = modelSeatNo.removeSeatNo(idSeatNo);
        return result;
    }
    
}
