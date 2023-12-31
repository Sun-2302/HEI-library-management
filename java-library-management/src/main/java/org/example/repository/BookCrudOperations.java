package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class BookCrudOperations implements CrudOperations<Book>{
    private Connection connection;
    @Override
    public List<Book> findAll(){
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * from book";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                bookList.add(new Book(
                        (UUID) resultSet.getObject("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("page_number"),
                        resultSet.getInt("id_topic"),
                        resultSet.getString("release_date"),
                        resultSet.getBoolean("availability"),
                        (UUID) resultSet.getObject("id_author")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        String sql = "INSERT INTO book (id, name, page_number, id_topic, release_date, availability, id_author) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Book book : toSave) {
                statement.setObject(1, book.getId());
                statement.setString(2, book.getName());
                statement.setInt(3, book.getPageNumber());
                statement.setInt(4, book.getTopicId());
                statement.setDate(5, Date.valueOf(book.getReleaseDate()));
                statement.setBoolean(6, book.isAvailability());
                statement.setObject(7, book.getId_author());

                statement.addBatch();
            }

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Book save(Book toSave) {
        String sql = "INSERT INTO book(id,name,page_number,id_topic,release_date,availability,id_author) values(?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setObject(1, toSave.getId());
            statement.setString(2, toSave.getName());
            statement.setInt(3, toSave.getPageNumber());
            statement.setInt(4, toSave.getTopicId());
            statement.setDate(5, Date.valueOf(toSave.getReleaseDate()));
            statement.setBoolean(6, toSave.isAvailability());
            statement.setObject(7, toSave.getId_author());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  toSave;
    }

    @Override
    public Book delete(Book toDelete) {
        String sql = "DELETE from book where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setObject(1, toDelete.getId());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return toDelete;
    }
}
