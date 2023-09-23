package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedAnimalFoodTest {

    private final String typeOfAnimal;
    private final List result;


    public ParametrizedAnimalFoodTest(String typeOfAnimal, List result) {
        this.typeOfAnimal = typeOfAnimal;
        this.result = result;
    }
    @Parameterized.Parameters
    public static Object[][] FoodParam() {

        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }
    @Test
    public void getFoodTest() throws Exception {
        Animal testAnimal = new Animal();
         List foodResult = testAnimal.getFood(typeOfAnimal);
        Assert.assertEquals(result, foodResult);
    }
}

