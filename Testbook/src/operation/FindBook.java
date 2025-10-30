package operation;

import book.BookList;

import java.util.Scanner;

public class FindBook implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的书：");
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            if(bookList.getBook(i).getName().equals(name)) {
                System.out.println(bookList.getBook(i));
                System.out.println("查找成功");
                return;
            }
        }
        System.out.println("没有你要查找的书");

    }
}
