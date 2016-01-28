package client1;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import chatmodule.Client;
import chatmodule.Connection;
import chatmodule.ConnectionHelper;
import chatmodule.Dialogue;
import chatmodule.Message;

public class Main {

	public static void main(String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
	
		// Create the ORB (or connect to it in our case)
					ORB orb = ORB.init(args,null);
					
					org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
					// load the corba Naming Servce 
					
					NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
					
					// get the Hello Object from the Naming service 
					
					Connection connexion = (Connection) ConnectionHelper.narrow(ncRef.resolve_str("ABC"));
					//Dialogue dialogue  = (Dialogue) DialogueHelper.narrow(ncRef.resolve_str("Dialog"));
					
					
				//	Dialogue dialogue = (Dialogue)
					
					// dump the message to console
				    Dialogue dialogue=  connexion.connect("Achraf");
				 	
				    dialogue.sendMessage("Moussa", "Le message1");
				 	dialogue.sendMessage("Moussa", "Le message2");

				 	 Message[] msg = dialogue.getMessages("Achraf");
				 	 Client[] clients = dialogue.getClients();

				 	System.out.println("NOmbre de client : " + clients.length);
				 	System.out.println("NOmbre de Message d'Achrraf : " + msg.length);
			     	//	connexion.disconnect("nn");
	}

}
