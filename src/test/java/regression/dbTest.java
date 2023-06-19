package regression;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

import static seleniumAdvanced.BaseTest.logger;

public class dbTest {

    @Test
    public void dataBaseTest() throws SQLException {
        logger.info("1. Database connection and get data");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alekseii\\IdeaProjects" +
                "\\PortfolioJava\\src\\main\\resources\\Countries.db");
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Countries";
        ResultSet resultSet = statement.executeQuery(query);

        logger.info("2. Checking population density below 50 people/sq.km and Checking total population " +
                "less than 2 billion people.");
        int totalPopulation = 0;
        boolean isUSADensityBelow50 = false;

        while (resultSet.next()) {
            String country = resultSet.getString("Country");
            int population = resultSet.getInt("Population");
            int area = resultSet.getInt("Area");
            double density = (double) population / area;

            totalPopulation += population;

            if (country.equals("USA") && density < 50) {
                isUSADensityBelow50 = true;
            }
        }

        boolean isTotalPopulationLessThan2Billion = totalPopulation < 2000000000;
        Assert.assertTrue(isUSADensityBelow50, "The population density is not below 50 people/sq.km." +
                " in the USA");
        Assert.assertTrue(isTotalPopulationLessThan2Billion, "The total population of all countries is " +
                "not less than 2 billion people");

        logger.info("3. Closing database connection");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
