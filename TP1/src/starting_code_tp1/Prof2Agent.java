/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starting_code_tp1;

import jade.core.AID;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ir. M. El Adoui
 */
public class Prof2Agent extends GuiAgent{ //Cet agent est lié à une interface, il est indisponsable que sa classe hérite de GuiAgent
    private Prof2Gui gui; // Il est demandé de crée la classe Prof2Gui (similaire à la classe Prof1Gui)
    @Override
    protected void setup(){
        gui = new Prof2Gui();//association d'une interface à l'agent
        gui.setProfAgent(this);
        gui.showMessage("Démarrage de l'agent Prof 2", true);// les message sont affichés sur l'interface du prof 2 grace à une fonction showMessage     
     }
    @Override
    protected void onGuiEvent(GuiEvent ev){ // cette fonction doit être définie pour les agent lié à des interfaces. elle est appelé depuis l'interface avec un paramètre 1
         switch(ev.getType()){
            case 1:
                gui.showMessage("Type d'évenement : 1", true);
                Map<String,Object> params= (Map<String,Object>) ev.getParameter(0); //récuperation d'une map contenant tous les élements encodé sur l'interface     
                String note1=(String)params.get("note1"); // note1
                String note2=(String)params.get("note2"); // note2
                String Agent =(String)params.get("Admin1Agent"); // le nom de l'agent à contacter.
                
                ACLMessage aclMsg=new ACLMessage(ACLMessage.REQUEST); // le type de message Request!
                aclMsg.addReceiver(new AID(Agent,AID.ISLOCALNAME)); // donnez le recepteur
         
             try { //envoie des deux notes à admin2 avec l'ontologie 'module2'
                              
                 /*3 instructions ici pour donner le contenu, définir l'ontologie de aclMsg et l'envoyer*/
                 
                 
                 gui.showMessage("Les notes ont été bien envoyé à l'adiministration", true);
                 gui.showMessage("Les calculs sont en cours...", true);
                 gui.showMessage("regardez les résultats sur votre console Netbeans", true);
                 } 
             catch (Exception ex) {
                 Logger.getLogger(Prof1Agent.class.getName()).log(Level.SEVERE, null, ex);
                 }           
                break;
            default :
                break;
        }
    }   
}
