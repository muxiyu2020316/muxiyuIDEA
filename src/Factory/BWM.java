package Factory;
//宝马车的接口
public interface BWM {
    //产品信息介绍
    void showInfo();
}
//构建具体车的类
class BWM3 implements BWM{

    @Override
    public void showInfo() {
        System.out.println("哈哈,我是宝马车3,你买不起!");
    }
}
class BWM5 implements BWM{

    @Override
    public void showInfo() {
        System.out.println("宝马车5改名为沐汐语了,快来看看吧");
    }
}
class BWM7 implements BWM{

    @Override
    public void showInfo() {
        System.out.println("哈哈,我是宝马车7,你买不起!");
    }
}
