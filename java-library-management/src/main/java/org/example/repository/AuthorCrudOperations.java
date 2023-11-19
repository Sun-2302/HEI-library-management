package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.entity.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class AuthorCrudOperations implements CrudOperations<Author>{
    private Connection connection;
    @Override
    public List<Author> findAll(){
        List<Author> authorList = new ArrayList<>();
        String sql = "SELECT * from author";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                authorList.add(new Author(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("sex")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return authorList;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        String sql = "INSERT INTO author (id, name, sex) " +
                "VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Author author : toSave) {
                statement.setString(1, author.getId());
                statement.setString(2, author.getName());
                statement.setString(3, author.getSex());

                statement.addBatch();
            }

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Author save(Author toSave) {
        String sql = "INSERT INTO author(id,name,sex) values(?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toSave.getId());
            statement.setString(2, toSave.getName());
            statement.setString(3, toSave.getSex());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  toSave;
    }

    @Override
    public Author delete(Author toDelete) {
        String sql = "DELETE from author where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toDelete.getId());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return toDelete;
    }
}
