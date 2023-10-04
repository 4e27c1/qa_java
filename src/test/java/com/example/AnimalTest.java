package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AnimalTest {
    @Test
    public void getFood() throws Exception {
        Animal testAnimal = new Animal();
        try {
            testAnimal.getFood("хз кто");
            Assert.fail("Expected Exception");
        } catch (Exception e) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

    @Test
    public void getFoodTestPredator() throws Exception {
        Animal testAnimal = new Animal();
        List<String> responseGetFood = testAnimal.getFood("Хищник");
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), responseGetFood);
    }

    @Test
    public void getFoodTestNotPredator() throws Exception {
        Animal testAnimal = new Animal();
        List<String> responseGetFood = testAnimal.getFood("Травоядное");
        Assert.assertEquals(List.of("Трава", "Различные растения"), responseGetFood);
    }

    @Test
    public void getFamily() {
        String family = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Animal testAnimal = new Animal();
        var actual = testAnimal.getFamily();
        Assert.assertEquals(family, actual);
    }
}
