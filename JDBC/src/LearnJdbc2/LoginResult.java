package LearnJdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * sqlע��������
 * ֻҪ�û��ṩ��Ϣ������sql�ı���
 * ��ʱ�����عؼ���Ҳ�������
 * ��Ҫʹ��preparedStatement  ,Ԥ�����������
 *  PreparedStatement ps=null;
 */

/**
 * �Ա�preparedStatement��Statement.
 * ���ߴ���sqlע��,ǰ�߲���
 */
public class LoginResult {
    public static void main(String[] args) {
        //��ʼ��һ������
        //�����ʼ������
        Map<String,String> logininfo=initUI();
        //��֤�û�������
        boolean loginsuccess= login(logininfo);
        System.out.println(loginsuccess?"�ɹ�":"ʧ��");
    }
    /**
     * �û���¼��Ϣ
     * @param logininfo
     * @return
     */
    private static boolean login(Map<String, String> logininfo) {
        //����
        boolean loginsuccess=false;
        //�����������,ƴ��
        String loginname=logininfo.get("loginname");
        String loginpwd=logininfo.get("loginpwd");
        System.out.println(loginname+" "+loginpwd);
        //jdbc���6��
        PreparedStatement ps=null;//Ԥ��������ݿ��������
        //�ӿ���Ҫ�滻
        Connection conn=null;
        ResultSet rs=null;
        try{
            //1ע������
            Class.forName("com.mysql.jdbc.Driver");
            //2��ȡ����
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/girls",
                    "root","123456");
            //3��ȡԤ��������ݲ�������,sql�����
            String sql="select * from user where loginName=? and loginPwd=?";
            //һ��?��ʾһ��ռλ��,����ʹ��''������ ������Ϊռλ��,loginName=?
            ps= conn.prepareStatement(sql);
            /**�����Ǳ���õĿ��,��δ���ֵ?
             * ��ռλ����ֵ,��һ���ʺ���1,�ڶ����ʺ���2,jdbc���е��±궼�Ǵ�1��ʼ��
             * ʹ��set����,���Ĺؼ��ֲ��������
             */
            //4ִ��sql,ִ��Ԥ������sql���
            ps.setString(1,loginname);
            ps.setString(2,loginpwd);
            rs = ps.executeQuery(sql);
            //5��������
            if (rs.next()) {
                loginsuccess=true;
            }
        }catch(Exception e){

        }finally {
            //6�ͷ���Դ
            try {
                if(rs!=null)
                    rs.close();
            }catch (Exception e2) {
            }
            try {
                if(ps!=null)
                    ps.close();
            }catch (Exception e2) {
            }
            try {
                if(conn!=null)
                    conn.close();
            } catch (Exception e2) {
            }
        }
        return loginsuccess;
    }
    /**
     * ��ʼ���û�����
     * @return������Ϣ
     * ��ôƾ�����"+����+"
     */
    private static Map<String, String> initUI() {
        Scanner s=new Scanner(System.in);
        System.out.print("�û���:");
        String username=s.nextLine();
        System.out.print("����:");
        String userpwd=s.nextLine();
        Map<String,String> userLogininfo=new HashMap<>();
        userLogininfo.put("loginname",username);
        userLogininfo.put("loginpwd",userpwd);
        return userLogininfo;
    }
}
