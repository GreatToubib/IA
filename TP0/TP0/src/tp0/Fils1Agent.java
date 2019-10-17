 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp0;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;


/**
 *
 * @author margo
 */
public class Fils1Agent extends Agent {
    
    @Override 
    protected void setup(){
        System.out.println("Démarrage de l'agent Fils Num 1");
        
        //Comportement OneShot
        /*this.addBehaviour(new OneShotBehaviour(){
            @Override
            public void action(){
                System.out.println("Fils 1 : J'exécute un Comportement OneShot");
            }
        });*/
        //Comportement tick tack
        /*this.addBehaviour(new TickerBehaviour(this,1000){
            @Override
            public void onTick(){
                System.out.println("Fils 1 : Tick");
                System.out.println("Fils 1 : Tack");
            }
        });*/
        //Comportement Bonjour
        /*this.addBehaviour(new WakerBehaviour(this,10000) {
            @Override
            public void onWake(){
                System.out.println("Fils 1 : Bonjour");
            }
        });*/
        //Comportement cyclique
        /*this.addBehaviour(new CyclicBehaviour(){
            private int c=0;
            @Override
            public void action(){
                c++;
                System.out.println("c="+c);
            }
        });*/
        //Faire passer un message du Fils 1 au Fils 2
        this.addBehaviour(new WakerBehaviour(this,2000) {
            @Override
            public void onWake(){
                System.out.println("Fils 1 : Message envoyé");
                ACLMessage message = new ACLMessage(ACLMessage.INFORM);
                message.addReceiver(new AID("Fils2Agent",AID.ISLOCALNAME));
                message.setContent("Bonjour, je suis Fils 1");
                send(message);
            }
        });
        
        //Envoi et reception de message en parallèle
        ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
        addBehaviour(parallelBehaviour);
        parallelBehaviour.addSubBehaviour(new WakerBehaviour(this,5000){
            @Override
            public void onWake(){
                System.out.println("Fils 1 : Message envoyé");
                ACLMessage message = new ACLMessage(ACLMessage.INFORM);
                message.addReceiver(new AID("Fils2Agent",AID.ISLOCALNAME));
                message.setContent("Bonjour, je suis Fils 1");
                send(message);
            }
        }); 
    }
    @Override
    protected void takeDown(){
        try {
            DFService.deregister(this);
        }
        catch (FIPAException e) {
            e.printStackTrace();
        }
        System.out.println(getLocalName()+"; Fils 1 terminée");
    }
}