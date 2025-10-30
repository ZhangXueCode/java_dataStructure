package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddBook implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("增加图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要添加的的书名：");
        String name = scanner.nextLine();

        System.out.println("请输入作者名：");
        String author = scanner.nextLine();

        System.out.println("请输入价格：");
        int price = scanner.nextInt();
        scanner.nextLine();

        System.out.println("请输入类型：");
        String type = scanner.nextLine();

        Book book = new Book(name,author,price,type);
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            if(bookList.getBook(i).getName().equals(name)) {
                System.out.println("已有这本书，不可再添加");
                return;
            }
        }
        bookList.setBook(currentSize,book);
        bookList.setUsedSize(currentSize+1);


    }
}
