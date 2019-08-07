package org.fasttrackit;

import org.fasttrackit.persistance.ToDOItemRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class App {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {

        ToDOItemRepository toDoItemRepository = new ToDOItemRepository();
        toDoItemRepository.createToDoItem("Learn Java", LocalDateTime.now().plusMonths(6));


    }
}
