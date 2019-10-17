/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starting_code_tp1;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
/**
 **
 * @author Ir. M. El Adoui
 */
public class Admin1Agent extends Agent {
   @Override
    protected void setup(){
        System.out.println("Démarrage de l'agent Admin 1");
        
        this.addBehaviour(new CyclicBehaviour(){
        //déclaration des variables avant d'entrer dans l'action de cyclic
        double somme1=0;
        double somme2=0;
        double moy1;
        double moy2;
        @Override
        public void action(){         
           System.out.println("Admin 1 : les notes reçus en temps réel sont : "); // il est possible de définir une interface associée à admin1
           ACLMessage msg = receive();
           if(msg!=null){
               if(msg.getOntology().equals("module1")){// verification par rapport au module1 
                   
               String[] tmp = null; // le contenu du message est un tableau !
                     try {
                         tmp = (String[]) msg.getContentObject();
                         double val1=Double.parseDouble(tmp[0]);
                         double val2=Double.parseDouble(tmp[1]);
                         
                         /*ICI donc tmp[0] est note 1 et tmp[1] est note 2*/
                         
                         System.out.println("la note recu est: " + val1 +" et"+ val2);  
                         
                         /* ICI les instructions pour le calcule de la somme des deux notes après la conversion en double plus le calcule de la moyenne 1*/
                         //double val1=Double.valueOf(tmp[0]);
                         //double val2=Double.valueOf(tmp[1]);
                         somme1=val1+val2;
                         moy1= somme1/2;                
                         
                         
                         /*une fois la moyenne1 du module 1 est calculée, il doit être envoyé à admin2 avec l'ontologie moy1*/
                         /*ICI 5 intstructions pour définir, donner l'agent recepteur, donner l'ontologie, le cotenu, et l'envoie du message*/
                     } 
                     catch (UnreadableException e) {
                         e.printStackTrace();
                      }
           }
                if(msg.getOntology().equals("module2")){// verification par rapport au module2
                      String[] tmp2 = null;
                     try {
                         tmp2 = (String[]) msg.getContentObject();
                         /*ICI donc tmp[0] est note 1 et tmp[1] est note 2*/
                      
                         /* ICI les instructions pour le calcule de la somme des deux notes après la conversion en double plus le calcule de la moyenne 2*/
                         /*une fois la moyenne2 du module 2 est calculée, il doit être envoyé à admin2 avec l'ontologie moy2*/
                         /*ICI 5 intstructions pour définir, donner l'agent recepteur, donner l'ontologie, le cotenu, et l'envoie du message*/
  } 
                     catch (UnreadableException e) {
                         e.printStackTrace();
                      }
           }
           }
           else block();
           }  
        });
       
     }
    @Override
    protected void takeDown(){
        try {
 	DFService.deregister(this);
             } 
        catch (FIPAException e) {
                                    }
 System.out.println(getLocalName() + ": Admin 1 Terminée" );
}  
}
