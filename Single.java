package basic;
import java.util.*;

public class Single implements Runnable {
	@Override
	public void run() {
		task1();
		task2();
		task3();
		
	}
	public void task1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number :");
		int fno = sc.nextInt();
		System.out.println("Enter the second number :");
		int sno = sc.nextInt();
		int sum = fno + sno;
		System.out.println("Sum = "+sum);
	}
	
	public void task2() {
		int[]arr = {3,6,9,12,15,18};
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum = sum + arr[i];
		}
		System.out.println("Sum of array elements are : "+sum);
	}
	public void task3() {
		for(int i=1;i<=5; i++)
			System.out.println("Hello");
	}

	public static void main(String[] args) {
		Single s = new Single();
		Thread t = new Thread(s);
		t.start();

	}

}
