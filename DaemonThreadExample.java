package basic;

public class DaemonThreadExample extends Thread{
	public void run() {
		//checking weather the thread is daemon or not
		if(Thread.currentThread().isDaemon()) {
			System.out.println("Daemon Thread is executing");
		}
		else {
			System.out.println("User (normal) Thread is executing");
		}
	}

	public static void main(String[] args) {
		DaemonThreadExample dt = new DaemonThreadExample();
		DaemonThreadExample dt2 = new DaemonThreadExample();
		Thread t1 = new Thread(dt);
		Thread t2 = new Thread(dt2);
		//making user thread t1 to daemon
		t1.setDaemon(true);
		//starting the both threads
		t1.start();
		t2.start();

	}

}
