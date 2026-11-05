package day3;

abstract class Shape {
 abstract double calculateArea();
}

class Circle extends Shape {
 double radius;

 public Circle(double radius) {
     this.radius = radius;
 }

 double calculateArea() {
     return Math.PI * radius * radius;
 }
}

class Rectangle extends Shape {
 double length;
 double width;

 public Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 double calculateArea() {
     return length * width;
 }
}

class Triangle extends Shape {
 double base;
 double height;

 public Triangle(double base, double height) {
     this.base = base;
     this.height = height;
 }

 double calculateArea() {
     return 0.5 * base * height;
 }
}

 class MainShape {
 public static void main(String[] args) {
     Shape circle = new Circle(5.0);
     Shape rectangle = new Rectangle(4.0, 6.0);
     Shape triangle = new Triangle(3.0, 8.0);

     System.out.printf("Circle Area    : %.2f\n", circle.calculateArea());
     System.out.printf("Rectangle Area : %.2f\n", rectangle.calculateArea());
     System.out.printf("Triangle Area  : %.2f\n", triangle.calculateArea());
 }
}