package org.example;

import org.example.entity.User;
import org.example.repository.UserRepository;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        UserRepository userRepository = new UserRepository();

        User user1 = new User(null, "Milad", "Amery", null);
        User user2 = new User(null, "Ali", "Amery", null);
        User user3 = new User(null, "Mohamad Mehdi", "Mohamadi", null);

//        UserRepository.tableInit();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        var contact = userRepository.findById(2);
        System.out.println(contact);

        userRepository.deleteById(10);
    }
}