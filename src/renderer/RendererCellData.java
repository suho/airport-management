/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author PhiLong
 */
public class RendererCellData extends DefaultTableCellRenderer {
    private SimpleDateFormat sdf;

    public RendererCellData() {
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    protected void setValue(Object value) {
        super.setValue(sdf.format(value));
    }
    
    
}
