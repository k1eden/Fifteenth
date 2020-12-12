package com.k1;

import java.util.ArrayList;
import java.util.HashSet;

public class Fifteenth {
   int[] dx = new int[] {0, -1, 0, 1};
   int[] dy = new int[] {1, 0, -1, 0};

   char[] possMoves = new char[] {'S', 'A', 'W', 'D'};
   int[] oppMoves = new int[] {2, 3, 0, 1};

   int x0, y0;
   int[] xF = new int[16], yF = new int[16];
   int[][] board = new int[4][4], targBoard = new int[4][4];
   int deep, minPrevIter;
   int step;
   HashSet<Integer> values = new HashSet<>();

    String result = "";



   private void swap(int x1, int y1, int x2, int y2) {
       int swapAssistant = board[x1][y1];
       int swapAssistant1 = board[x2][y2];

       board[x1][y1] = swapAssistant1;
       board[x2][y2] = swapAssistant;
   }

   public boolean canItSolve() {
       int count = 0, transPos = 0, value;
       int[] tester = new int[17];
       boolean canDoIt = false;

       for (int i = 0; i < 4; i++) {
           if (i % 2 == 0) {
               for (int j = 0; j < 4; j++) {
                   value = board[i][j];
                   if (value > 0) {
                       tester[count] = value;
                       count++;
                   }
               }
           } else
               for (int j = 3; j >= 0; j--) {
                   value = board[i][j];

                   if (value > 0) {
                       tester[count] = value;
                       count++;
                   }
               }
       }
       for (int i = 0; i <= count - 2; i++) {
           for (int j = i + 1; j <= count - 1; j++)
               if (tester[i] > tester[j]) transPos++;
       }

      if (transPos % 2 == 1) canDoIt = true;
      return canDoIt;
   }

   private int outlay() {
       int manhattan = 0;
       int value;
       int x;

       for (int i = 0; i < 4; i++)
           for (int j = 0; j < 4; j++) {
               value = board[i][j];

               if (value > 0 && value != targBoard[i][j]) {
                   x = Math.abs(i - yF[value]) + Math.abs(j - xF[value]);
                   manhattan += x;
               }
           }
        return manhattan;
   }

   private boolean search(int g, int prevMove, int x0, int y0) {
       int h = outlay();

       if (h == 0) return true;

       int s = g + h;
       if (s > deep) {
           if (minPrevIter > s) minPrevIter = s;
           return false;
       }

       int nx, ny;

       for (int i = 0; i < 4; i++) {
           if (oppMoves[i] != prevMove) {
               nx = x0 + dx[i];
               ny = y0 + dy[i];

               if (ny <= 3 && ny >= 0 && nx <=3 && nx >= 0) {
                   swap(y0, x0, ny, nx);
                   boolean res = search(g + 1, i, nx, ny);
                   swap(y0, x0, ny, nx);

                   if (res) {
                       result += possMoves[i];
                       step++;
                       return true;
                   }
               }
           }
       }
       return false;
   }

   private boolean idaS() {
       deep = outlay();
       boolean res = false;

       while (deep <= 50) {
           minPrevIter = Integer.MAX_VALUE;

           for (int i = 0; i < 4; i++)
               for (int j = 0; j < 4; j++) {
                   if (board[i][j] == 0) {
                       x0 = j;
                       y0 = i;
                   }
               }
           step = 0;
                res = search(0, -1, x0, y0);
               deep = minPrevIter;

               if (res) break;
       }
       return res;
   }

   public Fifteenth(ArrayList<Integer> digits) {
       for (int i = 0; i < 15; i++) {
           xF[i+1] = i % 4;
           yF[i+1] = i / 4;
       }

       xF[0] = 4;
       yF[0] = 4;

       values.addAll(digits);

           board[0][0] = digits.get(0);
           board[0][1] = digits.get(1);
           board[0][2] = digits.get(2);
           board[0][3] = digits.get(3);

           board[1][0] = digits.get(4);
           board[1][1] = digits.get(5);
           board[1][2] = digits.get(6);
           board[1][3] = digits.get(7);

           board[2][0] = digits.get(8);
           board[2][1] = digits.get(9);
           board[2][2] = digits.get(10);
           board[2][3] = digits.get(11);

           board[3][0] = digits.get(12);
           board[3][1] = digits.get(13);
           board[3][2] = digits.get(14);
           board[3][3] = digits.get(15);

           targBoard[0][0] = 1;
           targBoard[0][1] = 2;
           targBoard[0][2] = 3;
           targBoard[0][3] = 4;

           targBoard[1][0] = 5;
           targBoard[1][1] = 6;
           targBoard[1][2] = 7;
           targBoard[1][3] = 8;

           targBoard[2][0] = 9;
           targBoard[2][1] = 10;
           targBoard[2][2] = 11;
           targBoard[2][3] = 12;

           targBoard[3][0] = 13;
           targBoard[3][1] = 14;
           targBoard[3][2] = 15;
           targBoard[3][3] = 0;
   }

   public String solve() {
       HashSet<Integer> values1 = new HashSet<>();
       for (int i = 0; i < 16; i++)
           values1.add(i);

       if (!values.containsAll(values1) || values.size() != 16) return "incorrect format"; else

       if (!canItSolve()) return "It's not possible";
       else if (outlay() == 0) return "It's already solved!";
       else if (idaS())
           return "Solver successfully solved your problem. Way: " + new StringBuilder(result).reverse().toString() + " in " + step + " step(s)";
       else
           return "IDA* failed";
   }
}
