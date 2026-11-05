package day3;
import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your age:");
		int age=sc.nextInt();
		if(age>=18) {
			System.out.println("Eligible");
		
		}
		else {
			System.out.println("Not Eligible");
		}


	}

}
