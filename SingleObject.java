package basic;

class Bank implements Runnable{
	int availableBalance=5000;
	int wantedBalance;
	Bank(int wantedBalance){									
		this.wantedBalance = wantedBalance;
		System.out.println("Available Balance = "+availableBalance);
	}
	public void run(){	
		synchronized(this) {
			if(availableBalance>=wantedBalance){
				String name=Thread.currentThread().getName();
				System.out.println(wantedBalance+" Given to "+name);
				try{
					Thread.sleep(1500);//time taken to update an account
					availableBalance=availableBalance-wantedBalance;
				}
				catch(InterruptedException ie){
					ie.printStackTrace();
				}
			}
			else
				System.out.println("Sorry, no Balance");
		}
	}
}
public class SingleObject {
	public static void main(String[] args) {
		Bank obj=new Bank(3000);
		Thread t1=new Thread(obj);
		Thread t2=new Thread(obj);
		t1.setName("Husband");
		t2.setName("Wife");
		t1.start();
		t2.start();
	}
}

