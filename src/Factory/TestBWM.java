package Factory;

public class TestBWM{
    public static void main(String[] args) {
        //创建个宝马 系列的对象
        //开发人员B的工作
        BWM bwm3=new BWM3Factory().producBWM();
        bwm3.showInfo();
        BWM bwm5=new BWM5Factory().producBWM();
        bwm5.showInfo();
        BWM bwm7=new BWM7Factory().producBWM();
        bwm7.showInfo();
    }
}
