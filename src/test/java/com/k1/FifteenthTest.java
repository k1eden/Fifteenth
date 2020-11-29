package com.k1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class FifteenthTest {

    @Test
    void canItSolve() {
        ArrayList<Integer> test = new ArrayList<Integer>(15);
        test.add(0,10);
        test.add(1,14);
        test.add(2,11);
        test.add(3,9);

        test.add(4,8);
        test.add(5,12);
        test.add(6,1);
        test.add(7,5);

        test.add(8,7);
        test.add(9,4);
        test.add(10,13);
        test.add(11,6);

        test.add(12,2);
        test.add(13,3);
        test.add(14,15);
        test.add(15,0);

        Fifteenth tester = new Fifteenth(test);
        assertTrue(tester.CanItSolve());
    }

    @Test
    void solve() {
        ArrayList<Integer> test = new ArrayList<Integer>(15);
        test.add(0,1);
        test.add(1,2);
        test.add(2,3);
        test.add(3,4);

        test.add(4,0);
        test.add(5,5);
        test.add(6,6);
        test.add(7,7);

        test.add(8,8);
        test.add(9,9);
        test.add(10,10);
        test.add(11,11);

        test.add(12,12);
        test.add(13,13);
        test.add(14,14);
        test.add(15,15);

        Fifteenth tester = new Fifteenth(test);

        assertEquals("Solver successfully solved your problem. Way: SDDWAASSDWWDSAAWDDDSAAWDDSAWASSDD in 33 step(s)",tester.Solve());

        ArrayList<Integer> test1 = new ArrayList<Integer>(15);
        test1.add(0,15);
        test1.add(1,7);
        test1.add(2,8);
        test1.add(3,5);

        test1.add(4,6);
        test1.add(5,2);
        test1.add(6,10);
        test1.add(7,4);

        test1.add(8,9);
        test1.add(9,1);
        test1.add(10,14);
        test1.add(11,3);

        test1.add(12,13);
        test1.add(13,12);
        test1.add(14,11);
        test1.add(15,0);

        Fifteenth tester1 = new Fifteenth(test1);

       assertEquals("Solver successfully solved your problem. Way: AAAWWWDSSAWDSASDWDWDWASDSSAAWWDDWAAASDWDSASDDS in 46 step(s)", tester1.Solve());

        ArrayList<Integer> test2 = new ArrayList<Integer>(15);
        test2.add(0,1);
        test2.add(1,2);
        test2.add(2,3);
        test2.add(3,4);

        test2.add(4,5);
        test2.add(5,6);
        test2.add(6,7);
        test2.add(7,8);

        test2.add(8,9);
        test2.add(9,10);
        test2.add(10,11);
        test2.add(11,12);

        test2.add(12,13);
        test2.add(13,14);
        test2.add(14,15);
        test2.add(15,0);

        Fifteenth tester2 = new Fifteenth(test2);

        assertEquals("It's already solved!", tester2.Solve());

        ArrayList<Integer> test3 = new ArrayList<Integer>(15);
        test3.add(0,2);
        test3.add(1,15);
        test3.add(2,12);
        test3.add(3,7);

        test3.add(4,4);
        test3.add(5,1);
        test3.add(6,5);
        test3.add(7,8);

        test3.add(8,3);
        test3.add(9,10);
        test3.add(10,6);
        test3.add(11,9);

        test3.add(12,13);
        test3.add(13,14);
        test3.add(14,11);
        test3.add(15,0);

        Fifteenth tester3 = new Fifteenth(test3);

        assertEquals("Solver successfully solved your problem. Way: AAWWASDDWAWASSDDDWAAWASSDDWWDSSAWWASASDSDDWASD in 46 step(s)", tester3.Solve());

   //   ArrayList<Integer> test4 = new ArrayList<Integer>(15);
   //  test4.add(0,2);
   //  test4.add(1,15);
   //  test4.add(2,12);
   //  test4.add(3,7);

   //  test4.add(4,4);
   //  test4.add(5,1);
   //  test4.add(6,5);
   //  test4.add(7,8);

   //  test4.add(8,3);
   //  test4.add(9,10);
   //  test4.add(10,6);
   //  test4.add(11,9);

   //  test4.add(12,13);
   //  test4.add(13,14);
   //  test4.add(14,11);
   //  test4.add(15,-1);


   //  Fifteenth tester4 = new Fifteenth(test4);

   //  assertEquals("You should to write all digits!", tester4.Solve());
        // Проверка на "Убийство" процесса при некорректно заданном на вход списке.
    }
}