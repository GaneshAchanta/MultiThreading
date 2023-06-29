package basic;

public class RunTest implements Runnable {

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		//used to get the name of the current executed thread
		if(name.equals("FirstName")) {
			for(int i=1; i<=5; i++)
				System.out.println(i);
		}
		else {
			for(int i=6; i<=10; i++)
				System.out.println(i);
		}

	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunTest());
		t1.setName("FirstName");
		t1.start();
		
		Thread t2 = new Thread(new RunTest());
		t2.setName("SecondName");
		t2.start();

	}

}
