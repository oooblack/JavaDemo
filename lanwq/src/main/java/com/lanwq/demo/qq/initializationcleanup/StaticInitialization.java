package com.lanwq.demo.qq.initializationcleanup;

/**
 * @program: ThinkingInJavaDemo->StaticInitialization
 * @description: 静态数据初始化顺序
 * @author: lanwenquan
 * @create: 2019-11-05 22:22
 **/
class Bowl {
    Bowl(int maker) {
        System.out.println("Bowl(" + maker + ")");
    }

    void f1(int maker) {
        System.out.println("Bowl(" + maker + ")");
    }
}

class Table {
    static Bowl bowl = new Bowl(1);

    Table() {
        System.out.println("Table()");
        bow2.f1(1);
    }

    void f2(int maker) {
        System.out.println("f2(" + maker + ")");
    }

    static Bowl bow2 = new Bowl(2);
}

class Cupboard {
    Bowl bow3 = new Bowl(3);
    static Bowl bow4 = new Bowl(4);

    Cupboard() {
        System.out.println("Cupboard()");
        bow4.f1(2);
    }

    void f3(int maker) {
        System.out.println("f3(" + maker + ")");
    }

    static Bowl bow5 = new Bowl(5);
}

public class StaticInitialization {
    public static void main(String[] args) {
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        System.out.println("Creating new Cupboard() in main");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
