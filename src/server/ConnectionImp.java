package server;
import java.util.ArrayList;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import chatmodule.Client;
import chatmodule.ConnectionHelper;
import chatmodule.ConnectionPOA;
import chatmodule.Dialog;
import chatmodule.Dialogue;
import chatmodule.DialogueHelper;
import chatmodule.Message;

public class ConnectionImp extends ConnectionPOA {

	public static ArrayList<DialogueImpl> dialogues= new ArrayList<DialogueImpl>(); // maintenant on se dispose d'une liste de dialogue! 
	ORB orb;
	
	
	public void setOrb(ORB o){
		orb = o;
	}

	
	@Override
	public Dialogue connect(String nickname) { //  cette fonction créée un dialogue et l'ajoute dans la liste des dialogue ! 
		Message[] messages = new Message[0];
	
		DialogueImpl dia = isExist(nickname);
		
		if(dia==null){
		Dialog dialog = new Dialog(new Client(nickname),messages);
		dia = new DialogueImpl(dialog);
		dialogues.add(dia); // on ajoute le dialogue dans le ArrayList !
		System.out.println("Le client " + nickname + " vient de se connecter");		
		}else{
			System.out.println("Le client " + nickname + " est déja connécté");		
		}
		
		Dialogue d = null;
		POA rootpoa;
		try {
			rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(dia);
			d = DialogueHelper.narrow(ref);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;
	}

	@Override
	public void disconnect(String nickname) { // chercher le client avec son nickName et le supprimer de la liste  !
	 String client= ""; 
		DialogueImpl dial = null;
		for(DialogueImpl d : dialogues){
			if(d.dialogue.client.nickName.equals(nickname)){
			 dial = d;				
			}	
		}
		
		if(dial!=null){
			dialogues.remove(dial);
			System.out.println("Déconnexion de : "+ nickname + " réussite."  );
		}else{
			System.out.println(" Ce client n'est pas connécté !  ");
		} 
		
	}
	
	public DialogueImpl isExist(String nickName){ // on test si le client existe  
		
		for(DialogueImpl d : dialogues){
			if(nickName.equals(d.dialogue.client.nickName))
				return d;
		}
		return null;
	}

	
}
