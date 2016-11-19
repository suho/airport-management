/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.FlightSchedule;
import bean.Ticket;
import controller.ControllerFlightSchedule;
import controller.ControllerTicket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DELL
 */
public class TicketManagement extends javax.swing.JPanel {
    private ControllerTicket controllerTicket;
    private ControllerFlightSchedule controllerFlightSchedule;
    private int row;

    /**
     * Creates new form TicketManagement
     */
    public TicketManagement() {
        initComponents();
        controllerTicket = new ControllerTicket(tbMain);
        controllerFlightSchedule = new ControllerFlightSchedule(null);
        controllerFlightSchedule.loadFlightSchedule(jComboBoxFlightSchedule, true, null);
        controllerTicket.loadTable();
        this.loadActionListener();
    }
    private void findFlightSchedule(int id) {
        TableRowSorter sorter = new TableRowSorter(tbMain.getModel());
        tbMain.setRowSorter(sorter);
        RowFilter<AbstractTableModel, Object> filterFlightSchedule = RowFilter.regexFilter("(?i)" + id, 5);
        ArrayList<RowFilter<AbstractTableModel, Object>> arList = new ArrayList<>();
        arList.add(filterFlightSchedule);
        RowFilter<AbstractTableModel, Object> find = RowFilter.andFilter(arList);
        sorter.setRowFilter(find);
    }
    
    public void loadActionListener(){
        ((JLabel)jComboBoxFlightSchedule.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jComboBoxFlightSchedule.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                FlightSchedule objFlightSchedule = (FlightSchedule)jComboBoxFlightSchedule.getSelectedItem();
                if(objFlightSchedule.getId() != 0){
                    findFlightSchedule(objFlightSchedule.getId());
                }
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jComboBoxFlightSchedule = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMain = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jTextFieldSearch.setText("Enter your name...");
        jTextFieldSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSearchMouseClicked(evt);
            }
        });

        jButtonSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search-icon.png"))); // NOI18N
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jComboBoxFlightSchedule.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxFlightSchedule.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----- Choose Flight Schedule -----", "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addComponent(jComboBoxFlightSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSearch)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jComboBoxFlightSchedule, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(11, 11, 11))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());

        tbMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMain.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbMainMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbMain);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSearchMouseClicked
        // TODO add your handling code here:
        jTextFieldSearch.setText("");
    }//GEN-LAST:event_jTextFieldSearchMouseClicked

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        TableRowSorter sorter = new TableRowSorter(tbMain.getModel());
        tbMain.setRowSorter(sorter);
        String name = jTextFieldSearch.getText();
        RowFilter<AbstractTableModel, Object> filterName = RowFilter.regexFilter("(?i)" + name, 1);
        ArrayList<RowFilter<AbstractTableModel, Object>> arList = new ArrayList<>();
        arList.add(filterName);
        RowFilter<AbstractTableModel, Object> find = RowFilter.andFilter(arList);
        sorter.setRowFilter(find);
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void tbMainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMainMousePressed
        // TODO add your handling code here:
        row = tbMain.getSelectedRow();
        Ticket item = controllerTicket.getValueAtRows(row);
        tbMain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) 
            {
                int r = tbMain.rowAtPoint(e.getPoint());
                if (r >= 0 && r < tbMain.getRowCount()) {
                tbMain.setRowSelectionInterval(r, r);
            } else {
                tbMain.clearSelection();
            }
            if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
                JPopupMenu popup = createYourPopUp(item,tbMain);
                popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }//GEN-LAST:event_tbMainMousePressed

    public JPopupMenu createYourPopUp(Ticket item, JTable table)
    {
        JPopupMenu popup=new JPopupMenu();
        JMenuItem edit = new JMenuItem("Edit seatNo");
        JMenuItem detail =new JMenuItem("Detail");
        JMenuItem delete =new JMenuItem("Delete");
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditSeatNo(item).setVisible(true);
            }
        });
        detail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 new DetailTicket(item).setVisible(true);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, 
                    "Are you sure?",null, JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    int resultDelete = controllerTicket.deleteFlightSchedule(item.getId(), row);
                    if(resultDelete > 0){
                        JOptionPane.showMessageDialog(null, "Delete successfully!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Delete error!");
                    }
                }
            }
        });
        popup.add(edit);
        popup.add(detail);
        popup.add(delete);
        return popup;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox jComboBoxFlightSchedule;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTable tbMain;
    // End of variables declaration//GEN-END:variables
}