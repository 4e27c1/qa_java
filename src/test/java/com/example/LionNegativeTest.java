package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionNegativeTest {

       @Mock
    Feline feline;


    @Test
    public void doesHaveManeTest() {
        System.out.println(123);
        try {
            Lion lionTest = new Lion(feline, "Неизвестный науке зверь");
            lionTest.doesHaveMane();

        } catch (Exception e) {
            Assert.assertEquals(
                    "Используйте допустимые значения пола животного - Самец или Самка",
                    e.getMessage());
        }
    }
}
