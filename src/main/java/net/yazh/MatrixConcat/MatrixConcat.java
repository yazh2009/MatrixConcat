package net.yazh.MatrixConcat;

import net.yazh.MatrixConcat.Model.Row;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class with main method
 */
public class MatrixConcat {
    private static final String URL = "jdbc:postgresql://localhost:5432/Matrix";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "qwe1";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final int N = 5;

    private static ArrayList<Row> rows = new ArrayList<>();

    public static void main(String[] args){
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try(Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = con.createStatement()){
            getRowsFromAllTables(statement);
            createResultTable(statement);
            fillTableWithAllRows(statement);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void getRowsFromAllTables(Statement statement) throws SQLException {
        for(int i=1; i<=N; i++){
            String dbName = "DB" + i;
            String query = "SELECT * FROM "+dbName;
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Row row = new Row(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getString(3), i);
                rows.add(row);
            }
        }
    }

    public static void createResultTable(Statement statement) throws SQLException {
        for(int i=1; i<=N; i++) {
            String field1 = "V"+i+"1";
            String field2 = "V"+i+"2";
            String query = "ALTER TABLE DB ADD "+field1+" VARCHAR(20), ADD "+field2+" VARCHAR(20)";
            statement.addBatch(query);
        }

        statement.executeBatch();
    }

    public static void fillTableWithAllRows(Statement statement) throws SQLException {
        int previousId = 0;

        Collections.sort(rows);

        for(Row row : rows) {
            String query;
            String field1 = "V"+row.getTable()+"1";
            String field2 = "V"+row.getTable()+"2";

            if(previousId!=row.getId()) {
                query = "INSERT INTO DB (id, " + field1 + ", " + field2 + ") VALUES ("
                        + row.getId() + ", '" + row.getV1() + "', '" + row.getV2() + "')";
            } else {
                query = "UPDATE DB SET "+field1+"='"+row.getV1()+"', "+field2+"='"+row.getV2()+
                        "' WHERE id ="+row.getId();
            }

            statement.addBatch(query);
            previousId = row.getId();
        }

        statement.executeBatch();
    }
}
