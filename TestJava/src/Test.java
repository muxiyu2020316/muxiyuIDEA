import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {
    private static Connection dbConn = null;

    public static void main(String[] args) {
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=eMaket";
        try {
            //1.��������
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("���������ɹ���");
            //2.����
            dbConn = DriverManager.getConnection(
                    dbURL, "sa", "123456");
            System.out.println("�������ݿ�ɹ���");
            String sql="select * from student";
            PreparedStatement statement=null;
            statement=dbConn.prepareStatement(sql);
            ResultSet res=null;
            res=statement.executeQuery();
            while(res.next()){
                String title=res.getString("name");
                System.out.println(title);
            }
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("�������ݿ�ʧ�ܣ�");
        }

    }
}
