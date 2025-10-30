package user;

import operation.*;

import java.util.Scanner;

public class NormalUser extends User{

    public NormalUser(String name) {
        super(name);
        this.iOperations = new IOperation[]{
                new ExitBook(),
                new FindBook(),
                new BorrowedBook(),
                new ReturnBook()
        };
    }

    @Override

    public int menu() {
            System.out.println("*******************");
            System.out.println("欢迎"+this.name+"来到用户图书系统");
            System.out.println("0.退出");
            System.out.println("1.查找图书");
            System.out.println("3.借图书");
            System.out.println("4.归还图书");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            return choice;
    }

}
