package operation;

import book.BookList;

import java.util.Scanner;

public class ReturnBook implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要归还的书：");
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            if(bookList.getBook(i).getName().equals(name)) {
                if(!bookList.getBook(i).isborrowed()) {
                    System.out.println("此书未被借，不能归还");
                }else {
                    System.out.println("归还成功");
                    System.out.println(bookList.getBook(i));
                    bookList.getBook(i).setIsborrowed(false);
                }
                return;
            }
        }
        System.out.println("不存在此书");

    }
}
