/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lfcc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author nottinhill
 */
public class MyCommitPressedClocks implements ActionListener {

    private final static String newline = "\n";
    private JComboBox ComboboxGPUNo;
    private JComboBox ComboboxMEMNo;
    private int adapterNo;

    public MyCommitPressedClocks (int adapterNo, JComboBox ComboboxGPUNo, JComboBox ComboboxMEMNo){
        this.ComboboxGPUNo = ComboboxGPUNo;
        this.ComboboxMEMNo = ComboboxMEMNo;
        this.adapterNo = adapterNo;
    }

    public void actionPerformed (ActionEvent e) {

        try {
          String bash_str;
          String execString = WindowContainer.path.getText() + "overclock.sh " + adapterNo + " " + ComboboxGPUNo.getSelectedItem() + " " + ComboboxMEMNo.getSelectedItem();
          Runtime rt          = Runtime.getRuntime();
          Process proc        = rt.exec(execString);

          // print shell output to GUI console
          DataInputStream ls_in = new DataInputStream(
                                              proc.getInputStream());

          try {
            while ((bash_str = ls_in.readLine()) != null) {
                WindowContainer.area.append(bash_str + newline);
                WindowContainer.area.setCaretPosition(WindowContainer.area.getDocument().getLength());
            }
          }

          catch (IOException ea) {
            System.exit(0);
          }

        }

        catch (IOException e1) {
                System.err.println(e1);
                System.exit(1);
        }
    }
}
