package com.github.yhs0092.demo.fibonacci_sequence;

import java.math.BigInteger;

public class FibonacciControlGroup {
  public BigInteger calc(long index) {
    BigInteger next = new BigInteger("1");
    BigInteger cur = new BigInteger("0");
    BigInteger temp = cur;
    for (int i = 0; i < index; i++) {
      cur = next;
      next = cur.add(temp);
      temp = cur;
    }
    return cur;
  }

  public static void main(String[] args) {
    FibonacciControlGroup fibonacciControlGroup = new FibonacciControlGroup();
    for (int i = 0; i < 10; ++i) {
      System.out.println(fibonacciControlGroup.calc(i));
    }
  }
}
