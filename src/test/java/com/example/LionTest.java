package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;



@RunWith(Parameterized.class)

public class LionTest {
    private final String sex;
    private boolean exMane;
    private final String type;
    private final List food;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Spy
    Feline feline;

    public LionTest(String sex, boolean exMane, String type, List food) {
        this.sex = sex;
        this.exMane = exMane;
        this.type = type;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[][] params() {
        return new Object[][]{
                {"Самец", true, "Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Самка", false, "Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Самец", true, "Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        lion.getKittens();
       // Mockito.when(feline.getKittens()).thenReturn(1);
        //Mockito.verify(feline, Mockito.times(1).getKittens());
        //Mockito.verifyNoMoreInteractions(feline);
        Assert.assertEquals("Результат не совпадает с ожидаемым", 1, lion.getKittens());
    }

    @Test
    public void doesHaveManeTest() {
        try {
            Lion lion = new Lion(feline, sex);
            //assertThrows(Exception.class, () -> new Lion(feline, PERVERT));
            lion.doesHaveMane();
        } catch (Exception e) {
            Assert.assertEquals(
                    "Результат не совпадает с ожидаемым",
                    e.getMessage());
        }
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline, sex);
        lion.getFood();
        Mockito.when(feline.getFood(type)).thenReturn(food);
        Mockito.verify(feline, Mockito.times(1)).getFood(type);
        Mockito.verifyNoMoreInteractions(feline);
        Assert.assertEquals("Неподходящая еда", food, lion.getFood());
    }
}
