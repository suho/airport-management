/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Airplane;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ModelAirplane;
import renderer.RendererCenterRenderer;
import renderer.RendererComboBoxModelAirplane;

/**
 *
 * @author DELL
 */
public class ControllerAirplane extends AbstractTableModel{
    private ArrayList<Airplane> alAirplane = new ArrayList<>();
    private String[] arCols = {"<html><b>Id</b></html>","<html><b>Name</b></html>", "<html><b>Start place</b></html>", "<html><b>Finish place</b></html>"};
    private JTable table;
    private ModelAirplane modelAirplane;
    private RendererCenterRenderer renderer;
    
    public ControllerAirplane(JTable table){
        this.table = table;
        modelAirplane = new ModelAirplane();
        renderer = new RendererCenterRenderer();
        alAirplane = modelAirplane.getList();
    }

    public void loadAirplane(JComboBox<String> jComboBoxAirplane, boolean isSearch, Airplane object) {
        jComboBoxAirplane.setModel(new RendererComboBoxModelAirplane(isSearch, object));
    }

    @Override
    public int getRowCount() {
        return alAirplane.size();
    }

    @Override
    public int getColumnCount() {
        return arCols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Airplane objAirplane = alAirplane.get(rowIndex);
        Object result = null;
        switch(columnIndex){
            case 0:
                result =  objAirplane.getId();
                break;
            case 1:
                result =  objAirplane.getName();
                break;
            case 2:
                result =  objAirplane.getStartPlace();
                break;
            case 3:
                result =  objAirplane.getFinishPlace();
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
            return String.class;
        }
        if(columnIndex == 3){
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
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        renderer.setDefaultCenterRenderer(table);
    }
    
    public Airplane getValueAtRows(int row) {
        int modelRow = table.convertRowIndexToModel(row);
        return alAirplane.get(modelRow);
    }

    public int addAirplane(Airplane objAirplane) {
        int result = modelAirplane.addAirplane(objAirplane);
        return result;
    }

    public int editAirplane(Airplane item) {
        int result = modelAirplane.editAirplane(item);
        return result;
    }

    public int deleteAirplane(int id, int row) {
        int result = modelAirplane.deleteAirplane(id);
        if(result > 0){
            int rowModel = table.convertRowIndexToModel(row);
            alAirplane.remove(rowModel);
            this.fireTableDataChanged();
        }
        return result;
    }
    
}
