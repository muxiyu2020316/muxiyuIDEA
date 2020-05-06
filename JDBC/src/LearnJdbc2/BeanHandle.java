package LearnJdbc2;

import LearnJdbc3.ResultSetHandler;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * ����ģʽʵ����
 */
public class BeanHandle implements ResultSetHandler {
//Ҫ��װ��һ��Bean��������Ҫ֪��Bean��ʲô�����Ҳ�ǵ����ߴ��ݽ����ġ�
    private Class clazz;
    public BeanHandle(Class clazz){
        this.clazz=clazz;
    }

    @Override
    public Object hanlder(ResultSet resultSet) {

        try {
            //�������ݶ����ʵ����,�������
            Object bean =clazz.newInstance();
            if(resultSet.next()){
                //��ȡԪ���ݽ����
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                for (int i = 0; i <resultSetMetaData.getColumnCount() ; i++) {
                    //��ȡÿ�е�����,jdbc���е��±궼�Ǵ�1��ʼ
                    String columnname=resultSetMetaData.getColumnName(i+1);
                    //��ȡÿ�е�����,����
                    String columnData=resultSet.getString(i);
                    //����bean������
                    Field field=clazz.getDeclaredField(columnname);
                    //��˽�з����������Խ���
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
