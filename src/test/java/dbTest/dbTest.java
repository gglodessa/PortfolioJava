package dbTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.*;
import static UIObjects.pages.BaseTest.logger;

public class dbTest {

    @Test
    public void dataBaseTest() throws SQLException {
        logger.info("1. Connecting to the database and fetching data...");

        Connection connection = DriverManager.getConnection(
                "jdbc:sqlite:C:\\Users\\Oleksii\\IdeaProjects\\PortfolioJava\\src\\main\\resources\\Countries.db"
        );
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM Countries";
        ResultSet resultSet = statement.executeQuery(query);

        logger.info("2. Validating population density and total population...");

        int totalPopulation = 0;
        boolean isUSADensityBelow50 = false;

        while (resultSet.next()) {
            String country = resultSet.getString("Country");
            int population = resultSet.getInt("Population");
            int area = resultSet.getInt("Area");
            double density = (double) population / area;

            logger.info(String.format("Country: %s, Population: %d, Area: %d, Density: %.2f people/sq.km",
                    country, population, area, density));

            totalPopulation += population;

            if ("USA".equals(country) && density < 50) {
                isUSADensityBelow50 = true;
                logger.info(String.format("USA density is below 50 people/sq.km: %.2f", density));
            }
        }

        boolean isTotalPopulationLessThan2Billion = totalPopulation < 2_000_000_000;

        logger.info(String.format("Total population of all countries: %d", totalPopulation));
        logger.info(String.format("Is total population less than 2 billion? %b", isTotalPopulationLessThan2Billion));

        Assert.assertTrue(isUSADensityBelow50, "USA's population density is not below 50 people/sq.km.");
        Assert.assertTrue(isTotalPopulationLessThan2Billion, "Total population exceeds 2 billion people.");

        logger.info("3. Closing the database connection...");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
