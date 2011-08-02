package lfcc;

import javax.swing.*;
import java.util.Timer;
import java.awt.Font;
/**
 *
 * @author nottinhill
 */
public class WindowContainer extends JFrame {

    // general instance variables
    Timer timerTemp0;
    Timer timerTemp1;
    Timer timerTemp2;
    Timer timerTemp3;

    Timer timerClock1;
    Timer timerClock2;

    Timer timerClock3;
    Timer timerClock4;

    Timer timerClock5;
    Timer timerClock6;

    Timer timerClock7;
    Timer timerClock8;
    
    int seconds;

    private JMenuBar bar;
    private JMenu fileMenu;
    private JMenuItem aboutMenu;
    private JMenuItem exitMenu;

    // Panels
    JPanel content = new JPanel();

    // FANS
    private JLabel fanlabel0 = new JLabel("Fans");

    // SLIDERS
    private JSlider slider0;
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private JLabel sliderLabel0 = new JLabel("unknown");
    private JLabel sliderLabel1 = new JLabel("unknown");
    private JLabel sliderLabel2 = new JLabel("unknown");
    private JLabel sliderLabel3 = new JLabel("unknown");

    private JButton commit0 = new JButton("Commit");
    private JButton commit1 = new JButton("Commit");
    private JButton commit2 = new JButton("Commit");
    private JButton commit3 = new JButton("Commit");

    // Temperatures
    private JLabel templabel = new JLabel("°C");
    private JLabel templabel0 = new JLabel("n/a");
    private JLabel templabel1 = new JLabel("n/a");
    private JLabel templabel2 = new JLabel("n/a");
    private JLabel templabel3 = new JLabel("n/a");

    // Clocks

    private JLabel clocklabel01 = new JLabel("GPU");
    private JLabel clocklabel02 = new JLabel("Mem");

    private JLabel clocklabel1 = new JLabel("n/a");
    private JLabel clocklabel2 = new JLabel("n/a");
    private JLabel clocklabel3 = new JLabel("n/a");
    private JLabel clocklabel4 = new JLabel("n/a");
    private JLabel clocklabel5 = new JLabel("n/a");
    private JLabel clocklabel6 = new JLabel("n/a");
    private JLabel clocklabel7 = new JLabel("n/a");
    private JLabel clocklabel8 = new JLabel("n/a");

    private JComboBox clockChoiceGPU0 = new JComboBox();
    private JComboBox clockChoiceMEM0 = new JComboBox();
    private JComboBox clockChoiceGPU1 = new JComboBox();
    private JComboBox clockChoiceMEM1 = new JComboBox();
    private JComboBox clockChoiceGPU2 = new JComboBox();
    private JComboBox clockChoiceMEM2 = new JComboBox();
    private JComboBox clockChoiceGPU3 = new JComboBox();
    private JComboBox clockChoiceMEM3 = new JComboBox();

    private JButton commitClockGPU0 = new JButton("Set");
    private JButton commitClockGPU1 = new JButton("Set");
    private JButton commitClockGPU2 = new JButton("Set");
    private JButton commitClockGPU3 = new JButton("Set");


    // UI

    private JLabel setMinerLabel = new JLabel("Path to linux-fcc");
    static JTextField path = new JTextField(System.getProperty("user.dir") + "/");
    static JTextArea area = new JTextArea(5, 20);
    private JScrollPane scrollPane = new JScrollPane(area);
    private JLabel scrollPaneLabel = new JLabel("Program Output");



    public WindowContainer ()
    {
        setSize(465,620);
        setTitle("Linux Fan and Clock Control - 0.1");
        setLocation(350,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // PANEL Layout
        content.setLayout(null);
     
        // SUBPANELS
        // Panel 1 - Fans
        content.add(fanlabel0);
        fanlabel0.setBounds(10,40,200,30);

        slider0 = new JSlider();
        slider1 = new JSlider();
        slider2 = new JSlider();
        slider3 = new JSlider();
        slider0.setValue(50);
        slider1.setValue(50);
        slider2.setValue(50);
        slider3.setValue(50);
        slider0.addChangeListener(new MyChangeAction(sliderLabel0, slider0));
        slider1.addChangeListener(new MyChangeAction(sliderLabel1, slider1));
        slider2.addChangeListener(new MyChangeAction(sliderLabel2, slider2));
        slider3.addChangeListener(new MyChangeAction(sliderLabel3, slider3));
        content.add(slider0);
        content.add(slider1);
        content.add(slider2);
        content.add(slider3);

        slider0.setMajorTickSpacing(50);
        slider0.setMinorTickSpacing(25);
        slider0.setPaintTicks(true);
        slider0.setPaintLabels(true);

        slider1.setMajorTickSpacing(50);
        slider1.setMinorTickSpacing(25);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);

        slider2.setMajorTickSpacing(50);
        slider2.setMinorTickSpacing(25);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);

        slider3.setMajorTickSpacing(50);
        slider3.setMinorTickSpacing(25);
        slider3.setPaintTicks(true);
        slider3.setPaintLabels(true);

        content.add(sliderLabel0);
        content.add(sliderLabel1);
        content.add(sliderLabel2);
        content.add(sliderLabel3);
        
        sliderLabel0.setBounds(80,20,100,30);
        sliderLabel1.setBounds(180,20,100,30);
        sliderLabel2.setBounds(280,20,100,30);
        sliderLabel3.setBounds(380,20,100,30);

        slider0.setBounds(45,50,90,40);
        slider1.setBounds(145,50,90,40);
        slider2.setBounds(245,50,90,40);
        slider3.setBounds(345,50,90,40);

        content.add(commit0);
        content.add(commit1);
        content.add(commit2);
        content.add(commit3);
        commit0.setBounds(50,100,83,18);
        commit1.setBounds(150,100,83,18);
        commit2.setBounds(250,100,83,18);
        commit3.setBounds(350,100,83,18);

        commit0.addActionListener(new MyCommitPressed(slider0, 0));
        commit1.addActionListener(new MyCommitPressed(slider1, 1));
        commit2.addActionListener(new MyCommitPressed(slider2, 2));
        commit3.addActionListener(new MyCommitPressed(slider3, 3));

        // Panel 2 - Temps
        content.add(templabel);
        content.add(templabel0);
        content.add(templabel1);
        content.add(templabel2);
        content.add(templabel3);

        MyLoadFans mylm0 = new MyLoadFans(0);
        sliderLabel0.setText(mylm0.getSwitch(0)); // setting fan text from file
        slider0.setValue(Integer.parseInt(mylm0.getSwitch(0))); // setting label position from file

        MyLoadFans mylm1 = new MyLoadFans(1);
        sliderLabel1.setText(mylm1.getSwitch(0)); // setting fan text from file
        slider1.setValue(Integer.parseInt(mylm1.getSwitch(0))); // setting label position from file

        MyLoadFans mylm2 = new MyLoadFans(2);
        sliderLabel2.setText(mylm2.getSwitch(0)); // setting fan text from file
        slider2.setValue(Integer.parseInt(mylm2.getSwitch(0))); // setting label position from file

        MyLoadFans mylm3 = new MyLoadFans(3);
        sliderLabel3.setText(mylm3.getSwitch(0)); // setting fan text from file
        slider3.setValue(Integer.parseInt(mylm3.getSwitch(0))); // setting label position from file

        // the "Temp" label itself
        templabel.setBounds(10,140,150,30);
        // GPU1
        templabel0.setBounds(50,140,150,30);
        templabel0.setFont(new Font("Sans Serif", Font.BOLD, 12));
        // GPU2
        templabel1.setBounds(150,140,150,30);
        templabel1.setFont(new Font("Sans Serif", Font.BOLD, 12));
        // GPU3
        templabel2.setBounds(250,140,150,30);
        templabel2.setFont(new Font("Sans Serif", Font.BOLD, 12));
        // GPU4
        templabel3.setBounds(350,140,150,30);
        templabel3.setFont(new Font("Sans Serif", Font.BOLD, 12));

        // call every n seconds the regex aticonfigTEMP class
        timerTemp0 = new Timer();
        timerTemp0.schedule(new RegExAtiConfigTemp(0, templabel0), 0, 8*1000);
        
        timerTemp1 = new Timer();
        timerTemp1.schedule(new RegExAtiConfigTemp(1, templabel1), 0, 8*1000);
        
        timerTemp2 = new Timer();
        timerTemp2.schedule(new RegExAtiConfigTemp(2, templabel2), 0, 8*1000);
        
        timerTemp3 = new Timer();
        timerTemp3.schedule(new RegExAtiConfigTemp(3, templabel3), 0, 8*1000);

        // Panel - Clocks
        // This is just the section header label
        content.add(clocklabel01);
        content.add(clocklabel02);

        // now we read from aticonfig
        content.add(clocklabel1); // 1st clock GPU
        content.add(clocklabel2); // 1st clock MEM
        // here the user gives input in drop down
        content.add(clockChoiceGPU0); // 1st dropdown GPU
        content.add(clockChoiceMEM0); // 1st dropdown Mem

        content.add(clocklabel3); // sorry for the bad naming this is 2nd GPU clock reading
        content.add(clocklabel4); // this is 2nd Mem clock reading
        content.add(clockChoiceGPU1); // this is 2nd GPU drop down
        content.add(clockChoiceMEM1); // this is 2nd  Mem drop down

        content.add(clocklabel5);
        content.add(clocklabel6);
        content.add(clockChoiceGPU2);
        content.add(clockChoiceMEM2);

        content.add(clocklabel7);
        content.add(clocklabel8);
        content.add(clockChoiceGPU3);
        content.add(clockChoiceMEM3);


        clocklabel01.setBounds(10,180,150,30); // the section label GPU

        clocklabel1.setBounds(50,180,150,30); // reading GPUs
        clockChoiceGPU0.setBounds(50,210,60,20); // dropdown
        clocklabel3.setBounds(150,180,150,30);
        clockChoiceGPU1.setBounds(150,210,60,20);
        clocklabel5.setBounds(250,180,150,30);
        clockChoiceGPU2.setBounds(250,210,60,20);
        clocklabel7.setBounds(350,180,150,30);
        clockChoiceGPU3.setBounds(350,210,60,20);

        clocklabel02.setBounds(10,235,150,30); // the main section label MEM
        
        clocklabel2.setBounds(50,235,150,30); // reading MEMs
        clockChoiceMEM0.setBounds(50,265,60,20); // dropdown
        clocklabel4.setBounds(150,235,150,30);
        clockChoiceMEM1.setBounds(150,265,60,20);
        clocklabel6.setBounds(250,235,150,30);
        clockChoiceMEM2.setBounds(250,265,60,20);
        clocklabel8.setBounds(350,235,150,30);
        clockChoiceMEM3.setBounds(350,265,60,20);
        

        timerClock1 = new Timer();
        //RegExAtiConfigOc(Adapter, Label, RegExRow, RegExColumn), delay, interval in ms
        timerClock1.schedule(new RegExAtiConfigOc(0, clocklabel1, 3, 4), 0, 30*1000);

        timerClock2 = new Timer();
        timerClock2.schedule(new RegExAtiConfigOc(0, clocklabel2, 3, 5), 0, 30*1000);

        timerClock3 = new Timer();
        timerClock3.schedule(new RegExAtiConfigOc(1, clocklabel3, 3, 4), 0, 30*1000);

        timerClock4 = new Timer();
        timerClock4.schedule(new RegExAtiConfigOc(1, clocklabel4, 3, 5), 0, 30*1000);

        timerClock5 = new Timer();
        timerClock5.schedule(new RegExAtiConfigOc(2, clocklabel5, 3, 4), 0, 30*1000);

        timerClock6 = new Timer();
        timerClock6.schedule(new RegExAtiConfigOc(2, clocklabel6, 3, 5), 0, 30*1000);

        timerClock7 = new Timer();
        timerClock7.schedule(new RegExAtiConfigOc(3, clocklabel7, 3, 4), 0, 30*1000);

        timerClock8 = new Timer();
        timerClock8.schedule(new RegExAtiConfigOc(3, clocklabel8, 3, 5), 0, 30*1000);


        // Filling the DropDown Menus
        // Adapter 0
        int z = 1200;
        while (z >= 550){
            clockChoiceGPU0.addItem(""+Integer.toString(z)+"");
            z = z -10;
        }

        int x = 1200;
        while (x >= 300){
            clockChoiceMEM0.addItem(""+Integer.toString(x)+"");
            x = x -10;
        }

        // Adapter 1
        int z1 = 1200;
        while (z1 >= 550){
            clockChoiceGPU1.addItem(""+Integer.toString(z1)+"");
            z1 = z1 -10;
        }

        int x1 = 1200;
        while (x1 >= 300){
            clockChoiceMEM1.addItem(""+Integer.toString(x1)+"");
            x1 = x1 -10;
        }
        // Adapter 2
        int z2 = 1200;
        while (z2 >= 550){
            clockChoiceGPU2.addItem(""+Integer.toString(z2)+"");
            z2 = z2 -10;
        }

        int x2 = 1200;
        while (x2 >= 300){
            clockChoiceMEM2.addItem(""+Integer.toString(x2)+"");
            x2 = x2 -10;
        }
        // Adapter 3
        int z3 = 1200;
        while (z3 >= 550){
            clockChoiceGPU3.addItem(""+Integer.toString(z3)+"");
            z3 = z3 -10;
        }

        int x3 = 1200;
        while (x3 >= 300){
            clockChoiceMEM3.addItem(""+Integer.toString(x3)+"");
            x3 = x3 -10;
        }

        // adding a start field...
        clockChoiceGPU0.addItem("set..");
        clockChoiceMEM0.addItem("set..");
        clockChoiceGPU0.setSelectedItem("set..");
        clockChoiceMEM0.setSelectedItem("set..");

        clockChoiceGPU1.addItem("set..");
        clockChoiceMEM1.addItem("set..");
        clockChoiceGPU1.setSelectedItem("set..");
        clockChoiceMEM1.setSelectedItem("set..");

        clockChoiceGPU2.addItem("set..");
        clockChoiceMEM2.addItem("set..");
        clockChoiceGPU2.setSelectedItem("set..");
        clockChoiceMEM2.setSelectedItem("set..");

        clockChoiceGPU3.addItem("set..");
        clockChoiceMEM3.addItem("set..");
        clockChoiceGPU3.setSelectedItem("set..");
        clockChoiceMEM3.setSelectedItem("set..");

        // Commiting Clock Values
        content.add(commitClockGPU0);
        commitClockGPU0.setBounds(50,290,60,20);
        commitClockGPU0.addActionListener(new MyCommitPressedClocks(0, clockChoiceGPU0, clockChoiceMEM0));

        content.add(commitClockGPU1);
        commitClockGPU1.setBounds(150,290,60,20);
        commitClockGPU1.addActionListener(new MyCommitPressedClocks(1, clockChoiceGPU1, clockChoiceMEM1));

        content.add(commitClockGPU2);
        commitClockGPU2.setBounds(250,290,60,20);
        commitClockGPU2.addActionListener(new MyCommitPressedClocks(2, clockChoiceGPU2, clockChoiceMEM2));

        content.add(commitClockGPU3);
        commitClockGPU3.setBounds(350,290,60,20);
        commitClockGPU3.addActionListener(new MyCommitPressedClocks(3, clockChoiceGPU3, clockChoiceMEM3));


        // Panel 5 - UI
        content.add(path);
        content.add(setMinerLabel);
      
        setMinerLabel.setBounds(40,340,120,30);
        path.setBounds(40,370,350,30);

        content.add(scrollPaneLabel);
        scrollPaneLabel.setBounds(40,410,350,30);

        content.add(scrollPane);
        scrollPane.setBounds(40,440,350,100);

        area.setEditable(false);
        setContentPane(content);

        // TOP MENU
         bar = new JMenuBar();
        setJMenuBar(bar);
        fileMenu = new JMenu("File");
        aboutMenu = new JMenuItem("About");
        exitMenu = new JMenuItem("Exit");
        bar.add(fileMenu);
        fileMenu.add(aboutMenu);
        fileMenu.add(exitMenu);
        exitMenu.addActionListener(new MenuSelection(1));
        aboutMenu.addActionListener(new MenuSelection(2));
    }
}