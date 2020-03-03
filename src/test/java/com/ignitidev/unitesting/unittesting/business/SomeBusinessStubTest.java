package com.ignitidev.unitesting.unittesting.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.ignitidev.unitesting.unittesting.data.SomeDataService;
import com.ignitidev.unitesting.unittesting.data.SomeDataServiceImpl;

public class SomeBusinessStubTest {

  @Test
  public void calculateSumUsingSomeDataService_basic() {
    SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    when(dataServiceMock.retrievAllData()).thenReturn(new int[] { 1, 2, 3 });

    business.setSomeDataService(dataServiceMock);

    int actualResult = business.calculateSumUsingSomeDataService();
    int expectedResult = 6;

    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void calculateSumUsingSomeDataService_empty() {
    SomeBusinessImpl business = new SomeBusinessImpl();

    SomeDataService dataServiceMock = mock(SomeDataService.class);

    when(dataServiceMock.retrievAllData()).thenReturn(new int[] { 0 });

    business.setSomeDataService(dataServiceMock);

    int actualResult = business.calculateSumUsingSomeDataService();
    int expectedResult = 0;

    assertEquals(expectedResult, actualResult);

  }

  @Test
  public void calculateSumUsingSomeDataService_oneValue() {
    SomeBusinessImpl business = new SomeBusinessImpl();

    SomeDataService dataServiceMock = mock(SomeDataService.class);

    when(dataServiceMock.retrievAllData()).thenReturn(new int[] { 5 });

    business.setSomeDataService(dataServiceMock);

    int actualResult = business.calculateSumUsingSomeDataService();
    int expectedResult = 5;

    assertEquals(expectedResult, actualResult);

  }

}
