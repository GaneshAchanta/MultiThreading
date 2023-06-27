package basic;

class BookTicket extends Thread{
	Object train , comp;
	
	BookTicket (Object train, Object comp){
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
class CancelTicket extends Thread{
	Object train , comp;

	public CancelTicket(Object train, Object comp) {
		super();
		this.train = train;
		this.comp = comp;
	}
	public void run() {
		synchronized(comp) {
			System.out.println("CancelTicket locked on Compartment");
			try {
				Thread.sleep(200);
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			System.out.println("CancelTicket now waiting to lock on Train");
			synchronized(train) {
				System.out.println("CancelTicket locked on train");
			}
		}
	}
}
public class DeadlockPro {

	public static void main(String[] args) {
		Object train = new Object();
		Object compartment = new Object();
		BookTicket obj1 = new BookTicket(train,compartment);
		CancelTicket obj2 = new CancelTicket(train,compartment);
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);
		t1.start();
		t2.start();

	}

}
