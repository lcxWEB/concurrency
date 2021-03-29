package com.example.concurrency.finals;

public class Son extends Base{
    public void test() {
    }
    public static void main(String[] args) {
        Son son = new Son();
        Base father = son;
        // father.test(); // private方法无法继承
        son.test();
    }
}