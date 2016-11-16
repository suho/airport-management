/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Airplane;
import bean.Pilot;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ModelPilot;
import renderer.RendererCenterRenderer;
import renderer.RendererComboBoxModelPilot;

/**
 *
 * @author DELL
 */

public class ControllerPilot extends AbstractTableModel{
    private ArrayList<Pilot> alPilot = new ArrayList<>();
    private String[] arCols = {"<html><b>Id</b></html>","<html><b>Name</b></html>"};
    private JTable table;
    private ModelPilot modelPilot;
    private RendererCenterRenderer renderer;
    
    public ControllerPilot(JTable table){
        this.table = table;
        modelPilot = new ModelPilot();
        renderer = new RendererCenterRenderer();
        alPilot = modelPilot.getList();
    }
    
    public void loadPilot(JComboBox<String> jComboBoxPilot, boolean isSearch, Pilot object) {
        jComboBoxPilot.setModel(new RendererComboBoxModelPilot(isSearch, object));
    }

    @Override
    public int getRowCount() {
        return alPilot.size();
    }

    @Override
    public int getColumnCount() {
        return arCols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pilot objPiLot = alPilot.get(rowIndex);
        Object result = null;
        switch(columnIndex){
            case 0:
                result =  objPiLot.getId();
                break;
            case 1:
                result =  objPiLot.getName();
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
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        renderer.setDefaultCenterRenderer(table);
    }
    public Pilot getValueAtRows(int row) {
        int modelRow = table.convertRowIndexToModel(row);
        return alPilot.get(modelRow);
    }
    
}
