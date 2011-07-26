/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lfcc;

import javax.swing.*;

/**
 *
 * @author bbrox
 */
public class Main {

    private static void createAndShowGUI() {

        WindowContainer wc = new WindowContainer();
        wc.setVisible(true);
}
   
    public static void main(String[] args) {

        UIManager.put("swing.boldMetal", Boolean.FALSE);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });


        //if miner set button.setText("phoenix");
        

    }

}
