package basic;

class Producer1 extends Thread{
	StringBuffer sb;
	Producer1(){
		sb=new StringBuffer();
	}
	public void run(){
		synchronized(sb){
		for(int i=1;i<=10;i++){
			try{
				sb.append("item "+i+"\n");//items are added into sb object
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		sb.notify();
		}
     	}
}
class Consumer1 extends Thread{
	Producer1 prod; //has-a relationship
	Consumer1(Producer1 prod){
		this.prod=prod;
	}
	public void run(){
synchronized(prod.sb)//wait till a notification is received from procedure
		{
		try{
			prod.sb.wait(); // wait till a notification is received from producer
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		System.out.print(prod.sb);
	}
	}
}

public class ThreadCommunication {

	public static void main(String[] args) {
		Producer1 obj1=new Producer1();
		Consumer1 obj2=new Consumer1(obj1);
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj2);
		t2.start();
		t1.start();


	}

}
