package com.sparta.skeleton;

import com.sparta.skeleton.utilities.RandomBias;
import org.junit.jupiter.api.Test;

public class RandomBiasTest {

    @Test
    void checkRandom(){

        for (int i = 0; i<101 ; i++)
            System.out.println(RandomBias.randomBiasGenerator());
    }
}
