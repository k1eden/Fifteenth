package com.k1;

import java.util.*;

public class Fifteenth {
  private final int[] dx = new int[] {0, -1, 0, 1};
  private final int[] dy = new int[] {1, 0, -1, 0};

  private final char[] possMoves = new char[] {'S', 'A', 'W', 'D'};
  private final int[] oppMoves = new int[] {2, 3, 0, 1};

  private int x0, y0;
  private final int[] xF = new int[16];
    private final int[] yF = new int[16];
  private final int[][] board = new int[4][4];
    private final static int[][] targBoard = new int[4][4];
  private int deep, minPrevIter;
  int step;
  private final HashSet<Integer> values = new HashSet<>();
  private final List<Integer> sizeChecker = new ArrayList<>();
  private final StringBuilder result = new StringBuilder();
  private final ArrayList<Integer> dataAsList;



   private void swap(int x1, int y1, int x2, int y2) {
       int swapAssistant = board[x1][y1];
       int swapAssistant1 = board[x2][y2];

       board[x1][y1] = swapAssistant1;
       board[x2][y2] = swapAssistant;
   }

   public boolean canItSolve() {
       int sumChecker = 0;
       int zPlace = 0;

       for (int i = 0; i < 16; i++) {
           if (dataAsList.get(i) == 0) {
               zPlace = (i / 4) + 1;
               continue;
           }

           for (int j = i + 1; j < 16; j++) {
               if (dataAsList.get(j) == 0) continue;
               if (dataAsList.get(i) > dataAsList.get(j)) sumChecker++;
           }
       }

       sumChecker += zPlace;
       return (sumChecker % 2 == 0);
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

               if (ny <= 3 && ny >= 0 && nx <= 3 && nx >= 0) {
                   swap(y0, x0, ny, nx);
                   boolean res = search(g + 1, i, nx, ny);
                   swap(y0, x0, ny, nx);

                   if (res) {
                       result.append(possMoves[i]);
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
       final int MAX_TURNS = 80;

       while (deep <= MAX_TURNS) {
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

       dataAsList = digits;
       values.addAll(digits);
       sizeChecker.addAll(digits);

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

   public char[] solve() throws Exception {
       HashSet<Integer> values1 = new HashSet<>();
       for (int i = 0; i < 16; i++)
           values1.add(i);

       if (!values.containsAll(values1) || sizeChecker.size() != 16)
           throw new IllegalArgumentException("incorrect format");

       if (!canItSolve()) throw new Exception("It's not possible");
       else if (outlay() == 0) return new char[0];
       else if (idaS())
           return result.reverse().toString().toCharArray();
       else
           throw new Exception("IDA* failed");
   }
}
