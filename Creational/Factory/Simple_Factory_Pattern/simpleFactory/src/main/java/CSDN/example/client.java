package CSDN.example;

/**
 * 客户端调用工厂类的工厂方法即可得到产品对象
 *
 * Created by yrd on 2017/9/26.
 */
public class client {

    public static void main(String[] args) {
        Product product;
        product = Factory.getProduct("A");
        product.methodSame();
        product.methodDiff();
    }
}
