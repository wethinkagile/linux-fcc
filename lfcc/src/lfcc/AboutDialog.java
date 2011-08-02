package lfcc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JPanel;

public class AboutDialog extends JDialog {

    private JTextField statement;
    private JLabel line0;
    private JLabel line1;
    private JLabel line2;
    private JLabel line3;

  public AboutDialog(JFrame parent) {
    super(parent, "About linux-fcc", true);

    Box b = Box.createVerticalBox();
    b.add(Box.createGlue());
    line0 = new JLabel(" ");
    line1 = new JLabel("\t \t \t \t \t \t \t \t \t \t \t \t To show your appreciation");
    line2 = new JLabel("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t send some Bitcoins to");
    b.add(line0);
    b.add(line1);
    b.add(line2);
    statement = new JTextField("18QeVng1ArbTBoyFTXGwk78caQgDESUC4v");
    statement.setEditable(false);
    statement.setBorder(null);
    statement.setForeground(UIManager.getColor("Label.foreground"));
    statement.setFont(UIManager.getFont("Label.font"));
    b.add(statement);
    line3 = new JLabel("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t Thanks!");
    b.add(line3);

    b.add(Box.createGlue());
    getContentPane().add(b, "Center");

    JPanel p2 = new JPanel();
    JButton ok = new JButton("OK");
    p2.add(ok);
    getContentPane().add(p2, "South");

    ok.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        setVisible(false);
      }
    });
    setLocation(400,350);
    setSize(285, 165);
  }
}
