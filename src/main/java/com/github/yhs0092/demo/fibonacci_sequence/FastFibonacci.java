package com.github.yhs0092.demo.fibonacci_sequence;

import java.math.BigInteger;

public class FastFibonacci {
  public BigInteger calc(long index) {
    BigInteger[][] temp = {
        {new BigInteger("1"), new BigInteger("1")},
        {new BigInteger("1"), new BigInteger("0")}
    };
    BigInteger[][] result = temp;

    int bit = 1;
    while (true) {
      if ((index & bit) != 0) {
        result = matrixMultiply(temp, result);
      }

      if (bit > index || bit == Long.MIN_VALUE) {
        break;
      }

      temp = matrixMultiply(temp, temp);

      bit = bit << 1;
    }

    return result[1][1];
  }

  /**
   * 2*2 matrix square
   */
  BigInteger[][] matrixMultiply(BigInteger[][] m1, BigInteger[][] m2) {
    BigInteger[][] result = new BigInteger[2][2];
    result[0][0] = m1[0][0].multiply(m2[0][0]).add(m1[0][1].multiply(m2[1][0]));
    result[0][1] = m1[0][0].multiply(m2[0][1]).add(m1[0][1].multiply(m2[1][1]));
    result[1][0] = m1[1][0].multiply(m2[0][0]).add(m1[1][1].multiply(m2[1][0]));
    result[1][1] = m1[1][0].multiply(m2[0][1]).add(m1[1][1].multiply(m2[1][1]));
    return result;
  }

  /**
   * 2*2 matrix add
   */
  BigInteger[][] matrixAdd(BigInteger[][] m1, BigInteger[][] m2) {
    BigInteger[][] result = new BigInteger[2][2];
    result[0][0] = m1[0][0].add(m2[0][0]);
    result[0][1] = m1[0][1].add(m2[0][1]);
    result[1][0] = m1[1][0].add(m2[1][0]);
    result[1][1] = m1[1][1].add(m2[1][1]);
    return result;
  }

  public static void main(String[] args) {
    FastFibonacci fastFibonacci = new FastFibonacci();
    for (int i = 0; i < 10; i++) {
      System.out.println(fastFibonacci.calc(i));
    }
  }
}
