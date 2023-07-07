package basic;

class JoinThread extends Thread{
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println("Laila Thread");
			try{
				Thread.sleep(2000);
			}
			catch (InterruptedException e){}
		}
	}
}

public class ThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException {
		JoinThread j=new JoinThread();
		Thread t=new Thread(j);
		t.start();
		t.join();	
		for(int i=0;i<5;i++)		{
			System.out.println("Majnu Thread");
		}


	}

}
