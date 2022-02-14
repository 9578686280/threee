import java.io.*;
import java.net.*;

public class ClientTest

{

 public static void main(String args [])
  {
   
  String welcome;
  String response; 
  Client client;
  BufferedReader reader;
  PrintWriter writer;
 client=new Client("localhost",8001);
  try

{
  
  reader=new BufferedReader(new InputStreamReader(client.in));
  writer=new PrintWriter(new OutputStreamWriter(client.out));
  welcome=reader.readLine();
  System.out.println("Server says:" +welcome+"");
  System.out.println("HELLO");
  writer.println("HELLO"); 
  writer.flush();
  response=reader.readLine();
  System.out.println("Server response:" +response+ "");
  System.out.println(" QUIT");
  writer.println(" QUIT");
  writer.flush();
}catch (IOException e)


  {
   System.out.println("IOException in client in client:in.readLine()");
  System.out.println(e);
  }
  try
  { 
  Thread.sleep(2000);
}catch(Exception ignored)
  {
}
}
}
 class Client
{ 
 public InputStream in;
 public OutputStream out;
private Socket client;
 public Client (String host,int port)

{ 
try
{ 
 client=new Socket (host,port);
System.out.println("ClientSovket:"+client);

out=client.getOutputStream();
in=client.getInputStream();
} catch(IOException e)
{
System.out.println("IOExce:"+e);
}
}
}





