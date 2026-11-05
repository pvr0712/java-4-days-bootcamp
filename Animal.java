package day3;

class Animal {
 String name;
 int age;

 public Animal(String name, int age) {
     this.name = name;
     this.age = age;
 }

 public void eat() {
     System.out.println(name + " is eating");
 }

 public void sleep() {
     System.out.println(name + " is sleeping");
 }
}

class Dog extends Animal {
 public Dog(String name, int age) {
     super(name, age);
 }

 public void bark() {
     System.out.println(name + " says Woof");
 }
}

class Cat extends Animal {
 public Cat(String name, int age) {
     super(name, age);
 }

 public void meow() {
     System.out.println(name + " says Meow");
 }
}

 class MainAnimal {
	 
 public static void main(String[] args) {
     Dog dog = new Dog("Jamie", 3);
     Cat cat = new Cat("Whiskers", 2);

   
     dog.eat();   
     dog.sleep();   
     dog.bark();    

    
     cat.eat();     
     cat.sleep();   
     cat.meow();   
 }
}
