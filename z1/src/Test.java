public class Test {
    public static void main(String[] args) {
        /*int ret = compare(2,3,4);
        System.out.println(ret);*/
        /*int ret = sum(5);
        System.out.println( ret);*/
//        System.out.println(add(5));
//        System.out.println(fib(4));
//        System.out.println(sum(2,3));
//        System.out.println(sum(2.3,2.4));
        /*System.out.println(compare(2,3));
        System.out.println(compare(2.3,3.5,7.7));*/
//        System.out.println(sum(5));
       han(3,'A','B','C');
    }
    //递归求解汉诺塔问题
    public static void move(char pos1,char pos2) {
        System.out.print(pos1+"-->"+pos2+" ");
    }
    public static void han(int n,char pos1,char pos2,char pos3) {
        if(n==1) {
            move(pos1,pos3);
        }else {
            han(n-1,pos1,pos3,pos2);
            move(pos1,pos3);
            han(n-1,pos2,pos1,pos3);
        }
    }
//递归求 N 的阶乘
  /*  public static int sum(int n) {
        if(n==1) {
            return 1;
        }else {
            return n*sum(n-1);
        }
    }*/
    //求最大值方法的重载
  /*  public static double compare(double  a,double  b) {
        if(a>b) {
            return a;
        }else {
            return b;
        }
    }
    public static double  compare(double  a,double  b,double  c) {
        double e = compare(2.3, 3.5);
        if (c > e) {
            return c;
        } else {
            return e;
        }
    }
    public static int compare(int a,int b) {
        if(a>b) {
            return a;
        }else {
            return b;
        }
    }*/
    //求和的重载
   /* public static int sum(int a,int b) {
        return a+b;
    }
    public static double sum(double a,double b) {
        return a+b;
    }*/
    //斐波那契数列
   /* public static int fib(int n) {
        if(n==1) {
            return 0;
        } else if(n==2||n==3) {
            return 1;
        }else {
            int f1 = 1;
            int f2 = 1;
            int f3 = 0;
            for (int i = 0; i <n-3 ; i++) {
                f3=f1+f2;
                f1=f2;
                f2=f3;
            }
            return f3;
        }

    }*/
    //求阶乘和
  /*  public static int sum(int n) {
        int m = 1;
        for (int i = 1; i <= n; i++) {
            m *= i;
        }
        return m;
    }
    public static int add(int a) {
        int sum=0;
        for (int i = 1; i <= a; i++) {
            sum+=sum(i);
        }
        return sum;
    }
*/

//求 N 的阶乘
   /* public static int sum(int n) {
        int m=1;
        for (int i = 1; i <= n; i++) {
            m*=i;
        }
        return m;
    }*/


    //使用函数求最大值
  /*  public static int compare(int a,int b) {
        if(a>b) {
            return a;
        }else {
            return b;
        }
    }
    public static int compare(int a,int b,int c) {
        int e = compare(2,3);
        if(c>e) {
            return c;
        }else {
            return e;
        }
    }*/
}
