/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Passenger;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ModelPassenger;
import model.ModelTicket;
import renderer.RendererCenterRenderer;

/**
 *
 * @author DELL
 */
public class ControllerPassenger extends AbstractTableModel{
    private ArrayList<Passenger> alPassenger = new ArrayList<>();
    private String[] arCols = {"<html><b>Id</b></html>","<html><b>Passport</b></html>","<html><b>Name</b></html>", "<html><b>Birthday</b></html>", "<html><b>Native</b></html>", "<html><b>Gender</b></html>", "<html><b>Nationality</b></html>", "<html><b>Phone</b></html>", "<html><b>Address</b></html>"};
    private JTable table;
    private ModelPassenger modelPassenger;
    private RendererCenterRenderer renderer;
    private ModelTicket modelTicket;

    public ControllerPassenger(JTable table) {
        this.table = table;
        modelPassenger = new ModelPassenger();
        modelTicket = new ModelTicket();
        renderer = new RendererCenterRenderer();
        alPassenger = modelPassenger.getList();
    }

    @Override
    public int getRowCount() {
        return alPassenger.size();
    }

    @Override
    public int getColumnCount() {
        return arCols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Passenger objPassenger = alPassenger.get(rowIndex);
        Object result = null;
        switch(columnIndex){
            case 0:
                result =  objPassenger.getId();
                break;
            case 1:
                result =  objPassenger.getPassport();
                break;
            case 2:
                result =  objPassenger.getFullName();
                break;
            case 3:
                result =  objPassenger.getBirthday();
                break;
            case 4:
                result =  objPassenger.getNativeCountry();
                break;
            case 5:
                result =  objPassenger.getGender();
                break;
            case 6:
                result =  objPassenger.getNationality();
                break;
            case 7:
                result =  objPassenger.getPhone();
                break;
            case 8:
                result =  objPassenger.getAddress();
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
            return Date.class;
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
        if(columnIndex == 8){
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

    public int addPassenger(Passenger objPassenger) {
        int idPassenger = modelPassenger.addPassenger(objPassenger);
        return idPassenger;
    }

    public Passenger getValueAtRows(int row) {
        int modelRow = table.convertRowIndexToModel(row);
        return alPassenger.get(modelRow);
    }

    public int editPassenger(Passenger objPassenger) {
        int result = modelPassenger.editPassenger(objPassenger);
        return result;
    }

    public Passenger findPassenger(String passport) {
        Passenger objPassenger = modelPassenger.findPassenger(passport);
        return objPassenger;
    }

    public int deletePassenger(int id, int row) {
        int result = 0;
        System.out.println("controller.ControllerPassenger.deletePassenger()" + id);
        int deleteTicket = modelTicket.deleteTicketPassenger(id);
        if(deleteTicket > 0){
            result = modelPassenger.deletePassenger(id);
            if(result > 0){
                int rowModel = table.convertRowIndexToModel(row);
                alPassenger.remove(rowModel);
                this.fireTableDataChanged();
            }
        }
        return result;
    }
}
