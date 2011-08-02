package lfcc;

import java.io.*;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.Color;

/**
 *
 * @author nottinhill
 */
public class RegExAtiConfigTemp extends TimerTask{

    private int adapterNo;
    private JLabel labelNo;

    public RegExAtiConfigTemp (int adapterNo, JLabel labelNo) {
        this.adapterNo = adapterNo;
        this.labelNo = labelNo;
    }

    public void run () {

    try {
      String bash_str;
      String execString = "aticonfig --odgt --adapter=" + adapterNo;
      String[] linesArray;
      int i = 0;
      linesArray = new String[10];
      Runtime rt          = Runtime.getRuntime();
      Process proc        = rt.exec(execString);
      DataInputStream ls_in = new DataInputStream(proc.getInputStream());

      try {
            while ((bash_str = ls_in.readLine()) != null) {
                linesArray[i] = bash_str;
                i++;
            }

            // regex the temp out of shell output
            String[] temps = linesArray[2].split("\\s+");
            String temp = temps[5];
            // parse the retreived string to a number
            float tempFloat = Float.parseFloat(temp);

            // Apply Colors regarding to temperature
            // Atomic
            if(tempFloat >= 65){
                labelNo.setForeground(new Color(252,67,0));
            }
            // Hot
            else if((tempFloat >= 57) && (tempFloat < 65))
            {
                labelNo.setForeground(new Color(244,134,0));
            }
            // Tepid
            else if((tempFloat >= 50) && (tempFloat < 57)){
                    labelNo.setForeground(new Color(204,190,0));
                }
            // Cool
            else if (tempFloat < 50){
                    labelNo.setForeground(new Color(14,173,209));
                }

            labelNo.setText(temp);


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
