package ntu.edu;

public class LuongB extends Thread {
	public void run() {
		for (int i=1; i<100; i+=2)
			System.out.println("B"+i);
		
	}

}
