/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Employee;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ModelEmployee;
import renderer.RendererCenterRenderer;
import renderer.RendererComboBoxModelDepartment;

/**
 *
 * @author DELL
 */
public class ControllerEmployee extends AbstractTableModel{
    private ArrayList<Employee> alEmployee = new ArrayList<>();
    private String[] arCols = {"<html><b>Id</b></html>","<html><b>Name</b></html>", "<html><b>Birthday</b></html>", "<html><b>Gender</b></html>", "<html><b>CMND</b></html>", "<html><b>Position</b></html>", "<html><b>Phone</b></html>", "<html></html>"};
    private JTable table;
    private ModelEmployee modelEmployee;
    private RendererCenterRenderer renderer;
    
    public ControllerEmployee(JTable table){
        this.table = table;
        modelEmployee = new ModelEmployee();
        renderer = new RendererCenterRenderer();
        alEmployee = modelEmployee.getList();
    }

    @Override
    public int getRowCount() {
        return alEmployee.size();
    }

    @Override
    public int getColumnCount() {
        return arCols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee objEmployee = alEmployee.get(rowIndex);
        Object result = null;
        switch(columnIndex){
            case 0:
                result =  objEmployee.getId();
                break;
            case 1:
                result =  objEmployee.getFullName();
                break;
            case 2:
                result =  objEmployee.getBirthday();
                break;
            case 3:
                result =  objEmployee.getGender();
                break;
            case 4:
                result =  objEmployee.getIdCard();
                break;
            case 5:
                result =  objEmployee.getPosition();
                break;
            case 6:
                result =  objEmployee.getPhone();
                break;
            case 7:
                result =  objEmployee.getDepartment();
                break;
        }
        return result;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0){
            return Integer.class;
        }
        if(columnIndex == 1){
            return String.class;
        }
        if(columnIndex == 2){
            return Date.class;
        }
        if(columnIndex == 3){
            return String.class;
        }
        if(columnIndex == 4){
            return String.class;
        }
        if(columnIndex == 5){
            return String.class;
        }
        if(columnIndex == 6){
            return String.class;
        }
        if(columnIndex == 7){
            return String.class;
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return arCols[column];
    }
    public void loadTable() {
       table.setModel(this);
        ((JComponent) table.getDefaultRenderer(Boolean.class)).setOpaque(true);
        table.getTableHeader().setPreferredSize(new Dimension(0, 30));
        table.setRowHeight(30);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setMaxWidth(0);
        table.getColumnModel().getColumn(7).setMinWidth(0);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        renderer.setDefaultCenterRenderer(table);
    }
    public Employee getValueAtRows(int row) {
        int modelRow = table.convertRowIndexToModel(row);
        return alEmployee.get(modelRow);
    }

    public int addEmployee(Employee objEmployee) {
        int result = modelEmployee.addEmployee(objEmployee);
        return result;
    }

    public int editEmployee(Employee editEmployee) {
        int result = modelEmployee.editEmployee(editEmployee);
        return result;
    }

    public Employee profile(int idUser) {
        Employee objEmployee = modelEmployee.getEmployee(idUser);
        return objEmployee;
    }

    public int deleteEmployee(int id, int row) {
        int result = modelEmployee.deleteEmployee(id);
        if(result > 0){
            int rowModel = table.convertRowIndexToModel(row);
            alEmployee.remove(rowModel);
            this.fireTableDataChanged();
        }
        return result;
    }

    public void loadDepartment(JComboBox<String> jComboBoxDepartment, boolean isSearch, Employee object) {
        jComboBoxDepartment.setModel(new RendererComboBoxModelDepartment(isSearch, object));
    }
}
