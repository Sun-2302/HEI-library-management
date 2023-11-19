package org.example.repository;

import org.example.entity.Author;
import org.example.entity.Subscriber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriberCrudOperations implements CrudOperations<Subscriber>{
    private Connection connection;
    @Override
    public List<Subscriber> findAll(){
        List<Subscriber> subscriberList = new ArrayList<>();
        String sql = "SELECT * from subscriber";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                subscriberList.add(new Subscriber(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("reference"),
                        resultSet.getString("sex")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return subscriberList;
    }

    @Override
    public List<Subscriber> saveAll(List<Subscriber> toSave) {
        String sql = "INSERT INTO subscriber (id, name, reference, sex) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Subscriber subscriber : toSave) {
                statement.setString(1, subscriber.getId());
                statement.setString(2, subscriber.getName());
                statement.setString(3, subscriber.getReference());
                statement.setString(4, subscriber.getSex());

                statement.addBatch();
            }

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Subscriber save(Subscriber toSave) {
        String sql = "INSERT INTO subscriber(id,name,reference,sex) values(?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toSave.getId());
            statement.setString(2, toSave.getName());
            statement.setString(3, toSave.getReference());
            statement.setString(4, toSave.getSex());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  toSave;
    }

    @Override
    public Subscriber delete(Subscriber toDelete) {
        String sql = "DELETE from subscriber where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, toDelete.getId());

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return toDelete;
    }
}
