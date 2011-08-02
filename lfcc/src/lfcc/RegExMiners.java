package lfcc;

/**
 *
 * @author nottinhill
 */


import java.io.*;
import java.util.TimerTask;
import javax.swing.*;
// import org.apache.commons.lang.StringUtils;


public class RegExMiners extends TimerTask{

    private int adapterNo;
    private JLabel labelNo;
    private int aticfgRow;
    private int aticfgColumn;

    public RegExMiners (int adapterNo, JLabel labelNo, int aticfgRow, int aticfgColumn) {
        this.adapterNo = adapterNo;
        this.labelNo = labelNo;
        this.aticfgRow = aticfgRow;
        this.aticfgColumn = aticfgColumn;
    }

    public void run () {

    try {
      String bash_str;
      String[] linesArray;
      linesArray = new String[10];
      int i = 0;
      String execString = "aticonfig --odgc --adapter=" + adapterNo;
      Runtime rt          = Runtime.getRuntime();
      Process proc        = rt.exec(execString);
      DataInputStream ls_in = new DataInputStream(proc.getInputStream());

      try {
            while ((bash_str = ls_in.readLine()) != null) {
               linesArray[i] = bash_str;
               i++;
            }

            String[] clocks = linesArray[aticfgRow].split("\\s+");
            labelNo.setText(clocks[aticfgColumn] + " MHz");

             // alternative
            //String[] clocks = StringUtils.split(StringUtils.substringAfter(linesArray[3], ":"));
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
