package chatmodule;


/**
* chatmodule/ConnectionOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from chat.idl
* lundi 25 janvier 2016 00 h 25 CET
*/

public interface ConnectionOperations 
{
  chatmodule.Dialogue connect (String nickname);
  void disconnect (String nickname);
} // interface ConnectionOperations
