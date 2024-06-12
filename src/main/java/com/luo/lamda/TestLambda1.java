package com.luo.lamda;

public class TestLambda1 {
    //2.静态内部类
    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        //1.普通实现接口方式
        ILike like = new Like();
        like.lambda();

        ILike like2 = new Like2();
        like2.lambda();

        //3.局部内部类
        class Like3 implements ILike{

            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }

        ILike like3 = new Like3();
        like3.lambda();

        //4.匿名内部类，没有类的名称，必须借助接口或者父类
        ILike like4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like4.lambda();

        //5.用Lambda简化
        ILike like5 =() -> {
            System.out.println("I like lambda5");
        };
        like5.lambda();
    }
}

//定义一个函数式接口
interface ILike{
    void lambda();
}

//实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
