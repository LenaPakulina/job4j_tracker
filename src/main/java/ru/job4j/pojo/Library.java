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
        String cleanCode = "Clean code";
        Book[] books = new Book[4];
        books[0] = new Book(cleanCode, 1111);
        books[1] = new Book("Becoming", 2222);
        books[2] = new Book("C++", 3333);
        books[3] = new Book("Java", 4444);
        printBooks(books);
        Book zeroth = books[0];
        books[0] = books[3];
        books[3] = zeroth;
        printBooks(books);
        for (int i = 0; i < books.length; i++) {
            if (cleanCode.equals(books[i].getName())) {
                printBook(books[i]);
            }
        }
    }
}
