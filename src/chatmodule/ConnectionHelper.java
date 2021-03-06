package chatmodule;


/**
* chatmodule/ConnectionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from chat.idl
* lundi 25 janvier 2016 00 h 25 CET
*/

abstract public class ConnectionHelper
{
  private static String  _id = "IDL:chatmodule/Connection:1.0";

  public static void insert (org.omg.CORBA.Any a, chatmodule.Connection that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static chatmodule.Connection extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (chatmodule.ConnectionHelper.id (), "Connection");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static chatmodule.Connection read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ConnectionStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, chatmodule.Connection value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static chatmodule.Connection narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof chatmodule.Connection)
      return (chatmodule.Connection)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      chatmodule._ConnectionStub stub = new chatmodule._ConnectionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static chatmodule.Connection unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof chatmodule.Connection)
      return (chatmodule.Connection)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      chatmodule._ConnectionStub stub = new chatmodule._ConnectionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
