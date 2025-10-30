package book;

public class BookList {
    private Book[] books = new Book[10];
    private int usedSize;

    public BookList() {
       this.books[0] = new Book("三国演义","罗贯中",19,"武侠");
       this.books[1] = new Book("西游记","吴承恩",15,"神话");
       this.books[2] = new Book("红楼梦","曹雪芹",14,"小说");
       this.usedSize = 3;
    }


    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
    public Book[] getBooks() {
        return books;
    }
    public Book getBook(int pos) {
        return books[pos];
    }
    public void setBook(int pos,Book book) {
        books[pos] = book;
    }
}
