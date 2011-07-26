/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lfcc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.regex.*;

/**
 *
 * @author nottinhill
 * PLEASE NOTE: UNUSED CLASS - NEVER GOT THIS TO RUN PROPERLY
 */
public class MySavePressedMiners implements ActionListener{

    private int adapterNo;
    private JLabel hashlabel1;
    private JTextField hashlabel2;
    private JTextField hashlabel3;
    private JTextField hashlabel4;
    private Process p;
    private String line = null;
    private Pattern pReg;

    public MySavePressedMiners (int adapterNo, JLabel hashlabel1, JTextField hashlabel2, JTextField hashlabel3, JTextField hashlabel4){
        this.adapterNo = adapterNo;
        this.hashlabel1 = hashlabel1;
        this.hashlabel2 = hashlabel2;
        this.hashlabel3 = hashlabel3;
        this.hashlabel4 = hashlabel4;
    }

    public void actionPerformed (ActionEvent e) {
    // store the values into a file
        try {
          // Create file
          FileWriter fstream = new FileWriter(WindowContainer.path.getText() + "jmhud_" + adapterNo + ".txt");
          BufferedWriter out = new BufferedWriter(fstream);
          out.write(hashlabel2.getText() + "\n");
          out.write(hashlabel3.getText() + "\n");
          out.write(hashlabel4.getText() + "\n");

          //Close the output stream
          out.close();
      }
      catch (Exception ea){//Catch exception if any
          System.err.println("Error: " + ea.getMessage());
      }

          // 1=AGRESSION(hashlabel2) 2=USER/PASS(hashlabel3) 3=POOL/PORT(hashlabel4) 4=DEVICE(adapterNo)
         //System.out.println(WindowContainer.path.getText() + "jmhudMine.sh " + hashlabel2.getText() + " " + hashlabel3.getText() + " " + hashlabel4.getText() + " " + adapterNo);
        try {
            p = Runtime.getRuntime().exec("/home/legolas/Downloads/phoenix-1.50/phoenix.py -u user:pass@bitcoins.lc:8080/ -k phatk VECTORS BFI_INT FASTLOOP=FALSE WORKSIZE=128 AGGRESSION=6 DEVICE=4");
       
           // System.out.println(out);

               //WindowContainer.area.append();
               // WindowContainer.area.setCaretPosition(WindowContainer.area.getDocument().getLength());
       }

        catch (IOException ea) {
            System.exit(0);
        }
    }
    


}
    


