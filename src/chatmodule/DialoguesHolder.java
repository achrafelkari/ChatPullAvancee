package chatmodule;


/**
* chatmodule/DialoguesHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from chat.idl
* lundi 25 janvier 2016 00 h 25 CET
*/

public final class DialoguesHolder implements org.omg.CORBA.portable.Streamable
{
  public chatmodule.Dialog value[] = null;

  public DialoguesHolder ()
  {
  }

  public DialoguesHolder (chatmodule.Dialog[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = chatmodule.DialoguesHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    chatmodule.DialoguesHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return chatmodule.DialoguesHelper.type ();
  }

}
