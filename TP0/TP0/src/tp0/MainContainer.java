/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp0;

import jade.wrapper.AgentContainer; 
import jade.wrapper.ControllerException;
import jade.core.Profile; 
import java.util.logging.Level;
import jade.core.ProfileImpl; 
import java.util.logging.Logger;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentController;
/**
 *
 * @author margo
 */
public class MainContainer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Créer l'instance de Runtime
        Runtime runtime = Runtime.instance();
        //Définir la propriété du container
        Properties properties = new ExtendedProperties();
        //Afficher l'interface de JADE
        properties.setProperty(Profile.GUI,"true");
        ProfileImpl profileImpl = new ProfileImpl(properties);
        //Créer l'agent principal
        AgentContainer agentContainer1 = runtime.createMainContainer(profileImpl);
        
        try {
            //Démarrer l'agent principal
            agentContainer1.start();
        } catch (ControllerException ex) {
            Logger.getLogger(MainContainer.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        
        
        //Création d'un container personnel
        try {
            //Créer le profil d'un nouveau container personnel appelé 'Fils' en local
            ProfileImpl profileImpl2 = new ProfileImpl();
            profileImpl2.setParameter(ProfileImpl.CONTAINER_NAME, "Fils");
            profileImpl2.setParameter(ProfileImpl.MAIN_HOST, "localhost");
            //Créer le nouveau container 'Fils'
            AgentContainer agentContainer2 = runtime.createAgentContainer(profileImpl2);
            //Créer un 1er agent appartenant au container 'Fils'
            
            AgentController agentController1 = agentContainer2.createNewAgent("Fils1Agent", Fils1Agent.class.getName(), new Object[]{});
            agentController1.start();
            //Créer un 2er agent appartenant au container 'Fils'
            AgentController agentController2 = agentContainer2.createNewAgent("Fils2Agent", Fils2Agent.class.getName(), new Object[]{});
            agentController2.start();
        }
        catch (ControllerException ex){
            ex.printStackTrace();
        }
        
        
        
        
    }
    
}