package server;

import java.util.ArrayList;

import org.omg.CORBA.ORB;

import chatmodule.Client;
import chatmodule.Dialog;
import chatmodule.DialoguePOA;
import chatmodule.Message;

public class DialogueImpl extends  DialoguePOA{
    
	  
	  public  Dialog dialogue; // une classe dialogue ! 
 	  public  ArrayList<Message> messages = new ArrayList<Message>();	 // une liste de messages ! 
	
 	   public DialogueImpl(Dialog dialogue){
 		   this.dialogue = dialogue;
 	   }
 	   
	private ORB orb;
	public void setOrb(ORB o){
		orb = o;
	}
	
	@Override
	public Client[] getClients() {
		
		int nombreClient = ConnectionImp.dialogues.size();
		
		Client [] clients = new Client[nombreClient];
		int j=0;
		for(DialogueImpl d : ConnectionImp.dialogues){
			clients[j]= d.dialogue.client;
			j++;
		}
		return clients;
	
	}

	
	@Override
	public void sendMessage(String to, String message) { 
		    for(DialogueImpl d : ConnectionImp.dialogues){
				if(d.dialogue.client.nickName.equals(to)){
					Message messag = new Message(dialogue.client.nickName, to, message);
					d.messages.add(messag);
					System.out.println("Message Envoyée");
					break;
				 }
			   }		
    	}

	@Override
	public Message[] getMessages(String pseudo) {
		Message [] messages = new Message[2] ;
		int nombre=0; 
		ArrayList<Message> array = new ArrayList<Message>();
			if(isConnected(pseudo)){	    
		   for(DialogueImpl d : ConnectionImp.dialogues)
		    	if(d.dialogue.client.nickName.equals(pseudo)){
		    	array = d.messages;
		    	nombre = array.size();	 	 	
		    		System.out.println("Nombr : "+nombre);
		    	   messages = new Message[nombre];
		    	 int k=0;
		    	for(Message m : array){
		    		messages[k] = m;
		    		k++;
		    	}
		    	
		    	}
		}else
			System.out.println(" le Client " +pseudo + " n'est pas connécté" );
		
		return messages;
	} 


	public boolean isConnected(String pseudo){
		
		boolean isConnected  = false;
		
		 for(DialogueImpl d : ConnectionImp.dialogues){
			 if(d.dialogue.client.nickName.equals(pseudo))
				 isConnected = true;
		 }
		 System.out.println(isConnected);
		return isConnected;
	}

	@Override
	public Dialog dialogue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dialogue(Dialog newDialogue) {
		// TODO Auto-generated method stub
		
	}

	
}
