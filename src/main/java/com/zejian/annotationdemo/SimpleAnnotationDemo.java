package com.zejian.annotationdemo;

/**
 * Created by wuzejian on 2017/5/19.
 */

//注明该类已过时，不建议使用
@Deprecated
class A{
    public void A(){ }

    //注明该方法已过时，不建议使用
    @Deprecated()
    public void B(){ }
}

class B extends A{

    @Override //标明覆盖父类A的A方法
    public void A() {
        super.A();
    }

    //去掉检测警告
    @SuppressWarnings({"uncheck","deprecation"})
    public void C(){

    }
    //去掉检测警告
    @SuppressWarnings("uncheck")
    public void D(){

    }
}

public class SimpleAnnotationDemo {

}
