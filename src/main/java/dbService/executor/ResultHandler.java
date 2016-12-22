package dbService.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Anna Bloodwina
 * @version 1.0.201612221539
 */
public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
