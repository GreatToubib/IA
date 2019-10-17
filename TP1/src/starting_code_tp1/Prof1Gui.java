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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import javax.swing.JTextField;
/**
 *
 * @author Ir. M. El Adoui
 */
public class Prof1Gui extends JFrame {
    String Admin[]= { "Admin1Agent","Admin2Agent"};
       
    private JLabel ClientLab = new JLabel ("Administration:");
    JComboBox jtextCourtiertLab = new JComboBox (Admin);
    
    private JLabel PieceLab = new JLabel ("les 2 notes:");
    //private JList jtextPieceLab = new JList(pieces);
    private JTextField jtextnote1 = new JTextField (6);
    private JTextField jtextnote2 = new JTextField (6);
    
    private JButton ButtonEnvoyer = new JButton("Envoyer");
    
    private JTextArea TextArea = new JTextArea();
    //déclaration de l'agent Prof
    private Prof1Agent Prof;
    public Prof1Gui (){
        JPanel Panel = new JPanel();
        Panel.setLayout(new FlowLayout());
        
        Panel.add(ClientLab);
        Panel.add(jtextCourtiertLab);
        Panel.add(PieceLab);
        Panel.add(jtextnote1);
        Panel.add(jtextnote2);
        Panel.add(ButtonEnvoyer);
     
        TextArea.setFont(new Font("Serif", Font.BOLD, 14));
        
       // Panel.add(TextArea);
        this.setTitle("Interface Prof1");
        this.setLayout(new BorderLayout());
        this.add(Panel, BorderLayout.NORTH);
        this.add(new JScrollPane(TextArea), BorderLayout.CENTER);
        this.setSize(600,400);
        this.setVisible(true);
        Map<String, Object> params = new HashMap<>();
        ButtonEnvoyer.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            
            String agentName=(String) jtextCourtiertLab.getSelectedItem();
            String note1=(String) jtextnote1.getText();
            String note2=(String) jtextnote2.getText();
            GuiEvent gev  = new GuiEvent(this,1);
            
            params.put("Admin1Agent",agentName);
            params.put("note1", note1);
            params.put("note2", note2);
            gev.addParameter(params);
            Prof.onGuiEvent(gev);
       
        } 
    });
        
      
        
    }
public Prof1Agent getProfAgent(){
    return Prof;
}

public void setProfAgent(Prof1Agent Prof){
    this.Prof=Prof;
}
public void showMessage(String msg, boolean append){
    if(append==true){
        Font font = new Font("Dialog", Font.BOLD, 16);
        TextArea.setFont(font);
        TextArea.setForeground(Color.WHITE);
        TextArea.setBackground(Color.BLUE);
        TextArea.append(msg+"\n");
      
    }
    else{
        TextArea.setText(msg);
    }
}

}
    
