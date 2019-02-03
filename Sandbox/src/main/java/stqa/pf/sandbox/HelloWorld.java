package stqa.pf.sandbox;

public class HelloWorld {
    public static void main(String[] args) {
        hello("world");
        hello("Foma");
        hello("world");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Reсtangle r = new Reсtangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    }

    public static void hello(String somebody) {
        System.out.println("Hello," + somebody + "!");
    }




}