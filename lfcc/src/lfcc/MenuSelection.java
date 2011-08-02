/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lfcc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;


/**
 *
 * @author skristyn
 */
public class MenuSelection implements ActionListener {
   
   private int menuItem;
   
   public MenuSelection (int menuItem) {
       this.menuItem = menuItem;
   }
    
    public void actionPerformed (ActionEvent e) {
        
        if (menuItem == 1){
            // this should be changed to something less drastic..
            System.exit(0);
        }
        
        else if (menuItem == 2) {
            JDialog f = new AboutDialog(new JFrame());
            f.show();
        }
    }
    
}
