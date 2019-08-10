package org.fasttrackit;

import org.fasttrackit.persistance.ToDoItemRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class App {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        ToDoItemRepository toDoItemRepository = new ToDoItemRepository();
        toDoItemRepository.createToDoItem("Learn JDBC2", LocalDateTime.now().plusMonths(6));
        toDoItemRepository.getToDoItems();
        System.out.println(toDoItemRepository.getToDoItems());
    }
}
