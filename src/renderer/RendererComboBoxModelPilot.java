/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import bean.Pilot;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import model.ModelPilot;

/**
 *
 * @author PhiLong
 */
public class RendererComboBoxModelPilot implements ComboBoxModel {
    private ArrayList<Pilot> alPilot ;
    private ModelPilot modelPilot;
    private Pilot selectedItem;
    
    public RendererComboBoxModelPilot(){
        modelPilot = new ModelPilot();
        alPilot = modelPilot.getList();
//        for(int i = 0; i < alPilot.size(); i++){
            selectedItem = alPilot.get(0);
//        }
        
    }
    
    public RendererComboBoxModelPilot(Boolean search, Pilot objPilot) {
        modelPilot = new ModelPilot();
        alPilot = modelPilot.getList();
        if(search){
            alPilot.add(0, new Pilot(0, "---- Choose Pilot ----"));
        }
        if(objPilot == null){
            selectedItem = alPilot.get(0);
        }else{
            selectedItem = objPilot;
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Pilot) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return alPilot.size();
    }
    @Override
    public Object getElementAt(int index) {
        return alPilot.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }
    
}
