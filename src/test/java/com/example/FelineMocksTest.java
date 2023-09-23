package com.example;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineMocksTest {


        @Mock
        Feline feline;
        @Test
        public void eatMeatTest() throws Exception {
            feline.eatMeat();
            Mockito.verify(feline, Mockito.times(1)).eatMeat();
            Mockito.verifyNoMoreInteractions(feline);
        }
        @Test
        public void getFamilyTest() {
            feline.getFamily();
            Mockito.verify(feline, Mockito.times(1)).getFamily();
            Mockito.verifyNoMoreInteractions(feline);
        }
        @Test
        public void getKittensTest() {
            feline.getKittens();
            Mockito.verify(feline, Mockito.times(1)).getKittens();
            Mockito.verifyNoMoreInteractions(feline);
        }
        @Test
        public void getSomeKittensTest() {

            int kittensCount = 1;

            Integer expKittenCount = 1;

            feline.getKittens(kittensCount);

            Mockito.verify(feline, Mockito.times(1)).getKittens(expKittenCount);
            Mockito.verifyNoMoreInteractions(feline);
        }
    }

