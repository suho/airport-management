/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.FlightSchedule;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ModelFlightSchedule;
import renderer.RendererCenterRenderer;
import renderer.RendererComboBoxModelFlightSchedule;

/**
 *
 * @author DELL
 */
public class ControllerFlightSchedule extends AbstractTableModel{
    private ArrayList<FlightSchedule> alFlightSchedule = new ArrayList<>();
    private String[] arCols = {"<html><b>Id</b></html>","<html><b>Name</b></html>", "<html><b>Start time</b></html>", "<html><b>Finish time</b></html>", "<html><b>Airplane</b></html>", "<html><b>Pilot</b></html>", "<html><b>Number seat No</b></html>", "<html><b>Status</b></html>", "<html></html>", "<html></html>"};
    private JTable table;
    private ModelFlightSchedule modelFlightSchedule;
    private RendererCenterRenderer renderer;
    
    public ControllerFlightSchedule(JTable table){
        this.table = table;
        modelFlightSchedule = new ModelFlightSchedule();
        renderer = new RendererCenterRenderer();
        alFlightSchedule = modelFlightSchedule.getList();
    }
    
    @Override
    public int getRowCount() {
        return alFlightSchedule.size();
    }

    @Override
    public int getColumnCount() {
        return arCols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FlightSchedule objFlightSchedule = alFlightSchedule.get(rowIndex);
        Object result = null;
        switch(columnIndex){
            case 0:
                result =  objFlightSchedule.getId();
                break;
            case 1:
                result =  objFlightSchedule.getName();
                break;
            case 2:
                result =  objFlightSchedule.getStartTime();
                break;
            case 3:
                result =  objFlightSchedule.getFinishTime();
                break;
            case 4:
                result =  objFlightSchedule.getNameAirplane();
                break;
            case 5:
                result =  objFlightSchedule.getNamePilot();
                break;
            case 6:
                result =  objFlightSchedule.getNumberSeatNo();
                break;
            case 7:
                result =  objFlightSchedule.isStatus();
                break;
            case 8:
                result =  objFlightSchedule.getIdAirplane();
                break;
            case 9:
                result =  objFlightSchedule.getIdPilot();
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
        if(columnIndex == 4){
            return String.class;
        }
        if(columnIndex == 5){
            return String.class;
        }
        if(columnIndex == 6){
            return Integer.class;
        }
        if(columnIndex == 7){
            return Boolean.class;
        }
        if(columnIndex == 8){
            return Integer.class;
        }
        if(columnIndex == 9){
            return Integer.class;
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
        table.getColumnModel().getColumn(7).setPreferredWidth(100);
        table.getColumnModel().getColumn(8).setMinWidth(0);
        table.getColumnModel().getColumn(8).setMaxWidth(0);
        table.getColumnModel().getColumn(9).setMaxWidth(0);
        table.getColumnModel().getColumn(9).setMinWidth(0);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        renderer.setDefaultCenterRenderer(table);
    }

    public int addFlightSchedule(FlightSchedule objFlightSchdule) {
        int result = modelFlightSchedule.addFlightSchedule(objFlightSchdule);
        return result;
    }

    public void loadFlightSchedule(JComboBox<String> jComboBoxFlightSchedule, boolean isSearch, FlightSchedule object) {
        jComboBoxFlightSchedule.setModel(new RendererComboBoxModelFlightSchedule(isSearch, object));
    }

    public FlightSchedule getValueAtRows(int row) {
        int modelRow = table.convertRowIndexToModel(row);
        return alFlightSchedule.get(modelRow);
    }

    public int editFlightSchedule(FlightSchedule objFlightSchdule) {
        int result = modelFlightSchedule.editFlightSchedule(objFlightSchdule);
        return result;
    }

    public int deleteFlightSchedule(int id, int row) {
        int result = modelFlightSchedule.deleteEmployee(id);
        if(result > 0){
            int rowModel = table.convertRowIndexToModel(row);
            alFlightSchedule.remove(rowModel);
            this.fireTableDataChanged();
        }
        return result;
    }

    public FlightSchedule getItem(int idFlightSchedule) {
        FlightSchedule item = modelFlightSchedule.getItem(idFlightSchedule);
        return item;
    }

    public int doneFlightSchedule(FlightSchedule item, int row) {
        int result = modelFlightSchedule.doneFlightSchedule(item.getId());
        if(result > 0){
            int rowModel = table.convertRowIndexToModel(row);
            alFlightSchedule.set(rowModel, item);
            this.fireTableRowsUpdated(rowModel, rowModel);
            this.fireTableDataChanged();
        }
        return result;
    }
    
}
