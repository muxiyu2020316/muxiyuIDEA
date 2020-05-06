package LearnJdbc2;

import LearnJdbc3.ResultSetHandler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * 策略模式实现类
 */
public class BeanHandle implements ResultSetHandler {
//要封装成一个Bean对象，首先要知道Bean是什么，这个也是调用者传递进来的。
    private Class clazz;
    public BeanHandle(Class clazz){
        this.clazz=clazz;
    }

    @Override
    public Object hanlder(ResultSet resultSet) {

        try {
            //创建传递对象的实例化,反射机制
            Object bean =clazz.newInstance();
            if(resultSet.next()){
                //获取元数据结果集
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                for (int i = 0; i <resultSetMetaData.getColumnCount() ; i++) {
                    //获取每列的列名,jdbc所有的下标都是从1开始
                    String columnname=resultSetMetaData.getColumnName(i+1);
                    //获取每列的属性,数据
                    String columnData=resultSet.getString(i);
                    //设置bean的属性
                    Field field=clazz.getDeclaredField(columnname);
                    //将私有方法或者属性解锁
                    field.setAccessible(true);
                    field.set(bean,columnData);
                }
                return bean;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
