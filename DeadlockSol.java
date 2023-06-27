package basic;

class BookTicket2 extends Thread{
	Object train , comp;
	
	BookTicket2 (Object train, Object comp){
		this.train = train;
		this.comp = comp;
	}
	public void run() {
		synchronized(train) {
			System.out.println("BookTicket locked on Train");
			try {
				Thread.sleep(200);
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			System.out.println("BookTicket now waiting to lock on Compartment");
			synchronized(comp) {
				System.out.println("BookTicket locked on Compartment");
			}
		}
	}
}
class CancelTicket2 extends Thread{
	Object train , comp;

	public CancelTicket2 (Object train, Object comp) {
		super();
		this.train = train;
		this.comp = comp;
	}
	public void run() {
		synchronized(train) {
			System.out.println("CancelTicket locked on Compartment");
			try {
				Thread.sleep(200);
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			System.out.println("CancelTicket now waiting to lock on Train");
			synchronized(comp) {
				System.out.println("CancelTicket locked on train");
			}
		}
	}
}
public class DeadlockSol {

	public static void main(String[] args) {
		Object train = new Object();
		Object compartment = new Object();
		BookTicket2 obj1 = new BookTicket2(train,compartment);
		CancelTicket2 obj2 = new CancelTicket2(train,compartment);
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		t1.start();
		t2.start();

	}

}
