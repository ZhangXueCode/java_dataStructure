package operation;

import book.BookList;

import java.util.Scanner;

public class BorrowedBook implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借书！");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借的书：");
        String name = scanner.nextLine();
        int currenSize = bookList.getUsedSize();
        for (int i = 0; i < currenSize; i++) {
            if(bookList.getBook(i).getName().equals(name)) {
                if(!bookList.getBook(i).isborrowed()) {
                    System.out.println("书已被借");
                }else {
                    bookList.getBook(i).setIsborrowed(true);
                    System.out.println(bookList.getBook(i));
                    System.out.println("借成功");
                }
               return;
            }
        }
        System.out.println("没有你要借的书");

    }
}
