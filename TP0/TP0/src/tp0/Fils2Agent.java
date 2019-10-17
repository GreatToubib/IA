/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp0;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author margo
 */
public class Fils2Agent extends Agent {
@Override
    protected void setup(){
        System.out.println("Démarrage de l'agent Fils Num 2");
        //Reception du message de Fils 1:
        this.addBehaviour(new CyclicBehaviour(){
            @Override
            public void action(){
                ACLMessage msg = receive();
                if(msg!=null){
                    System.out.println("Message reçu : " + msg.getContent());
                }
            }
        });
        //Envoi et reception de message en parallèle
        
    }
    @Override
    protected void takeDown(){
        try {
            DFService.deregister(this);
        }
        catch (FIPAException e) {
            e.printStackTrace();
        }
        System.out.println(getLocalName()+"; Fils 2 terminée");
    }
}