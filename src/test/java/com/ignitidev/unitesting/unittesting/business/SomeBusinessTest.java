package com.ignitidev.unitesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBusinessTest {

  @Test
  public void calculateSum_basic() {
    SomeBusinessImpl business = new SomeBusinessImpl();

    int actualResult = business.calculateSum(new int[] { 1, 2, 5 });
    int expectedResult = 8;

    assertEquals(expectedResult, actualResult);

  }
  
  @Test
  public void calculateSum_empty() {
    SomeBusinessImpl business = new SomeBusinessImpl();

    int actualResult = business.calculateSum(new int[] {});
    int expectedResult = 0;

    assertEquals(expectedResult, actualResult);

  }

}
