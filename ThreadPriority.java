/*This program execution not decided by the thread priorities . Because to read the thread priorities,
 Thread scheduler program is required. But in JVM that program is not implemented.*/

package basic;

class X extends Thread {
	public void run() {
		System.out.println("Thread X Started");
		for(int i=0; i<5; i++) {
			System.out.println("\t value of i in Thread X : "+i);
		}
		System.out.println("Thread X Finished");
	}
}
class Y extends Thread {
	public void run() {
		System.out.println("Thread Y Started");
		for(int i=0; i<5; i++) {
			System.out.println("\t value of i in Thread Y : "+i);
		}
		System.out.println("Thread Y Finished");
	}
}
class Z extends Thread {
	public void run() {
		System.out.println("Thread Z Started");
		for(int i=0; i<5; i++) {
			System.out.println("\t value of i in Thread Z : "+i);
		}
		System.out.println("Thread Z Finished");
	}
}
public class ThreadPriority {

	public static void main(String[] args) {
		X ThreadX = new X();
		Y ThreadY = new Y();
		Z ThreadZ = new Z();
		
		ThreadZ.setPriority(Thread.MAX_PRIORITY);
		ThreadY.setPriority(ThreadX.getPriority());
		ThreadZ.setPriority(Thread.MIN_PRIORITY);
		
		Thread t1 = new Thread(ThreadX);
		Thread t2 = new Thread(ThreadY);
		Thread t3 = new Thread(ThreadZ);
		
		t1.start();
		t2.start();
		t3.start();

	}

}
