package testUnitaire;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import chatmodule.Connection;
import chatmodule.ConnectionHelper;
import chatmodule.Dialogue;
import chatmodule.DialogueHelper;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // je force un peu l'ordre des execution ! 
public class TestPullAvance {

	@Test // je test si on peux prendre d'un anuaire namespace des objet ! 
	public void t1estAnnuaire() {
		try{
			String[] arg = new String[0];
			ORB orb = ORB.init(arg,null);
			// Create the ORB (or connect to it in our case)
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			// load the corba Naming Servce 
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			// get the Hello Object from the Naming service 
			Connection connexion = (Connection) ConnectionHelper.narrow(ncRef.resolve_str("ABC"));
			assertNotNull(connexion);
			}catch(Exception e){
				System.out.println("Erreur !");
				e.getStackTrace();
			}
	}
	
	@Test
	public void t2estEnvoiMessage(){
		try{
			String[] args = new String[0];
		
		ORB orb = ORB.init(args,null);
		org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
		NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
		Connection connexion = (Connection) ConnectionHelper.narrow(ncRef.resolve_str("ABC"));
     	Dialogue dialogueTITI=  connexion.connect("TITI");
		Dialogue dialogueAchraf = connexion.connect("Achraf");
		
		int nombreMessageAchraf1 = dialogueAchraf.getMessages("Achraf").length;
		dialogueTITI.sendMessage("Achraf", "Hey Achraf, je suis TITI");
		dialogueTITI.sendMessage("Achraf", "Hey Achraf, c'est mon autre message, check le premier message ! ");
		int nombreMessageAchraf2 = dialogueAchraf.getMessages("Achraf").length;
		
		System.out.println("Le n1 = " + nombreMessageAchraf1 + " , n2= " + nombreMessageAchraf2);
		
		assertTrue(nombreMessageAchraf2>nombreMessageAchraf1);
		
		}catch(Exception e){
			System.out.println("Erreur !");
			e.getStackTrace();
		}
	}
}
