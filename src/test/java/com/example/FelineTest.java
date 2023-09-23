package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    @Test
    public void eatMeat() throws Exception {
        Feline testFeline = new Feline();
        List<String> responseGetFood = testFeline.eatMeat();
        //System.out.println(responseGetFood);
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), responseGetFood);
    }

    @Test
    public void getFamily() {
        Feline testFeline = new Feline();
        String responseGetFamily = testFeline.getFamily();
        Assert.assertEquals("Кошачьи", responseGetFamily);
    }

    @Test
    public void getKittens() {
        Feline testFeline = new Feline();
        int responseGetKittens = testFeline.getKittens();
        Assert.assertEquals(1, responseGetKittens);
    }

    @Test
    public void testGetMoreKittens() {
        Feline testFeline = new Feline();
        int rnd = 5;
        int expected = (int) (rnd* Math.random());
        int responseMoreKittens = testFeline.getKittens(expected);
//        System.out.println(expected);
//        System.out.println(responseMoreKittens);
        Assert.assertEquals(expected, responseMoreKittens);

    }
}