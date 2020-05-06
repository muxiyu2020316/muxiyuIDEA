package LearnJdbc3;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jdbc 通用工具类,适合简化增删改查
 * 使用前记得导包
 */
public class JdbcUtil {
    //工具类的构造方法都是私有的,不需要new对象,类直接调用
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs=null;
    static String user="root";
    static String pwd="123456";
    static String url="jdbc:mysql://localhost:3306/girls";
    /**
     * 静态代码块在类加载执行,只执行一次,加载效率高
     */
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库链接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        Connection conn= DriverManager.getConnection(url,user,pwd);
        return conn;
    }
    /** 增删改的通用方法
     * @paramString sql  要执行的sql
     * @paramObject[] obj    对象类型的数组  里面存放着 sql执行的占位符参数
     *【name，age，id】
     *【id】
     *【name，age】
     * Object... 可变参数,注意后面不能再有参数
     * */
    public static void Update(String sql,Object... obj){
        try {
            int count;
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            //根据传入的参数设置占位符的数量
            for (int i = 0; i <obj.length ; i++) {
                //jdbc 所有的下标都是从0开始的
                ps.setObject(i+1,obj[i]);
            }
            //执行sql语句
            count=ps.executeUpdate();
            System.out.println(count+"条数据受到影响");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(conn,ps,rs);
        }
    }
    /**
     * c查询的通用方法
     * @param sql  sql语句
     * @param obj 可变参数
     * @return  返回结果集,返回的是一个链表
     * 用链表存储MAP
     */
    public static List<Map<String ,Object>> Query(String sql,Object... obj){
        try {
            conn =getConnection();
            //有可能有参数,这里的参数是 条件值?,而不是select后面的属性值
            ps=conn.prepareStatement(sql);
            //根据传入的参数设置占位符的数量
            for (int i = 0; i <obj.length ; i++) {
                //jdbc 所有的下标都是从0开始的
                ps.setObject(i+1,obj[i]);
            }

            //执行sql查询语句
            rs=ps.executeQuery();
        //需要存储数据,使用键值对最合适,一个map就是一个信息,最终存储在list,便于查询
            List<Map<String,Object>> list = new ArrayList<>();
            /**
             * 获取本次查询结果集有多少列
             * getMetaData(), 获取元数据
             * getColumnCount(),获取列数
             */
            int count = rs.getMetaData().getColumnCount();
            while(rs.next()){
                //一行数据 用一个map 接收
             Map<String ,Object> map=new HashMap<>();
                /**
                 * 注意:不用在乎数据表有多少列
                 * 通过getMetData().getColumnLabel() 获取列
                 * 得到了列就能经一步获取map的key
                 */
                for (int i = 0; i <count ; i++) {
                    String name=rs.getMetaData().getColumnLabel(i+1);
                    map.put(name,rs.getObject(name));
                }
                /*将每行的map存放到 List中*/
                list.add(map);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close(conn,ps,rs);
        }
        return null;
    }
    /**
     * 关闭资源
     * @param conn 链接
     * @param ps 数据操作对象
     * @param rs   结果集
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        //释放资源
        try {
            if(rs!=null)
                rs.close();
        }catch (Exception e2) {
            System.out.println("rs关闭失败");
        }
        try {
            if(ps!=null)
                ps.close();
        }catch (Exception e2) {
            System.out.println("stmt关闭失败");
        }
        try {
            if(conn!=null)
                conn.close();
        } catch (Exception e2) {
            System.out.println("conn关闭失败");
        }
    }
}
