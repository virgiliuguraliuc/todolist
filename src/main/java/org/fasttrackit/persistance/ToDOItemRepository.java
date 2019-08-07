package org.fasttrackit.persistance;

import org.fasttrackit.domain.ToDoItem;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDOItemRepository {
    public void createToDoItem(String description, LocalDateTime deadline) throws SQLException, IOException, ClassNotFoundException {
        String insertSql = "INSERT INTO to_do_item (description, deadline) VALUES (?, ?)";
        //try with resources
        try (Connection connection = DatabaseConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)
        ) {
            preparedStatement.setString(1, description);
            preparedStatement.setDate(2, java.sql.Date.valueOf(deadline.toLocalDate()));

            preparedStatement.executeUpdate();


        }

}

// problemele incep de aici

        public List <ToDoItem> get.ToDoItem (long id, long) throws SQLException, IOException, ClassNotFoundException {
            String query = "SELECT id, Description, deadline, done FROM to_do_list";

        try (
            Connection connection = DatabaseConfiguration.getConnection();
            Statement statement = connection.createStatement();

            ) {ResultSet resultSet = statement.executeQuery(query);

            List <ToDoItem> toDoItems = new ArrayList<>();

            while (resultSet.next()){
                ToDoItem item = new ToDoItem();
                item.setId((resultSet.getLong("id");
                item.setDescription(resultSet.getString("descripition"));
                item.setDeadline(resultSet.getDate(id,));


            }

            }

    }

    }



}

