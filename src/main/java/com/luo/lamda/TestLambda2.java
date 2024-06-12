package com.luo.lamda;

public class TestLambda2 {
    public static void main(String[] args) {
//        ILove love = (String num) -> {
//            System.out.println("i love you " + num + " thousand times");
//        };

        //简化1：去掉参数类型
//        ILove love = (num) -> {
//            System.out.println("I love you " + num + " thousand times");
//        };

        //简化2：去掉参数类型的括号，但只允许函数式接口和一个参数情况下
        ILove love = num -> System.out.println("I love you " + num + " thousand times");

        love.love("three");
    }
}

interface ILove{
    void love(String num);
}

class Love implements ILove{

    @Override
    public void love(String num) {
        System.out.println("I love you " + num + " thousand times");
    }
}
