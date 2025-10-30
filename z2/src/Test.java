import java.util.Random;
import java.util.Scanner;
//求最大公约数
/*public class Test {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
        int m=in.nextInt();
        int r=0;
      do {
          r=m/n;
          if(r==0) {
              System.out.println(n);
              break;
          }
          m=n;
          n=r;
        }while(r!=0);
    }
}*/
//二进制序列
   /* public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
        for(int i=0;i<32;i+=2) {
            int m=(n>>i)&1;
            System.out.print(m+" ");
        }
        System.out.println();
        for(int j=1;j<32;j+=2) {
            int m=(n>>j)&1;
            System.out.print(m+" ");
        }
    }
}*/

//模拟登陆
  /*  public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int ret = random.nextInt(100);
        int c=0;
        while (true) {
            System.out.println("请输入值：");
            int n = scanner.nextInt();
            if (n==ret) {
                System.out.println("登陆成功");
            } else {
                System.out.println("错误");
            }
            c++;
            if(c==3) {
                System.out.println("退出程序");
                break;
            }
        }
    }
}*/
//输出一个整数的每一位
  /*  public static void main(String[] args) {
          Scanner in=new Scanner(System.in);
          int n= in.nextInt();
          while(n!=0) {
              int a=n%10;
              System.out.println(a);
              n/=10;
          }
    }
}*/
//猜数字游戏
  /*  public static void main(String[] args) {
        Random random=new Random();
        Scanner scanner=new Scanner(System.in);
        int ret=random.nextInt(100);
        while(true) {
            System.out.println("请输入值：");
            int n=scanner.nextInt();
            if(n<ret) {
                System.out.println("小了");
            } else if (n>ret) {
                System.out.println("大了");
            }else {
                System.out.println("对了");
                break;

            }
        }
    }*/


//计算分数的值
   /* public static void main2(String[] args) {*/
       /* int i=0;
        double sum=0.0;
        for(i=2;i<=100;i+=2) {
            sum+=1.0/i;
        }
        int j=0;
        double n=0.0;
        for(j=1;j<100;j+=2) {
            n+=1.0/j;
        }
        System.out.println(sum+n);
    }*/

//数字9 出现的次数
    /*public static void main1(String[] args) {*/
       /* int i=0;
        int c=0;
        for(i=0;i<101;i++) {
            if(((i+1)%10==0)) {
                c++;
            }
        }
        System.out.println(c);*/
 //*   }
//}
