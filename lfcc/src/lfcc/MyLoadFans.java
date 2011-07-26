package lfcc;
import java.io.*;

/**
 *
 * @author nottinhill
 */
public class MyLoadFans  {

    private String[] linesArray = new String[3];
    private int i;    
    boolean exists;
    
    public MyLoadFans (int adapterNo) {
        i = 0;
        
        // check weather file exists 
        File file=new File(WindowContainer.path.getText() + "jmhud_" + adapterNo + ".txt");
        exists = file.exists();
        if (!exists) {
            // It returns false if File or directory does not exist
            System.out.println("Creating empty file..");
            try {
              // Create file
              FileWriter fstream = new FileWriter(WindowContainer.path.getText() + "jmhud_" + adapterNo + ".txt");
              BufferedWriter out = new BufferedWriter(fstream);
              out.write("50" + "\n");

              //Close the output stream
              out.close();
            }
            catch (Exception ea){//Catch exception if any
              System.err.println("Error: " + ea.getMessage());
            }
        }
        
        try {
            FileInputStream fstream = 
                    new FileInputStream(WindowContainer.path.getText() + "jmhud_" + adapterNo + ".txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

                while ((strLine = br.readLine()) != null)   {
                    // debug
                    // System.out.println (strLine);
                    linesArray[i] = strLine;
                    i++;
                }

                in.close();
        }

        catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    public String getSwitch(int lineNo){
        return linesArray[lineNo];
    }

}
