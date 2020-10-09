package com.kyh;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class YatzyTest {

    @Test
    void checkingIfYatzyWorks() {

        Dice[] dices = new Dice[5];

        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice();
            dices[i].setValue(6);
        }

        assertTrue(Yatzy.checkIfYatzy(dices));
    }

    @Test
    void checkingIfYatzyDontWork() {

        Dice[] dices = new Dice[5];

        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice();
            dices[i].setValue(2);
        }
        dices[4].setValue(1);

        assertFalse(Yatzy.checkIfYatzy(dices));
    }
}