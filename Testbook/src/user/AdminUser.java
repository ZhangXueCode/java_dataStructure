package user;

import operation.*;

import java.util.Scanner;

public class AdminUser extends User{

    public AdminUser(String name) {
        super(name);
        this.iOperations = new IOperation[]{
                new ExitBook(),
                new FindBook(),
                new AddBook(),
                new DelBook(),
                new ShowBook()
        };
    }

    @Override
    public int menu() {
        System.out.println("*******************");
        System.out.println("欢迎"+this.name+"来到管理员图书系统");
        System.out.println("0.退出");
        System.out.println("1.查找图书");
        System.out.println("2.增加图书");
        System.out.println("3.删除图书");
        System.out.println("4.展示图书");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
