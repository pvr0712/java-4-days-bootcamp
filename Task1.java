package day3;
import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name:");
		String name=sc.nextLine();
		System.out.println("Enter your age:");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("Where are you studying?");
		String clg=sc.nextLine();
		System.out.printf("My name is %s\n",name);
		System.out.printf("I am %d years old\n",age);
		System.out.printf("I study at %s\n",clg);

	}

}

