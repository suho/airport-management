/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import bean.Airplane;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import model.ModelAirplane;

/**
 *
 * @author PhiLong
 */
public class RendererComboBoxModelAirplane implements ComboBoxModel {
    private ArrayList<Airplane> alAirplane ;
    private ModelAirplane modelAirplane;
    private Airplane selectedItem;
    
    public RendererComboBoxModelAirplane(){
        modelAirplane = new ModelAirplane();
        alAirplane = modelAirplane.getList();
        selectedItem = alAirplane.get(0);
    }
    
    public RendererComboBoxModelAirplane(Boolean search, Airplane objAirplane) {
        modelAirplane = new ModelAirplane();
        alAirplane = modelAirplane.getList();
        if(search){
            alAirplane.add(0, new Airplane(0, "---- Choose Airplane ----"));
        }
        if(objAirplane == null){
            selectedItem = alAirplane.get(0);
        }else{
            selectedItem = objAirplane;
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Airplane) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return alAirplane.size();
    }
    @Override
    public Object getElementAt(int index) {
        return alAirplane.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }
    
}
