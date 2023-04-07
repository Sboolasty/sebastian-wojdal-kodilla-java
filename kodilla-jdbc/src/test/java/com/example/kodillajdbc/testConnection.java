package com.example.kodillajdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() {
        String query = "SELECT u.first_name, u.last_name " +
                "FROM users u " +
                "JOIN posts p ON u.id = p.user_id " +
                "GROUP BY u.id " +
                "HAVING COUNT(p.id) >= 2";

        List<String[]> results = DbManager.select(query);

        for (String[] result : results) {
            System.out.println(result[0] + " " + result[1]);
        }

        int expectedRows = 2;
        assertEquals(expectedRows, results.size());
    }
}

