package LearnJdbc3;

import java.util.List;

/**
 * 测试jdbcUtil 工具类
 * 增删改查
 */
public class testutil {
    public static void main(String[] args) {
//        JdbcUtil.Update("insert into admin(username,password) values(?,?)","Airlys","19318");
//        JdbcUtil.Update("delete from admin where password=?","19990318");
//        JdbcUtil.Update("update admin set username=?,password=? where id=?","tongliya","999999","4");
        List a=JdbcUtil.Query("select * from admin");
        for (Object c:a) {
            System.out.println(c.toString());
        }
    }
}
