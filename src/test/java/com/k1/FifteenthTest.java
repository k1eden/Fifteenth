package com.k1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;


class FifteenthTest {

    @Test
    void canItSolve() {
        ArrayList<Integer> test = new ArrayList<Integer>(15);
        test.add(0,1);
        Fifteenth tester = new Fifteenth(test);
        assertFalse(tester.CanItSolve());
    }

    @Test
    void solve() {
    }
}