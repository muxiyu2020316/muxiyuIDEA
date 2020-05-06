package LearnJdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * 数据库脚本,转账
 * 7.表示有效数字,2表示小数点
  drop table if exists act;
  create table act(
  actno bigint,
  balance double(7,2)
 );
 insert into act values(111,10009.2);
 insert into act values(222,10099);
 */
/**
 * jdbc中的事物是自动提交的
 * 不需要commit,也没有回滚,执行一次dml语句就自动提交一次
 * 这是jdbc默认的事务行为,实际上都是需要多条语句联合才能完成的,需要保证同时成功或失败
 * 结论jdbc只要执行一次就自动提交一次失误
 * 单机事务
 * conn.setAutoCommit(false);
 * conn.commit();
 * conn.rollback();
 */
public class Commit {
    static PreparedStatement ps=null;//预编译的数据库操作对象
    static Connection conn=null;
    static ResultSet rs=null;
    public static void main(String[] args) {
       commitDB();
    }
    static void commitDB(){
        //jdbc编程6步
        try {
            //2获取链接
            /**将自动提交方法修改为手动提交*/
            //开启事务,手动提交
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            //3获取预编译的数据操作对象
            String sql = "update act set balance=? where actno=?";
            ps = conn.prepareStatement(sql);
            //给? 传值
            ps.setDouble(1, 1000);
            ps.setInt(2, 111);
            int count = ps.executeUpdate();
            //给? 传值
            ps.setDouble(1, 1000);
            ps.setInt(2, 222);
            //4执行sql
            count += ps.executeUpdate();
            System.out.println(count == 2 ? "成功" : "失败");
            //程序可以走这步,数据提交成功了,所以手动提交
            //提交事务
            conn.commit();
            //5.处理结果集
        } catch (Exception e) {
            //回滚事务
            if (conn != null) {
                try {
                    //手动回滚
                    conn.rollback();
                } catch (Exception e2) {
                    System.out.println("手动回滚失败");
                }
            }
            System.out.println("转账失败");
        } finally {
            //6释放资源
            DBUtil.close(conn,ps,rs);
        }
    }
}
