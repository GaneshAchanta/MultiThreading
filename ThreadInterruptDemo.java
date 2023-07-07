package basic;

class InThread extends Thread{
	public void run() {
		try {
			for(int i=0; i<5; i++) {
				System.out.println("I am Lazy Thread : "+i);
				Thread.sleep(2000);
			}
		}
		catch(InterruptedException e) {
			System.out.println("I got Interrupted");
		}
	}
}
public class ThreadInterruptDemo {

	public static void main(String[] args) {
		InThread i = new InThread();
		Thread t = new Thread(i);
		t.start();
		t.interrupt();
		System.out.println("End of main Thread");

	}

}
