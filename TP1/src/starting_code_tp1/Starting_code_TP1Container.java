/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starting_code_tp1;

import jade.wrapper.AgentContainer;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Ir. M. El Adoui
 */
public class Starting_code_TP1Container {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //crée l'instance de Runtime
        Runtime runtime = Runtime.instance();
        //Définir la propriété du conteneur
        Properties properties = new ExtendedProperties();
        //Afficher l'interface de JADE 
        properties.setProperty(Profile.GUI, "true");
        ProfileImpl profileImpl =new ProfileImpl(properties);
        //Créé l'agent principal
        AgentContainer agentContainer1 = runtime.createMainContainer(profileImpl);       
        try {
            //Démmarer l'agent principal
            agentContainer1.start();
        } catch (ControllerException ex) {  
            Logger.getLogger(Starting_code_TP1Container.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
      /*
        try {
        
            // Crée le profil d'un nouveau conteneur personnel appelé 'Administrateur' en local
            // Crée le profil d'un nouveau conteneur personnel appelé 'Professeur' en local
   
               //ICI
            
            
            //crée un 1er agent Prof1 appartenant au conteneur 'Professeur' 
           
            
            //crée un 2eme agent prof2 appartenant au conteneur 'Professeur' 
      
           
            //crée un 1er agent admin1 appartenant au conteneur 'Administration' 
    
            
           //crée un 2eme agent admin2 appartenant au conteneur 'Administration' 

            
        } catch (Exception ex) {
               ex.printStackTrace();
    
    }*/
    
}

}