package operation;

import book.BookList;

import java.util.Scanner;

public class DelBook implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的书名字：");
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        int index = -1;
        for (int i = 0; i < currentSize; i++) {
            if(bookList.getBook(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        if(index==-1) {
            System.out.println("没有你要删的书");
        }
        for (int i = index; i < currentSize-1; i++) {
            bookList.setBook(i,bookList.getBook(i+1));
        }
        bookList.setUsedSize(currentSize-1);
        bookList.setBook(currentSize-1,null);
        System.out.println("删除成功");

    }
}
