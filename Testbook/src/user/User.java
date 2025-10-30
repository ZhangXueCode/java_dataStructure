package user;

import book.BookList;
import operation.IOperation;

public abstract class User {
    public String name;
    public IOperation[] iOperations;

    public abstract int menu();
    public User(String name) {
        this.name = name;
    }
    public void dowork(int choice, BookList bookList) {
        IOperation iOperation = iOperations[choice];
        iOperation.work(bookList);
    }
}
