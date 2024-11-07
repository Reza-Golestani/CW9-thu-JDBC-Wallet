package org.example.repository;

import org.example.Datasource;
import org.example.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private static final String CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS users (
            id bigserial PRIMARY KEY NOT NULL,
            username varchar(50) NOT NULL,
            password varchar(50) NOT NULL
            );
            """;

    private static final String INSERT_SQL = """
            INSERT INTO users(username, password)
            VALUES (?, ?)
            RETURNING id;
            """;

    private static final String DELETE_BY_ID_SQL = """
            DELETE FROM users
            WHERE id = ?
            """;

    private static final String FIND_BY_ID_SQL = """
            SELECT * FROM users
            WHERE id = ?
            """;

    private static final String FIND_BY_USERNAME_SQL = """
            SELECT * FROM users
            WHERE username = ?
            """;

    public User save(User user) throws SQLException {
        var statement = Datasource.getConnection().prepareStatement(INSERT_SQL);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
//        statement.execute();

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int generatedId =
                        resultSet.getInt(1);
                System.out.println("Generated ID: " + generatedId);
            }

            statement.close();
            return user;
        }
    }

        public void deleteById ( int id) throws SQLException {
            try (var statement = Datasource.getConnection().prepareStatement(DELETE_BY_ID_SQL)) {
                statement.setLong(1, id);
                var affectedRows = statement.executeUpdate();
                System.out.println("# of users deleted: " + affectedRows);
            }
        }

    public UserRepository() throws SQLException {
            initTable();
//        var statement = Datasource.getConnection().prepareStatement(CREATE_TABLE);
//        statement.execute();
//        statement.close();
        }

        public void initTable () throws SQLException {
            var statement = Datasource.getConnection().prepareStatement(CREATE_TABLE);
            statement.execute();
            statement.close();
        }

//    public static void tableInit() throws SQLException {
//        var statement = Datasource.getConnection().prepareStatement(CREATE_TABLE);
//        statement.execute();
//        statement.close();
//    }

        public User findById ( int id) throws SQLException {
            try (var statement = Datasource.getConnection().prepareStatement(FIND_BY_ID_SQL)) {
                statement.setLong(1, id);
                ResultSet resultSet = statement.executeQuery();

                User user = null;
                if (resultSet.next()) {
                    Long userId = resultSet.getLong(1);
                    String username = resultSet.getString(2);
                    String password = resultSet.getString(3);

                    user = new User(userId, username, password, null);
                }

                return user;
            }
        }

        public User findByUsername (String username) throws SQLException {
            try (var statement = Datasource.getConnection().prepareStatement(FIND_BY_USERNAME_SQL)) {
                statement.setString(1, username);
                ResultSet resultSet = statement.executeQuery();

                User user = null;
                if (resultSet.next()) {
                    Long userId = resultSet.getLong(1);
//                String username = resultSet.getString(2);
                    String password = resultSet.getString(3);

                    user = new User(userId, username, password, null);
                }

                return user;
            }
        }

    }
