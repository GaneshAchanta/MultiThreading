package basic;

public class ThreadTest extends Thread {
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadTest());
		t1.start();
		Thread t2 = new Thread(new ThreadTest());
		t2.start();

	}

}
