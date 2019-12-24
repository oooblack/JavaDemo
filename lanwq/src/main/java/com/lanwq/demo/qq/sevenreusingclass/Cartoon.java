package com.lanwq.demo.qq.sevenreusingclass;

/**
 * @program: ThinkingInJavaDemo -->Cartoon
 * @Description : <blue>父子类初始化</blue>
 * @author: lanwenquan
 * @creatTime: 2019-11-20 22 : 42
 **/

class Art {
    public Art() {
        System.out.println("art constructor");
    }

    static {
        System.out.println("art 静态代码实例块");
    }

    {
        System.out.println("art 非静态代码实例块");
    }
}

class Drawing extends Art {
    public Drawing() {
        System.out.println("drawing constructor");
    }

    static {
        System.out.println("Drawing 静态代码实例块");
    }

    {
        System.out.println("Drawing 非静态代码实例块");
    }
}

public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("cartoon constructor");
    }

    static {
        System.out.println("Cartoon 静态代码实例块");
    }

    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}
