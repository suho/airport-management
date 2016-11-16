/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Ticket;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ModelTicket;
import renderer.RendererCenterRenderer;

/**
 *
 * @author DELL
 */
public class ControllerTicket extends AbstractTableModel{
    private ArrayList<Ticket> alTickets = new ArrayList<>();
    private String[] arCols = {"<html><b>Id</b></html>", "<html><b>Name passenger</b></html>", "<html><b>Flight schedule</b></html>", "<html><b>Seat No</b></html>", "<html></html>", "<html></html>", "<html></html>"};
    private JTable table;
    private ModelTicket modelTicket;
    private RendererCenterRenderer renderer;
    
    
    public ControllerTicket(JTable table){
        this.table = table;
        modelTicket = new ModelTicket();
        renderer = new RendererCenterRenderer();
        alTickets = modelTicket.getList();
    }

    public int addTicket(Ticket objTicket) {
        int result = modelTicket.addRegisterFlightSchedule(objTicket);
        return result;
    }

    @Override
    public int getRowCount() {
        return alTickets.size();
    }

    @Override
    public int getColumnCount() {
        return arCols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ticket objTicket = alTickets.get(rowIndex);
        Object result = null;
        switch(columnIndex){
            case 0:
                result =  objTicket.getId();
                break;
            case 1:
                result =  objTicket.getNamePassenger();
                break;
            case 2:
                result =  objTicket.getNameFlightSchedule();
                break;
            case 3:
                result =  objTicket.getNameSeatNo();
                break;
            case 4:
                result =  objTicket.getIdPassenger();
                break;
            case 5:
                result =  objTicket.getIdFlightSchedule();
                break;
            case 6:
                result =  objTicket.getIdSeatNo();
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
            return Integer.class;
        }
        if(columnIndex == 5){
            return Integer.class;
        }
        if(columnIndex == 6){
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
        table.getColumnModel().getColumn(4).setMaxWidth(0);
        table.getColumnModel().getColumn(4).setMinWidth(0);
        table.getColumnModel().getColumn(5).setMinWidth(0);
        table.getColumnModel().getColumn(5).setMaxWidth(0);
        table.getColumnModel().getColumn(6).setMinWidth(0);
        table.getColumnModel().getColumn(6).setMaxWidth(0);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        renderer.setDefaultCenterRenderer(table);
    }
    public Ticket getValueAtRows(int row) {
        int modelRow = table.convertRowIndexToModel(row);
        return alTickets.get(modelRow);
    }

    public int editSeatNo(int idTicket, int idIntegerSeatNo) {
        int result = modelTicket.editSeatNo(idTicket, idIntegerSeatNo);
        return result;
    }

    public int deleteFlightSchedule(int id, int row) {
        int result = modelTicket.deleteTicket(id);
        if(result > 0){
            int rowModel = table.convertRowIndexToModel(row);
            alTickets.remove(rowModel);
            this.fireTableDataChanged();
        }
        return result;
    }
    
}
