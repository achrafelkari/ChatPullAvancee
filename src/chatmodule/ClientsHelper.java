package chatmodule;


/**
* chatmodule/ClientsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from chat.idl
* lundi 25 janvier 2016 00 h 25 CET
*/

abstract public class ClientsHelper
{
  private static String  _id = "IDL:chatmodule/Clients:1.0";

  public static void insert (org.omg.CORBA.Any a, chatmodule.Client[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static chatmodule.Client[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = chatmodule.ClientHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (chatmodule.ClientsHelper.id (), "Clients", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static chatmodule.Client[] read (org.omg.CORBA.portable.InputStream istream)
  {
    chatmodule.Client value[] = null;
    int _len0 = istream.read_long ();
    value = new chatmodule.Client[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = chatmodule.ClientHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, chatmodule.Client[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      chatmodule.ClientHelper.write (ostream, value[_i0]);
  }

}
