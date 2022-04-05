package baithuchanh;


	import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.IOException;
	import java.net.ServerSocket;
	import java.net.Socket;

	public class Server {
	    public static void main(String []args) throws IOException
	    {
	        String so1,so2,so3;
	        int tong;
	   
	        ServerSocket server = new ServerSocket(1234);
	        System.out.println("Server is now already");
	       
	        Socket connectionSocket = server.accept();
	 
	        DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
	    
	        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
	    
	        so1 = inFromClient.readLine();
	        so2 = inFromClient.readLine();
	       
	        int a = Integer.parseInt(so1);
	        int b = Integer.parseInt(so2);
	     
	        tong = a + b;
	        
	        so3 = String.valueOf(tong);
	    
	        outToClient.writeBytes(so3+'\n');
	 
	        inFromClient.close();
	        
	        outToClient.close();
	       
	        server.close();
	    }

	}

