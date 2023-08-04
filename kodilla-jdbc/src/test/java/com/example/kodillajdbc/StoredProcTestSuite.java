package com.example.kodillajdbc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoredProcTestSuite {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/kodilla_course";
    private static final String USER = "kodilla_user";
    private static final String PASSWORD = "kodilla_password";

    @BeforeAll
    static void setUp() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String createBooksTable = "CREATE TABLE IF NOT EXISTS BOOKS (" +
                    "BOOK_ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "TITLE VARCHAR(100) NOT NULL," +
                    "AUTHOR VARCHAR(100) NOT NULL," +
                    "BESTSELLER BOOLEAN DEFAULT 0)";
            statement.executeUpdate(createBooksTable);

            String insertTestData = "INSERT INTO BOOKS (TITLE, AUTHOR) VALUES " +
                    "('Book 1', 'Author 1')," +
                    "('Book 2', 'Author 2')," +
                    "('Book 3', 'Author 3')";
            statement.executeUpdate(insertTestData);

            String createRentsTable = "CREATE TABLE IF NOT EXISTS RENTS (" +
                    "RENT_ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "BOOK_ID INT NOT NULL," +
                    "RENT_DATE DATE NOT NULL," +
                    "FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(BOOK_ID))";
            statement.executeUpdate(createRentsTable);

            String insertRentsData = "INSERT INTO RENTS (BOOK_ID, RENT_DATE) VALUES " +
                    "(1, '2023-07-01')," +
                    "(2, '2023-07-15')," +
                    "(3, '2023-07-20')," +
                    "(1, '2023-07-25')," +
                    "(2, '2023-07-30')," +
                    "(1, '2023-07-31')";
            statement.executeUpdate(insertRentsData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testUpdateBestsellers() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {


            String callProcedure = "CALL UpdateBestsellers()";
            statement.executeUpdate(callProcedure);


            String selectQuery = "SELECT COUNT(*) FROM BOOKS WHERE BESTSELLER = 1";
            var resultSet = statement.executeQuery(selectQuery);
            if (resultSet.next()) {
                int bestsellersCount = resultSet.getInt(1);
                assertEquals(0, bestsellersCount, "Expected 0 bestsellers");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}