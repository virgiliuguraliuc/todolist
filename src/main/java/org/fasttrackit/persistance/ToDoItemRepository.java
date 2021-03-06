package org.fasttrackit.persistance;

import org.fasttrackit.domain.ToDoItem;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ToDoItemRepository {
    public void createToDoItem(String description, LocalDateTime deadline) throws SQLException, IOException, ClassNotFoundException {
        String insertSql = "INSERT INTO to_do_list (description, deadline) VALUES (?, ?)";
        //try with resources
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)
        ) {
            preparedStatement.setString(1, description);
            preparedStatement.setDate(2, java.sql.Date.valueOf(deadline.toLocalDate()));

            preparedStatement.executeUpdate();


        }

}

    public List<ToDoItem> getToDoItems () throws SQLException, IOException, ClassNotFoundException {
       String query ="SELECT id, description, deadline, done FROM  to_do_list";

       try (Connection connection = DatabaseConfiguration.getConnection();
            Statement statement = connection.createStatement()

       ) {

           ResultSet resultSet = statement.executeQuery(query);
           List<ToDoItem> toDoItems = new ArrayList<>();

          while (resultSet.next()) {
              ToDoItem item = new ToDoItem();
             item.setId(resultSet.getLong("id"));
             item.setDescription(resultSet.getString("description"));
             item.setDeadline(resultSet.getDate("deadline").toLocalDate().atStartOfDay());
             item.setDone(resultSet.getBoolean("done"));

             toDoItems.add(item);
          }

          return toDoItems;

       }
    }

    public void deleteToDOItem(long id) throws SQLException, IOException, ClassNotFoundException {
    String sql ="DELETE FROM to_do_list WHERE id = ?";


        try (Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        }
    }

    public void updateToDoItem(long id, boolean done) throws SQLException, IOException, ClassNotFoundException {
        String upd ="UPDATE to_do_list SET done = ? WHERE id = ?";


        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(upd)
        ){
            preparedStatement.setBoolean(1, done);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();

        }
    }

}

