/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author PhiLong
 */
public class RendererCenterRenderer extends DefaultTableCellRenderer {
    private DefaultTableCellRenderer centerRenderer;

    public RendererCenterRenderer() {
    }
    public void setDefaultCenterRenderer(JTable table){
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(Integer.class, centerRenderer);
        table.setDefaultRenderer(Float.class, centerRenderer);
    }
}
