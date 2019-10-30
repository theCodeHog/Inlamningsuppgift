package com.company;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class MagicStoreProgramTest {

    private MagicStoreProgram potionsProgram = new MagicStoreProgram();

    @org.junit.Test
    public void addPotion() {
        int amountOfPotions = potionsProgram.potions.size();
        String input = "PotionTest\nPotionTest\n44";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        potionsProgram.addPotion();

        assertEquals(amountOfPotions+1, potionsProgram.potions.size());
    }

}   