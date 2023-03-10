package storage;

import entity.Operation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCOperationStorage {

    public void save(Operation operation) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "hazhbilkG")) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into operations values (default, ?, ?, ?, ?)");
            preparedStatement.setDouble(1,operation.getNum1());
            preparedStatement.setDouble(2,operation.getNum2());
            preparedStatement.setDouble(3,operation.getResult());
            preparedStatement.setString(4,operation.getType());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Operation> findAll() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "hazhbilkG")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from operations");
            List<Operation> operations = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                double num1 = resultSet.getDouble(2);
                double num2 = resultSet.getDouble(3);
                double result = resultSet.getDouble(4);
                String type = resultSet.getString(5);
                Operation operation = new Operation(id, num1, num2, result, type);
                operations.add(operation);
            }
            return  operations;
        } catch (SQLException e) {
        }
        return new ArrayList<>();
    }

    public Optional<Operation> findById(long id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "hazhbilkG")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from  operations where id = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            double num1 = resultSet.getDouble(2);
            double num2 = resultSet.getDouble(3);
            double result = resultSet.getDouble(4);
            String type = resultSet.getString(5);

            Operation operation = new Operation(id, num1, num2, result, type);
            return Optional.of(operation);

        } catch (SQLException e) {
         }
        return  Optional.empty();
    }

    public void deleteById(long id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "hazhbilkG")) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from  operations where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
