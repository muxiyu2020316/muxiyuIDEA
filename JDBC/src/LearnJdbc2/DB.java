package LearnJdbc2;
import java.sql.*;
import java.util.ResourceBundle;
/**
 * jdbc������.�򻯲���
 */
public class DB {
    //������Ĺ��췽������˽�е�,����Ҫnew����,��ֱ�ӵ���
    private DB(){}
    //��ȡ�����ļ�����Ϣ
    static ResourceBundle bundle=ResourceBundle.getBundle("db");
    static String driver=bundle.getString("driver");
    static String url=bundle.getString("url");
    static String user=bundle.getString("user");
    static String pwd=bundle.getString("password");
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * ��ȡ���ݿ�����
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,pwd);
    }
    /**
     * �ر���Դ
     * @param conn ����
     * @param ps ���ݲ�������
     * @param rs   �����
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        //�ͷ���Դ
        try {
            if(rs!=null)
                rs.close();
        }catch (Exception e2) {
            System.out.println("rs�ر�ʧ��");
        }
        try {
            if(ps!=null)
                ps.close();
        }catch (Exception e2) {
            System.out.println("stmt�ر�ʧ��");
        }
        try {
            if(conn!=null)
                conn.close();
        } catch (Exception e2) {
            System.out.println("conn�ر�ʧ��");
        }
    }
}
