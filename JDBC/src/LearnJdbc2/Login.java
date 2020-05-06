package LearnJdbc2;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ʵ�ֹ���:
     * 1.ģ���û���¼
     * 2.ҵ���߼�
         *  ��������,��ʾ�û�����������û���
         *  �û������,�ύ��Ϣ,��̨��֤,�ж��Ƿ����
 *    3.ʵ�ʿ�����ʹ��ר�ŵĽ�ģ����,��װpowerdesigner,ʹ��pd���߽���
 *      ʹ��sybase����
 *    4.���ڵ�����
 *    �û���:
 *    ����: xxxx  or yyy
 *    ��¼�ɹ�
 *    sqlע������(�ڿ�©��)
 *    �û��������Ϣ����sql'���ؼ���
 *    �ؼ��ֲ���sql���������,�������仯,�Ӷ�ʹ�÷Ƿ����ݺϷ���
 *
 */
public class Login {
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
        //jdbc���6��
        Statement stmt=null;
        Connection conn=null;
        ResultSet rs=null;
        try{
            //1ע������
            Class.forName("com.mysql.jdbc.Driver");
            //2��ȡ����
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/girls",
                    "root","123456");
            //3��ȡ���ݶ���
            stmt= conn.createStatement();
            //4ִ��sql
            String sql="select * from user where loginName='"+ loginname+"' and longinPwd='"+loginpwd+"'";
            //xxxx  or yyy ������Ϊ����͵���sql��京��Ť��,����sql�������ƾ��,�������ĺ���
            //�Ƿ���sql����dbns,���б���,���û��Ƿ���ϢҲ�����ȥ��
            //5��������
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                loginsuccess=true;
            }else{
                System.out.println("�ȶԲ�������");
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
                if(stmt!=null)
                    stmt.close();
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
