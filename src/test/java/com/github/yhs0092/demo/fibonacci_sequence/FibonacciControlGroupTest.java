package com.github.yhs0092.demo.fibonacci_sequence;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciControlGroupTest {
  @Test
  public void calc() {
    FibonacciControlGroup fibonacciControlGroup = new FibonacciControlGroup();
    int[] expectResult = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233};
    for (int i = 0; i < expectResult.length; i++) {
      Assert.assertEquals(expectResult[i], fibonacciControlGroup.calc(i).intValue());
    }
  }
}