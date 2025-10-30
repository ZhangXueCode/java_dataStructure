import java.util.Arrays;

public class Test {
    //存在连续三个奇数的数组
   /* public static void main8(String[] args) {
        int[] arr = {2,6,4,1};
        for (int i = 0; i < arr.length-2; i++) {
            int f1=arr[i];
            int f2=arr[i+1];
            int f3=arr[i+2];
            if(f1%2!=0&&f2%2!=0&&f3%2!=0) {
                System.out.println("ture");
            }if(f1%2==0&&f2%2==0&&f3%2==0) {
                System.out.println("false");
            }
        }
    }*/
    //多数元素
  /*  public static void main(String[] args) {
        int[] array={3,3,2};
        System.out.println(find(array));
    }
    public static int find(int[] array) {
        Arrays.sort(array);
        return array[array.length/2];//次数超过一半的元素一定是一个有序数组的中间位
    }*/
    //只出现一次的数字
   /* public static void main6(String[] args) {
        int[] array={2,2,1};
        int a=0;
        for (int x:array) {
            a^=x;
        }
        System.out.println(a);
    }*/
    //两数之和
    /*public static void main5(String[] args) {
        int[] array={1,2,3,4,5};
        int target=8;
        int l=0;
        int r= array.length-1;
        for (int i = r; i >1; i--) {
            for (int j = 0; j < i; j++) {
                if(array[i]+array[j]==target) {
                    System.out.println(i+" "+j);
                    break;
                }
            }
        }

    }*/
    //冒泡排序
   /* public static void main4(String[] args) {
        int[] array={1,5,3,4,8,0};
        bubble_sort(array);

    }
    public static void bubble_sort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean flg=false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]) {
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                    flg=true;
                }
            }
            if(flg==false) {
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }*/
    //奇数位于偶数之前
   /* public static void main3(String[] args) {
        int[] array={1,2,3,4,5,6};
       swap(array);
    }
    public static void swap(int[] array) {
        int l=0;
        int r= array.length-1;
        while(l<r) {
           while(l<r&&array[l]%2!=0) {
               l++;
           }
           while (l<r&&array[r]%2==0) {
               r--;
           }
           if(l<r) {
               int t=array[l];
               array[l]=array[r];
               array[r]=t;
           }


        }
        System.out.println(Arrays.toString(array));
    }*/
    //求数组的平均值
   /* public static void main2(String[] args) {
            int[] array={1,2,3,4};
        System.out.println(vag(array));

    }
    public static double vag(int[] array) {
        int sum=0;
        for (int x:array) {
            sum+=x;
        }
        return (double)sum/ array.length;
    }
*/

    //改变原有数组元素的值
   /* public static void main2(String[] args) {
       int[] array=new int[]{1,2,3,4};
           transform(array);
    }
    public static void transform(int[] array) {
        array=new int[]{1,2,3,4};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * 2;
        }
        System.out.println(Arrays.toString(array));

    }*/
}
