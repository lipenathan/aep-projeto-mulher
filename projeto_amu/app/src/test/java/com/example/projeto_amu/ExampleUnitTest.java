package com.example.projeto_amu;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void teste() {
        System.out.println("###########" + (retorna(1) instanceof Animal) + "################");
    }

    public Object retorna(int i) {
        if(i == 0) return new Pessoa();
        if(i == 1) return new Animal();
        else return null;
    }

    static class Pessoa {

    }

    static class Animal {

    }
}