package com.platzi.javatests.player;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class PlayerTest {

    @Test
    void playerLoosesWhenDiceNumberIsTooLow() {
        Dice dice = Mockito.mock(Dice.class);

        when(dice.roll()).thenReturn(4);

        Player player = new Player(dice, 5);

        assertFalse(player.play());
    }

    @Test
    void playerWinsWhenDiceNumberIsTooLow() {
        Dice dice = Mockito.mock(Dice.class);

        when(dice.roll()).thenReturn(5);

        Player player = new Player(dice, 5);

        assertTrue(player.play());
    }
}