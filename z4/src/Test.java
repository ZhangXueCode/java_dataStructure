/*
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Data data = new Data(x, y);
            System.out.println(data.getX() + data.getY());
        }
    }

}

class Data {

    private int x;
    private int y;

    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

*/
//}
/*
public class Test {// 1
    private static int x = 100;// 2
    public static void main(String args[]) {// 3
        Test hsl = new Test ();// 4
        hsl.x++;// 5
        Test  hs2 = new Test ();// 6
        hs2.x++;// 7
        hsl = new Test ();// 8
        hsl.x++;// 9
        Test .x--;// 10
        System.out.println(" x=" + x);// 11
    }
}
*/
/*
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            Sub sub = new Sub(x, y, z);
            System.out.println(sub.calculate());
        }
    }

}

class Base {

    private int x;
    private int y;

    public Base(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

class Sub extends Base {

    private int z;

    public Sub(int x, int y, int z) {
        //write your code here
        super(x, y);
        this.z=z;
    }

    public int getZ() {
        return z;
    }

    public int calculate() {
        return super.getX() * super.getY() * this.getZ();
    }

}
*/
/*class Base {
    Base() {
        System.out.print("Base");
    }
}

public class Test extends Base {

    public static void main( String[] args ) {
        new Test();//1
        //调用父类无参的构造方法
        new Base();//2
    }
}*/
class X{
    Y y=new Y();//1
    public X(){//2
        System.out.print("X");
    }
}
class Y{
    public Y(){//3
        System.out.print("Y");
    }
}
public class Test extends X{
    Y y=new Y();//4
    public Test (){//5
        System.out.print("Z");
    }
    public static void main(String[] args) {
        new Test ();
    }
}
