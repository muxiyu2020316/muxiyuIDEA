package LearnJdbc3;

import java.sql.ResultSet;

/**
 * 定义对结果集操作的接口，调用者想要对结果集进行什么操作，只要实现这个接口即可
 */
public interface ResultSetHandler {
    Object hanlder(ResultSet resultSet);
}
