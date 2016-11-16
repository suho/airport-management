/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import bean.Employee;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import model.ModelEmployee;

/**
 *
 * @author PhiLong
 */
public class RendererComboBoxModelDepartment implements ComboBoxModel {
    private ArrayList<Employee> alEmployee ;
    private ModelEmployee modelEmployee;
    private Employee selectedItem;
    
    public RendererComboBoxModelDepartment(){
        modelEmployee = new ModelEmployee();
        alEmployee = modelEmployee.getList();
        selectedItem = alEmployee.get(0);
    }
    
    public RendererComboBoxModelDepartment(Boolean search, Employee objEmployee) {
        modelEmployee = new ModelEmployee();
        alEmployee = modelEmployee.getList();
        if(search){
            alEmployee.add(0, new Employee(0, "---- Choose department ----"));
        }
        if(objEmployee == null){
            selectedItem = alEmployee.get(0);
        }else{
            selectedItem = objEmployee;
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = (Employee) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return alEmployee.size();
    }
    @Override
    public Object getElementAt(int index) {
        return alEmployee.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }
    
}
