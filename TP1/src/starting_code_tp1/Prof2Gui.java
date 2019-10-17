/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starting_code_tp1;

import jade.gui.GuiEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Ir. M. El Adoui
 */
public class Prof2Gui extends JFrame {
    //déclaration de l'agent Prof
    private Prof2Agent Prof;
      public Prof2Gui (){

    }

public void setProfAgent(Prof2Agent Prof){
    this.Prof=Prof;
}
public void showMessage(String msg, boolean append){
    if(append==true){
  //affichage dans une TexAria! avec retour à la ligne
      
    }
    else{
        // affichage dans une TexAria! sans retour à la ligne
    }
}

}
    
