package BMIClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class BMIClient {

	private static final BufferedReader BuffRead = null;

	public static void main(String[] args) {
		Socket soc;
		try {
			soc = new Socket("localhost", 8989);
			System.out.println("Connected! \n");
				// lấy luồng nhập xuất
			InputStream in = soc.getInputStream();
			InputStreamReader inReader = new InputStreamReader(in);
			BufferedReader buffRead = new BufferedReader(inReader);
			OutputStream osToClient = soc.getOutputStream();
			
			OutputStream osToClient1 = null;
			OutputStreamWriter write2Client = new OutputStreamWriter(osToClient1);
			
			BufferedWriter buffWrite = new BufferedWriter(write2Client);
			 	//--- GIAO TIẾP THEO giao thức thiết kế  ===========
			 
			 	//--- lấy luồng  nhập từ bàn phím
			Scanner banPhim = new Scanner(System.in);
			 	//--- GIAO TIẾP THEO giao thức thiết kế  ===========
			String chuoiHello_Nhan = BuffRead.readLine();
				//--- in ra để coi
			System.out.print("BMI server :" + chuoiHello_Nhan); // gửi ra màn hình k gửi ra server
				//--- bây h gửi " xin chào "
			String chuoiXinChao_Gui = "Xin Chào";    // gửi lên server
			buffWrite.write(chuoiXinChao_Gui + "\n");
			buffWrite.flush();
			
				// ********** nhận hỏi tên
				//---------- xong 1 đoạn hội thoại
			
			String chuoiHoiTen_Nhan = buffRead.readLine();
				//--- in ra để xem
			System.out.print("BMI server :" + chuoiHoiTen_Nhan);  
			
				//--- trả lời cho Server
				//--- muốn trả về đc thì phải lấy dl từ bàn phím gửi cho server 
				//--- bào user đưa tên từ bàn phím 
			
			System.out.print("BMI client : (nhập tên bạn) :" );
			String chuoiTraloiTen_Gui = banPhim.nextLine();
				//--- gửi đến server
					
			buffWrite.write(chuoiTraloiTen_Gui );
			buffWrite.flush();
			
				//-----------------------
				//----------nhận hỏi chiều cao
			
			String chuoiHoiChieuCao_Nhan = buffRead.readLine();
			    // in ra để xem
			System.out.print("BMI server :" + chuoiHoiChieuCao_Nhan);  
			
			     // trả lời cho Server
				 //  muốn trả về đc thì phải lấy dl từ bàn phím gửi cho server 
				 // bào user đưa tên từ bàn phím 
			
			System.out.print("BMI client : (nhập chiều cao (cm) :" );
						String chuoiTraloiChieuCao_Gui = banPhim.nextLine();
				 // gửi đến server
						
			buffWrite.write(chuoiTraloiChieuCao_Gui );
			buffWrite.flush();
			
				 //-----------------------
				 // nhận hỏi cân nặng
				 //----------xong 1 đoạn hội thoại
			
		     String chuoiHoiCanNang_Nhan = buffRead.readLine();
				 // in ra để xem
			 System.out.print("BMI server :" + chuoiHoiCanNang_Nhan);  
			 
				 // trả lời cho Server
				 //  muốn trả về đc thì phải lấy dl từ bàn phím gửi cho server 
				 // bào user đưa tên từ bàn phím 
			 System.out.print("BMI client : (nhập cân nặng của bạn là (kg) :" );
			 String chuoiTraloiCanNang_Gui = banPhim.nextLine();
			 
				 // gửi đến server
								
			 buffWrite.write(chuoiTraloiCanNang_Gui );
			 buffWrite.flush();
			 
				 //======================================
				 // 2 lệnh nhận và in ra màn hình
				 // nhận 1 : thông tin đang tính
			 
			 String chuoiDangTinh_Nhan = buffRead.readLine();
				 // in ra màn hình user xem
			 System.out.println("BMI server :" + chuoiDangTinh_Nhan);
				 // nhận 2 : thông tin kết quả béo phì
			 String chuoiDangTinh_Nhan1 = buffRead.readLine();
			 System.out.println("BMI server :" + chuoiDangTinh_Nhan1);	   		 
			     //soc.close();
	        }catch (Exception e) {
		     e.printStackTrace();
		}
	}
}