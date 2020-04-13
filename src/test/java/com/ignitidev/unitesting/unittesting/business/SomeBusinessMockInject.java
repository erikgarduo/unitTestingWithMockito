package com.ignitidev.unitesting.unittesting.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ignitidev.unitesting.unittesting.data.SomeDataService;
import com.ignitidev.unitesting.unittesting.data.SomeDataServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockInject {

  @InjectMocks
  SomeBusinessImpl business;

  @Mock
  SomeDataService dataServiceMock;

  @Before
  public void before() {
    business.setSomeDataService(dataServiceMock);
  }

  @Test
  public void calculateSumUsingSomeDataService_basic() {
    when(dataServiceMock.retrievAllData()).thenReturn(new int[] { 1, 2, 3 });
    assertEquals(6, business.calculateSumUsingSomeDataService());
  } 

  @Test
  public void calculateSumUsingSomeDataService_empty() {
    when(dataServiceMock.retrievAllData()).thenReturn(new int[] { 0 });
    assertEquals(0, business.calculateSumUsingSomeDataService());
  }

  @Test
  public void calculateSumUsingSomeDataService_oneValue() {
    when(dataServiceMock.retrievAllData()).thenReturn(new int[] { 5 });
    assertEquals(5, business.calculateSumUsingSomeDataService());
  }

}
