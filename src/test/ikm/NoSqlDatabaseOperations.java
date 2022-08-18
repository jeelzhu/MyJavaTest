package ikm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

abstract class NoSqlDatabaseOperations {

    abstract void updateData(String updateQuery);
    void deleteData(String query){/*code to delete records from database tables */ }
}


interface DatabaseOperations {
    ResultSet getData(String query);
    default void executeProcedure(String procedureName) { System.out.println("do nothing"); }
    Connection getConnection();
}