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
public class MyCommitPressed implements ActionListener {

    private final static String newline = "\n";
    private JSlider sliderNo;
    private int adapterNo;
    private boolean exists;

    public MyCommitPressed (JSlider sliderNo, int adapterNo){
        this.sliderNo = sliderNo;
        this.adapterNo = adapterNo;
    }

    public void actionPerformed (ActionEvent e) {
        
        // check if fancontrol file is there
        File file=new File(WindowContainer.path.getText() + "fancontrol.sh");
        exists = file.exists();
        if (!exists) {
            // returns false if File or directory does not exist
            System.out.println("Creating fancontrol file..");
            try {
              // Create fancontrol file
              FileWriter fstream = new FileWriter(WindowContainer.path.getText() + "fancontrol.sh");
              BufferedWriter out = new BufferedWriter(fstream);
              out.write("#!/bin/bash" + "\n");
              out.write("export DISPLAY=:0.$1; aticonfig --pplib-cmd \"set fanspeed 0 $2\"" + "\n");
              out.write("export DISPLAY=:0" + "\n");
              //Close the output stream
              out.close();
              // setpermissions
              File newFile=new File(WindowContainer.path.getText() + "fancontrol.sh");
              newFile.setExecutable(true,true);
            }
            catch (Exception ea){//Catch exception if any
              System.err.println("Error: " + ea.getMessage());
            }
        }



        try {
          String bash_str;
          String execString = WindowContainer.path.getText() + "fancontrol.sh " + adapterNo + " " + sliderNo.getValue();
          Runtime rt          = Runtime.getRuntime();
          Process proc        = rt.exec(execString);
          DataInputStream ls_in = new DataInputStream(proc.getInputStream());
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

        // store the values into a file
        try {
          // Create file
          FileWriter fstream = new FileWriter(WindowContainer.path.getText() + "jmhud_" + adapterNo + ".txt");
          BufferedWriter out = new BufferedWriter(fstream);
          out.write(sliderNo.getValue() + "\n");

          //Close the output stream
          out.close();
        }
        catch (Exception ea){//Catch exception if any
          System.err.println("Error: " + ea.getMessage());
        }
    }
}
