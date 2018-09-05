package com.github.yhs0092.demo.fibonacci_sequence;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class FastFibonacciTest {

  @Test
  public void calc() {
    FibonacciControlGroup fibonacciControlGroup = new FibonacciControlGroup();
    FastFibonacci fastFibonacci = new FastFibonacci();
    for (long i = 0; ; ++i) {
      long start = System.currentTimeMillis();
      BigInteger expect = fibonacciControlGroup.calc(i);
      BigInteger result = fastFibonacci.calc(i);
      Assert.assertEquals("i = " + i, expect, result);

//      if (System.currentTimeMillis() - start > 10_000 || result.compareTo(new BigInteger("1000000000")) > 0) {
      long cost = System.currentTimeMillis() - start;
      System.out.println(cost);
      if (cost > 10) {
        break;
      }
    }
  }

  @Test
  public void matrixMultiply() {
    FastFibonacci fastFibonacci = new FastFibonacci();
    BigInteger[][] param = {
        {new BigInteger("1"), new BigInteger("2")},
        {new BigInteger("3"), new BigInteger("4")}
    };
    BigInteger[][] result = fastFibonacci.matrixMultiply(param, param);
    Assert.assertEquals(7, result[0][0].intValue());
    Assert.assertEquals(10, result[0][1].intValue());
    Assert.assertEquals(15, result[1][0].intValue());
    Assert.assertEquals(22, result[1][1].intValue());
  }

  @Test
  public void matrixAdd() {
    FastFibonacci fastFibonacci = new FastFibonacci();
    BigInteger[][] m1 = {
        {new BigInteger("1"), new BigInteger("2")},
        {new BigInteger("3"), new BigInteger("4")}
    };
    BigInteger[][] m2 = {
        {new BigInteger("10"), new BigInteger("20")},
        {new BigInteger("30"), new BigInteger("40")}
    };
    BigInteger[][] result = fastFibonacci.matrixAdd(m1, m2);
    Assert.assertEquals(11, result[0][0].intValue());
    Assert.assertEquals(22, result[0][1].intValue());
    Assert.assertEquals(33, result[1][0].intValue());
    Assert.assertEquals(44, result[1][1].intValue());
  }
}