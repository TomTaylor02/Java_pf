package stqa.pf.sandbox;

public class HelloWorld {
    public static void main(String[] args) {
        hello("world");
        hello("Foma");
        hello("world");

        Square s = new Square(5);
        System.out.printf("Площадь квадрата со стороной " + s.l + " = " + area(s));

        Reсtangle r = new Reсtangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));

    }

    public static void hello(String somebody) {
        System.out.println("Hello," + somebody + "!");
    }


    public static double area(Square s) {
        return s.l * s.l;
    }

    public static double area(Reсtangle r) {
        return r.a * r.b;
    }

}