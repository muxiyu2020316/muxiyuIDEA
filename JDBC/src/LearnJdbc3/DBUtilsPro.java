package LearnJdbc3;

import LearnJdbc2.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库增删该差增强版
 * @ author 3y
 */
public class DBUtilsPro {
    static Connection conn=null;
    static PreparedStatement ps=null;
    static ResultSet rs=null;
    public static void main(String[] args) {
        Object obj[];

        update("insert into admin(username,password) values(?,?)","chuying","000201314");
        quary("select ?,? from admin ",null,"username","password");
    }

    /**
     * 增删改只有传入的sql语句和参数不同,只需让低啊用着传入参数即可
     * 传入的参数是不确定的,可以采用泛型方法,也可以使用Object类型代替大部分
     * @param sql ,数据查询语句
     * @param obj ,传入的参数
     * 这里传入的参数我们可以使用java8的新特性,可变参数传递,格式Object... obj
     */
    public static void update(String sql,Object... obj){
        int count=0;
        try {
            conn= DBUtil.getConnection();
            //原本是要预先定义一条sql语句的,此处有参数传入
            //获取预处理操作对象
            ps=conn.prepareStatement(sql);
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
            DBUtil.close(conn,ps,null);
        }
    }

    /**【策略模式】
     *  1:对于查询语句来说【常用的就是把数据封装成一个Bean对象，封装成一个List集合】
     *  2.可以定义一个接口，让调用者把接口的实现类传递进来
     *  3:接口调用的方法就是调用者传递进来实现类的方法。
     * @param sql ,sql查询语句
     * @param obj ,传入的参数
     * @param rsh ,处理结果集,使用了策略模式 ResultSetHandler 就是策略模式
     * @return ,返回结果集,对应策略模式处理的步骤
     * 有个注意事项,如果这里使用了可变参数,那么久需要放在最后的位置,因为可变参数的后面不允许再有参数
     */
    public static Object quary(String sql, ResultSetHandler rsh, Object... obj){
        try {
            conn=DBUtil.getConnection();
            ps=conn.prepareStatement(sql);
            //根据传递进来的参数，设置SQL占位符的值
            if (obj!=null){
                for (int i = 0; i <obj.length ; i++) {
                    //jdbc 所有的下标都是从0开始的
                    ps.setObject(i+1,obj[i]);
                }
                //处理结果集
                rs=ps.executeQuery();
                //调用调用者传递进来实现类的方法，对结果集进行操作
                return rsh.hanlder(rs);
            }else{
                System.out.println("请传入相应参数!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        return rs;
    }
}

