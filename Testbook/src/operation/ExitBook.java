package operation;

import book.BookList;

public class ExitBook implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("推出系统！");
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            bookList.setBook(i,null);
        }
        bookList.setUsedSize(0);
        System.exit(0);
    }
}
