package CSDN;

/**
 * 典型的对象适配器
 *
 * Created by yrd on 2017/9/28.
 */
public class Adapter implements Target {
    private Adaptee adaptee;    //维持一个对适配者对象的引用

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}


/**
 * 典型的类适配器
 */
class Adapter2 extends Adaptee implements Target {
    public void request() {
        specificRequest();
    }

}

interface Target {
    public void request() ;
}

class Adaptee {
    public void specificRequest(){

    };
}