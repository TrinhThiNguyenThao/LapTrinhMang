package baithuchanh;

	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.IOException;
	import java.net.Socket;
	import java.net.UnknownHostException;

	public class Client {
	    public static void main(String []args) throws IOException
	    {
	        
	        String a,b,tong;	        
	        Socket ClientSocket = new Socket("Localhost", 1234);	      
	        System.out.println("Connected to server");	      
	        DataInputStream inFromUser = new DataInputStream(System.in);	   
	        DataInputStream inFromServer = new DataInputStream(ClientSocket.getInputStream());	      
	        DataOutputStream outToServer = new DataOutputStream(ClientSocket.getOutputStream());
	      
	        try{
	            System.out.println("Mời nhập a :");
	            a=inFromUser.readLine();
	            System.out.println("Mời nhập b :");
	             b=inFromUser.readLine();
	          
	             outToServer.writeBytes(a+'\n');
	            outToServer.writeBytes(b+'\n');
	        }catch(UnknownHostException e)
	        {
	            System.err.println("Server Not Found");
	            System.exit(1);
	        }catch(IOException e)
	        {
	            System.err.println("Cannot make a connection");
	            System.exit(1);
	        }
	        
	     
	        tong=inFromServer.readLine();	     
	        System.out.println("Tổng :"+tong);
	        outToServer.close();	        
	        inFromServer.close();	    
	        ClientSocket.close();
	    }

	}
	
