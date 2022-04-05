package Server;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.attribute.DosFileAttributes;

public class PTServer {

	public static void main(String[] args) throws IOException{
		
			try{// Mở cổng và bắt đầu nghe
			ServerSocket socketServer = new ServerSocket(8989);
			System.out.println("I'm listening on 8989 port....");
			
			
			// Luôn luôn lắng nghe
			while (true)
			{	
				Socket socketClient= socketServer.accept();  
				
				DataInputStream dis = new DataInputStream(socketClient.getInputStream());
				DataOutputStream dos = new DataOutputStream(socketClient.getOutputStream());//
				System.out.print("Client:"+socketClient.getInetAddress().getHostAddress().toString());
				//Lấy về luồng xuất, nhập
				OutputStream osToClient = socketClient.getOutputStream();
				OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
				BufferedWriter buffWrite  = new BufferedWriter(write2Client);
				   
				InputStream in = socketClient.getInputStream();
				InputStreamReader inReader = new InputStreamReader(in);
				BufferedReader buffRead = new BufferedReader(inReader);
				//========= GIAO TIẾP THEO giao thức thiết kế=============    
				 
				//-----------------------
				String chuoiHello_Gui="Hello";
				buffWrite.write(chuoiHello_Gui+ "\n");
				buffWrite.flush();
				
				//
			    String chuoiXinchao_Nhan = buffRead.readLine();
			    String chuoiNhapA="Mời nhập a ? \n";
			    buffWrite.write(chuoiNhapA+ "\n");
			    buffWrite.flush();
					//
			    
			    String chuoiNhapB="Mời nhập b? ";
			    buffWrite.write(chuoiNhapB+ "\n");
			    buffWrite.flush();	
				//
			    String chuoiNhap="Mời nhập phép toán ? \n";
			    buffWrite.write(chuoiNhap+ "\n");
			    buffWrite.flush();
			
			   //
				String[] lenh = dis.readUTF(). split (" ");
			    float x ;
			    float y ;
			    float z;
			    String kq = "";
			    		
			    
			    x = Integer.parseInt(lenh[0]);
			     y = Integer.parseInt(lenh[2]);
			     
			  
			    	
			    	switch (lenh[1]){
			    		case "+" :	
							z = x + y ;
			    			break;
			    		case"-":
			    			 z =x - y ;
			    			break;
			    			
			    		case"*":
			    			 z =x * y ;
			    			break;
			    			
			    		case "/":
			    			if (y==0)
			    			{
			    				System.out.println("Loi");
			    			}
			    			{
			    			 z =x / y ;
			    			}
			    			break;
			    			
			    			default:
			    				break;
			    	} 
			    	
			    
	    socketClient.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
