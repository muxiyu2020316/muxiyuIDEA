package Factory;
//宝马车的产品工厂类
public interface BWMFactory {
    BWM producBWM();
}
//创建具体车型的汽车生产工厂
class BWM3Factory implements BWMFactory{

    @Override
    public BWM producBWM() {
        System.out.println("生产宝马3系列车");
        //生产工厂,生产汽车对象
        return new BWM3();
    }
}
class BWM5Factory implements BWMFactory{

    @Override
    public BWM producBWM() {
        System.out.println("生产宝马5系列车");
        //生产工厂,生产汽车对象
        return new BWM5();
    }
}
class BWM7Factory implements BWMFactory{

    @Override
    public BWM producBWM() {
        System.out.println("生产宝马7系列车");
        //生产工厂,生产汽车对象
        return new BWM7();
    }
}