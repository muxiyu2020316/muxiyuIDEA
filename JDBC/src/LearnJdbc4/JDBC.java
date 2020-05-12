package LearnJdbc4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC {
    /**
     * �������ݿ�̶�����
     */
    final static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final static String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Student";
    final static String userName="sa";
    final static String userPwd="123456";

    public static void main(String[] args) throws Exception {
        update();
    }

    public static void update() throws Exception {
        //a.�������������ؾ����������
        Class.forName(driverName);
        //b.�����ݿ⽨������
        Connection connection = DriverManager.getConnection(dbURL, userName, userPwd);
        //c.����sql��ִ����ɾ��
        Statement statement = connection.createStatement();
        String sql = "delete form student where age=22";
        //ִ��SQL
        int count = statement.executeUpdate(sql); //����ֵ��ʾ ��ɾ�ļ�������
        //d.������
        if (count > 0) {
            System.out.println("�����ɹ�! ");
        } else {
            System.out.println("����ʧ��");
        }
        //�ر����ݿ�
        statement.close();
        connection.close();
    }
}
