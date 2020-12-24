package com.k1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class FifteenthTest {

    @Test
    void canItSolve() {
        ArrayList<Integer> test = new ArrayList<Integer>(15);
        test.add(0,1);
        test.add(1,2);
        test.add(2,3);
        test.add(3,4);

        test.add(4,5);
        test.add(5,6);
        test.add(6,7);
        test.add(7,8);

        test.add(8,9);
        test.add(9,10);
        test.add(10,11);
        test.add(11,12);

        test.add(12,13);
        test.add(13,15);
        test.add(14,14);
        test.add(15,0);

        Fifteenth tester = new Fifteenth(test);
        assertFalse(tester.canItSolve());
    }

    @Test
    void solve() throws Exception {
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

        char[] help =
    {'S','D','D','W','A','A','S','S','D','W','W','D','S','A','A','W','D','D','D','S','A','A','W',
            'D','D','S','A','W','A','S','S','D','D'};

        int help1 = help.length;
      assertTrue(Arrays.equals(help, tester.solve()));
      assertEquals(tester.step, help1);

       ArrayList<Integer> test1 = new ArrayList<Integer>(15);
       test1.add(0,12);
       test1.add(1,13);
       test1.add(2,3);
       test1.add(3,4);

       test1.add(4,6);
       test1.add(5,1);
       test1.add(6,10);
       test1.add(7,2);

       test1.add(8,8);
       test1.add(9,5);
       test1.add(10,11);
       test1.add(11,9);

       test1.add(12,0);
       test1.add(13,15);
       test1.add(14,14);
       test1.add(15,7);

       Fifteenth tester1 = new Fifteenth(test1);
        char[] help2 =
    {'W','W','W','D','S','D','D','W','A','S','A','A','W','D','D','D','S','A','S','D','W','A','A',
            'S','A','W','D','S','D','S','A','A','W','D','D',
            'D','S','A','A','W','D','W','D','S','A','S','D',
            'W','A','W','D','S','S'};

        assertTrue(Arrays.equals(help2, tester1.solve()));

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

      assertTrue(Arrays.equals(new char[0], tester2.solve()));

    //   ArrayList<Integer> test3 = new ArrayList<Integer>(15);
    //   test3.add(0,2);
    //   test3.add(1,15);
    //   test3.add(2,12);
    //   test3.add(3,7);

    //   test3.add(4,4);
    //   test3.add(5,1);
    //   test3.add(6,5);
    //   test3.add(7,8);

    //   test3.add(8,3);
    //   test3.add(9,10);
    //   test3.add(10,6);
    //   test3.add(11,9);

    //   test3.add(12,13);
    //   test3.add(13,14);
    //   test3.add(14,11);
    //   test3.add(15,0);

    //   Fifteenth tester3 = new Fifteenth(test3);

    //   assertEquals("Solver successfully solved your problem. Way: AAWWASDDWAWASSDDDWAAWASSDDWWDSSAWWASASDSDDWASD in 46 step(s)", tester3.solve());

    // ArrayList<Integer> test6 = new ArrayList<Integer>(15);
    // test6.add(0,2);
    // test6.add(1,15);
    // test6.add(2,12);
    // test6.add(3,7);

    // test6.add(4,4);
    // test6.add(5,1);
    // test6.add(6,5);
    // test6.add(7,8);

    // test6.add(8,3);
    // test6.add(9,10);
    // test6.add(10,6);
    // test6.add(11,9);

    // test6.add(12,13);
    // test6.add(13,14);
    // test6.add(14,11);
    // test6.add(15,-1);


    // Fifteenth tester6 = new Fifteenth(test6);

    // assertEquals("incorrect format", tester6.solve());

      ArrayList<Integer> test4 = new ArrayList<Integer>(15);
      test4.add(0,2);
      test4.add(1,15);
      test4.add(2,12);
      test4.add(3,7);

      test4.add(4,4);
      test4.add(5,1);
      test4.add(6,5);
      test4.add(7,8);

      test4.add(8,3);
      test4.add(9,10);
      test4.add(10,6);
      test4.add(11,9);

      test4.add(12,13);
      test4.add(13,14);
      test4.add(14,11);
      test4.add(15,0);

      test4.add(16,20);

      Fifteenth tester4 = new Fifteenth(test4);


      assertThrows(IllegalArgumentException.class,
              tester4::solve);

    //   ArrayList<Integer> test5 = new ArrayList<Integer>(15);
    //   test5.add(0,2);
    //   test5.add(1,15);
    //   test5.add(2,12);
    //   test5.add(3,7);

    //   test5.add(4,4);
    //   test5.add(5,1);
    //   test5.add(6,5);
    //   test5.add(7,8);

    //   test5.add(8,3);
    //   test5.add(9,100);
    //   test5.add(10,6);
    //   test5.add(11,9);

    //   test5.add(12,13);
    //   test5.add(13,14);
    //   test5.add(14,11);
    //   test5.add(15,0);

    //   Fifteenth tester5 = new Fifteenth(test5);

    //   assertEquals("incorrect format", tester5.solve());
    }
}