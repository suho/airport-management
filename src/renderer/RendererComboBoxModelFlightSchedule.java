/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import bean.FlightSchedule;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import model.ModelFlightSchedule;

/**
 *
 * @author PhiLong
 */
public class RendererComboBoxModelFlightSchedule implements ComboBoxModel {
    private ArrayList<FlightSchedule> alFlightSchedule ;
    private ModelFlightSchedule modelFlightSchedule;
    private FlightSchedule selectedItem;
    
    public RendererComboBoxModelFlightSchedule(){
        modelFlightSchedule = new ModelFlightSchedule();
        alFlightSchedule = modelFlightSchedule.getList();
        selectedItem = alFlightSchedule.get(0);
    }
    
    public RendererComboBoxModelFlightSchedule(Boolean search, FlightSchedule objFlightSchedule) {
        modelFlightSchedule = new ModelFlightSchedule();
        alFlightSchedule = modelFlightSchedule.getList();
        if(search){
            alFlightSchedule.add(0, new FlightSchedule(0, "---- Choose Flight Schedule ----"));
        }
        if(objFlightSchedule == null){
            selectedItem = alFlightSchedule.get(0);
        }else{
            selectedItem = objFlightSchedule;
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (FlightSchedule) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return alFlightSchedule.size();
    }
    @Override
    public Object getElementAt(int index) {
        return alFlightSchedule.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }
    
}
