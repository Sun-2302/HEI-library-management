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



        //AuthorCrudOperations
        AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations(connection);
        Author author = new Author(UUID.fromString("8af32d1a-5c6d-40f1-9b84-83cdc471e1f5"),"Shakespeare","M");
        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author(UUID.fromString("d54f79fd-428f-4558-abdd-a035890b89fd"),"J.K.Rowling","F"));
        authorList.add(new Author(UUID.fromString("db2717ec-405e-40c9-9b21-174d76c07a55"),"Jon Lee Anderson","M"));

        //FindAll Authors
        System.out.println(authorCrudOperations.findAll());
        //Delete Authors
        System.out.println(authorCrudOperations.delete(author));
        //Save Authors
        System.out.println(authorCrudOperations.save(author));
        //SaveAll Authors
        System.out.println(authorCrudOperations.saveAll(authorList));



        //SubscriberCrudOperations
        SubscriberCrudOperations subscriberCrudOperations = new SubscriberCrudOperations(connection);
        Subscriber subscriber = new Subscriber(UUID.fromString("2cd37629-59cf-4ce7-9ee6-9e37c05b7f06"),"Lura","S-003","M");
        List<Subscriber> subscriberList = new ArrayList<>();
        subscriberList.add(new Subscriber(UUID.fromString("b28de7b9-d4d3-489f-8dd4-1c680fc7de84"),"Sun","S-004","M"));
        subscriberList.add(new Subscriber(UUID.fromString("014280be-12ef-4df1-8f71-e3ee9f97f75c"),"Amanda","S-005","F"));

        //FindAll Subscribers
        System.out.println(subscriberCrudOperations.findAll());
        //Delete Subscribers
        System.out.println(subscriberCrudOperations.delete(subscriber));
        //Save Subscribers
        System.out.println(subscriberCrudOperations.save(subscriber));
        //SaveAll Subscribers
        System.out.println(subscriberCrudOperations.saveAll(subscriberList));

    }
}