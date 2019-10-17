/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package starting_code_tp1;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
/**
 *
 * @author Ir. M. El Adoui
 */

public class Admin2Agent extends Agent{
@Override
    protected void setup(){
        System.out.println("Démarrage de l'agent Admin 2");// il est possible de définir une interface graphique assosciée à Admin2
        
        this.addBehaviour(new CyclicBehaviour(){
        //définition et initialisation des variables nécessaires
        double someGlobale=0;
        double moyGenerale;
        double compt=0; // ce compteur va verifié si les deux moyenne sont réçu pour donner le droit aux calcule de la moyenne génerale
        
        @Override
        public void action(){
           ACLMessage msg = receive();
           if(msg!=null){ // une fois un message réçu (une moyenne), on affiche les informations associées
               /*ICI les instructions pour afficher : l'agent qui a envoyé la moyenne,la contenu envoyé et l'ontologie de msg*/
               //il est nécessaire de verifié avec if() si l'ontologie de message vaut moy1 ou moy2
               
               //if(/*ICI 2 conditions*/ ){
                   /*définition d'un double pour prendre la valeur réçu (conversion de la valeur récu en double est indisponsable)*/
                   //Incrémentation de someGlobale par la valeur de moye réçu
                   //incrémentation de compt par 1. En effet, nous ne pouvons pas calculé la moyenne générale si les deux notes ne sont pas réçus
                   if(compt==2){
                   /*ICI le calcule de la moyenne génerale et affichage de la mention selon la valeur*/
                   /*possibilité de génerer un pdf portant les détails du message réçu et la mention*/
                   compt=0;
                   moyGenerale=0;
                   someGlobale=0;
                   }
              // }
           }
           else
               block();
           }  
        });
       
     }    
}
