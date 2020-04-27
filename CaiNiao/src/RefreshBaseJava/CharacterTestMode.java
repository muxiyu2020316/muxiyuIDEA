package RefreshBaseJava;

public class CharacterTestMode {
    public static void main(String[] args) {
        System.out.println(Character.isLetter('m'));//是否是字符
        System.out.println(Character.isDigit('2'));//是否是数字
        System.out.println(Character.isWhitespace(' '));//是否是空格
        System.out.println(Character.isWhitespace('\n'));
        System.out.println(Character.isWhitespace('\t'));
        System.out.println( Character.isLowerCase('c'));//是否是小写字母
        System.out.println( Character.isUpperCase('C'));//是否是大写字母
        System.out.println(Character.toUpperCase('a'));//把字母指定成大写
        System.out.println(Character.toLowerCase('V'));//把字母指定成小写
        apart();

    }
    public static  void apart(){
        String str1="MU XI YU i love YU 1314 8187 ";
        String str2="";//记录大写字母;
        String str3="";//记录小写字母;
        String str4="";//记录数字;
        String str5="";//记录空格;
        for(int i=0;i<str1.length();i++){
            if(Character.isUpperCase(str1.charAt(i))){
//先将String类型的字符串转换成char类型,再获取每一个字符元素，用charAt(i)实现
                str2+=str1.charAt(i)+" ";
            }
            if(Character.isLowerCase(str1.charAt(i))){
//先将String类型的字符串转换成char类型,再获取每一个字符元素，用charAt(i)实现
                str3+=str1.charAt(i)+" ";
            }
            if(Character.isDigit(str1.charAt(i))){
//先将String类型的字符串转换成char类型,再获取每一个字符元素，用charAt(i)实现
                str4+=str1.charAt(i)+" ";
            }
            if(Character.isWhitespace(str1.charAt(i))){
//先将String类型的字符串转换成char类型,再获取每一个字符元素，用charAt(i)实现
                str5+=str1.charAt(i)+" ";
            }
        }
        System.out.println("大写字母有：" + str2);
        System.out.println("小写字母有：" + str3);
        System.out.println("数字有：" + str4);
        System.out.println("空格有：" + str5.length()+"个");
    }
}
