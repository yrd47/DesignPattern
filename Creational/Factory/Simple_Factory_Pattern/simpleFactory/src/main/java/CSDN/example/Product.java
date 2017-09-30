package CSDN.example;

/**
 * 将所有产品类公共的代码移至抽象产品类，并在抽象产品类声明一些抽象方法，以供不同的具体产品类来实现
 *
 * Created by yrd on 2017/9/26.
 */
public abstract class Product {

    //所有产品类的公共业务方法
    public void methodSame() {
        //实现
    }

    public abstract void methodDiff();
}
