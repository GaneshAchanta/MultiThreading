package basic;

class Multitasking implements Runnable{
	String str;
	public Multitasking(String str) {
		super();
		this.str = str;
	}
	@Override
	public void run() {
		for(int i=1;i<=10;i++){
			System.out.println(str+" : "+i);
			try{
				Thread.sleep(2000);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}		
	}	
}
public class Movie {
public static void main(String[] args) {
    Multitasking obj1=new Multitasking("Cut The Ticket");
    Multitasking obj2=new Multitasking("Show The Seat");
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj2);
		t1.start();
		t2.start();
	}
}

