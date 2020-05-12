package LearnJdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC {
    /**
     * 连接数据库固定参数
     */
    final static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final static String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Student";
    final static String userName="sa";
    final static String userPwd="123456";

    public static void main(String[] args) throws Exception {
        update();
    }

    public static void update() throws Exception {
        //a.导入驱动，加载具体的驱动类
        Class.forName(driverName);
        //b.与数据库建立连接
        Connection connection = DriverManager.getConnection(dbURL, userName, userPwd);
        //c.发送sql，执行增删改
        Statement statement = connection.createStatement();
        String sql = "delete form student where age=22";
        //执行SQL
        int count = statement.executeUpdate(sql); //返回值表示 增删改几条数据
        //d.处理结果
        if (count > 0) {
            System.out.println("操作成功! ");
        } else {
            System.out.println("操作失败");
        }
        //关闭数据库
        statement.close();
        connection.close();
    }
}
