package LearnJdbc3;

import java.sql.ResultSet;

/**
 * ����Խ���������Ľӿڣ���������Ҫ�Խ��������ʲô������ֻҪʵ������ӿڼ���
 */
public interface ResultSetHandler {
    Object hanlder(ResultSet resultSet);
}
