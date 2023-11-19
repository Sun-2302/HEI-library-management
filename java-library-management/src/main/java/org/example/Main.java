package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Subscriber;
import org.example.repository.AuthorCrudOperations;
import org.example.repository.BookCrudOperations;
import org.example.repository.SubscriberCrudOperations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        //BookCrudOperations
        BookCrudOperations bookCrudOperations = new BookCrudOperations(connection);
        Book book = new Book(UUID.fromString("eb1f284a-da97-4d4d-881f-8e78d729f041"),"Une brève histoire du temps",236,3, "1988-03-10",true,UUID.fromString("aa13ec63-ce74-4de3-bc32-636c4bce1cb1"));
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(UUID.fromString("422676ba-367b-4c42-a07f-8874d0f02a6b"),"Georges et le Big Bang",320,3,"2011-08-06",true,UUID.fromString("aa13ec63-ce74-4de3-bc32-636c4bce1cb1")));
        bookList.add(new Book(UUID.fromString("d9dcc875-ad83-4c4c-adf2-6dd75718b6a4"),"Heartstopper - tome 2",310,2,"2020-10-03",true,UUID.fromString("51b87b57-5a86-46a6-ab26-4844dec1bfbe")));

        //FindAll Books
        System.out.println(bookCrudOperations.findAll());
        //Delete Books
        System.out.println(bookCrudOperations.delete(book));
        //Save Books
        System.out.println(bookCrudOperations.save(book));
        //SaveAll Books
        System.out.println(bookCrudOperations.saveAll(bookList));




    }
}