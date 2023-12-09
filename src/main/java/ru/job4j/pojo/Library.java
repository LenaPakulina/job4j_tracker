package ru.job4j.pojo;

public class Library {
    private static void printBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            printBook(books[i]);
        }
    }

    private static void printBook(Book book) {
        System.out.println("Book: " + book.getName()
                + ", pages:" + book.getPagesCount());
    }

    public static void main(String[] args) {
        Book[] books = new Book[4];
        for (int i = 0; i < 4; i++) {
            books[i] = new Book();
        }
        books[0].setName("Clean code");
        printBooks(books);
        Book zeroth = books[0];
        books[0] = books[3];
        books[3] = zeroth;
        printBooks(books);
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                printBook(books[i]);
            }
        }
    }
}
