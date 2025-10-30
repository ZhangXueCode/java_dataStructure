package operation;

import book.BookList;

public class ShowBook implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("展示书");
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            System.out.println(bookList.getBook(i));
        }

    }
}
