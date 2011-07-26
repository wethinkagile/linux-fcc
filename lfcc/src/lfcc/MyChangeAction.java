/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lfcc;

import javax.swing.event.*;
import javax.swing.*;


/**
 *
 * @author nottinhill
 */
 public class MyChangeAction implements ChangeListener {

      // instance vars
      private JSlider sliderNo;
      private JLabel labelNo;

      // constructor
      public MyChangeAction(JLabel labelNo, JSlider sliderNo){
        
        this.sliderNo = sliderNo;
        this.labelNo = labelNo;
      }

      public void stateChanged (ChangeEvent ce) {
          
          int value = sliderNo.getValue();
          String str = Integer.toString(value);
          labelNo.setText(str);
      }
  }