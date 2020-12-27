package com.arvin.bat;

import org.junit.Test;

public class Foo {

    @Test
    public void foo() {
        System.out.println("++++++++++++++++++++++++++++++++++++");
        int n = 20;
        for (int i = 0; i < n; i--) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }
}
