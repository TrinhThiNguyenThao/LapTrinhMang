package Client;



import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class PTClient {
  public static void main(String[] args) {
      Socket soc;
      try {
        soc = new Socket("localhost", 8989); //gửi yêu cầu 
        System.out.print("Connected!\n");
        // Lấy luồng nhập, xuất 
        InputStream in = soc.getInputStream();
        InputStreamReader inReader = new InputStreamReader( in );
        BufferedReader buffRead = new BufferedReader(inReader);

        OutputStream osToClient = soc.getOutputStream();
        OutputStreamWriter write2Client = new OutputStreamWriter(osToClient);
        BufferedWriter buffWrite = new BufferedWriter(write2Client);
        
        // Lấy chuỗi nhập từ bàn phím 
        Scanner banPhim = new Scanner(System.in);
        
        // GIAO TIẾP THEO giao thức thiết kế ======
        
        //Nhận về từ server và in ra
		 while(true)
		 {
			 
			 String chuoiHello_Gui = banPhim.nextLine();
				buffWrite.write(chuoiHello_Gui+ "\n");
				buffWrite.flush();
				
				//
			  
			    String chuoiNhapA = banPhim.nextLine();
			    buffWrite.write(chuoiNhapA+ "\n");
			    buffWrite.flush();
					//
			    
			    String chuoiNhapB = banPhim.nextLine();
			    buffWrite.write(chuoiNhapB+ "\n");
			    buffWrite.flush();	
				//
			    String chuoiNhap = banPhim.nextLine();
			    buffWrite.write(chuoiNhap+ "\n");
			    buffWrite.flush();
			
		 }
		 
	}catch (Exception e) {
		e.printStackTrace();
	}
  }
}
 
