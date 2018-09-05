package com.github.yhs0092.demo.fibonacci_sequence;

import org.junit.Test;

public class PerformanceCompare {

  public static final long TEST_SCALE = 100_0000;

  @Test
  public void test() {
    FastFibonacci fastFibonacci = new FastFibonacci();
    FibonacciControlGroup fibonacciControlGroup = new FibonacciControlGroup();

    System.out.println("fastFibonacci");
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10; ++i) {
      fastFibonacci.calc(TEST_SCALE);
    }
    long end = System.currentTimeMillis();
    System.out.println("timeCost = " + (end - start));
    System.out.println("fastFibonacci");

    System.out.println("fibonacciControlGroup");
    start = System.currentTimeMillis();
    for (int i = 0; i < 10; ++i) {
      fibonacciControlGroup.calc(TEST_SCALE);
    }
    end = System.currentTimeMillis();
    System.out.println("timeCost = " + (end - start));
    System.out.println("fibonacciControlGroup");
  }
}
