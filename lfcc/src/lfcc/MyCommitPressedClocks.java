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
    private boolean exists;

    public MyCommitPressedClocks (int adapterNo, JComboBox ComboboxGPUNo, JComboBox ComboboxMEMNo){
        this.ComboboxGPUNo = ComboboxGPUNo;
        this.ComboboxMEMNo = ComboboxMEMNo;
        this.adapterNo = adapterNo;
    }

    public void actionPerformed (ActionEvent e) {
           
        // check if fancontrol file is there
        File file=new File(WindowContainer.path.getText() + "overclock.sh");
        exists = file.exists();
        if (!exists) {
            // returns false if File or directory does not exist
            System.out.println("Creating overclock file..");
            try {
              // Create fancontrol file
              FileWriter fstream = new FileWriter(WindowContainer.path.getText() + "fancontrol.sh");
              BufferedWriter out = new BufferedWriter(fstream);
              out.write("#!/bin/bash" + "\n");
              out.write("DISPLAY=:0 aticonfig --od-enable --adapter=all" + "\n");
              out.write("DISPLAY=:0 aticonfig --od-setclocks=$2,$3 --adapter=$1" + "\n");

              //Close the output stream
              out.close();
              // setpermissions
              File newFile=new File(WindowContainer.path.getText() + "overclock.sh");
              newFile.setExecutable(true,true);
            }
            catch (Exception ea){//Catch exception if any
              System.err.println("Error: " + ea.getMessage());
            }
        }
        
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
