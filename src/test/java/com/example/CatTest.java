package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Spy
    Feline feline;
    @Test
    public void getSoundTest(){
        Cat testCat = new Cat(feline);
        String sound = testCat.getSound();
        Assert.assertEquals("Мяу", sound);
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat testCat = new Cat(feline);
        List<String> responseGetFood = testCat.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), responseGetFood);
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
         }
}