package com.ignitidev.unitesting.unittesting.business;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;

public class ListMockTest {
  List<String> mock = mock(List.class);

  @Test
  public void size_basic() {
    when(mock.size()).thenReturn(5);
    assertEquals(5, mock.size());
  }

  @Test
  public void returnDifferentValues() {
    when(mock.size()).thenReturn(5).thenReturn(10);
    assertEquals(5, mock.size());
    assertEquals(10, mock.size());
  }

  @Test
  public void returnWithParameters() {
    when(mock.get(0)).thenReturn("in28Minutes");
    assertEquals("in28Minutes", mock.get(0));
    assertEquals(null, mock.get(1));

  }

  @Test
  public void returnWithGenericParameters() {
    when(mock.get(anyInt())).thenReturn("in28Minutes");
    assertEquals("in28Minutes", mock.get(0));
    assertEquals("in28Minutes", mock.get(1));

  }

  @Test
  public void verificationBasics() {
    // SUT
    String value = mock.get(0);
    String value1 = mock.get(1);
    // Verify
    verify(mock).get(0);
    verify(mock, times(2)).get(anyInt());
    verify(mock, atLeast(1)).get(anyInt());
    verify(mock, atLeast(1)).get(anyInt());
    verify(mock, atMost(2)).get(anyInt());
    verify(mock, never()).get(2);
  }

  @Test
  public void argumentCapturing() {
    // SUT
    mock.add("SomeString");
    mock.add("SomeString1");

    // Verification
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    
    verify(mock,times(2)).add(captor.capture());
    
    List<String> allValues=captor.getAllValues();

    //assertEquals("SomeString", captor.getValue(0));
    assertEquals("SomeString", allValues.get(0));
    assertEquals("SomeString1", allValues.get(1));

  }
  
  @Test
  public void mocking() {
    ArrayList arrayListMock=mock(ArrayList.class);
    
    System.out.println(arrayListMock.get(0));//null
    System.out.println(arrayListMock.size());//0
    arrayListMock.add("addString1");
    arrayListMock.add("addString2");
    System.out.println(arrayListMock.size());//0
    when(arrayListMock.size()).thenReturn(5);
    System.out.println(arrayListMock.size());
  }

  
  @Test
  public void spying() {
    System.out.println("spying");
    ArrayList arrayListSpy=spy(ArrayList.class);
    
    arrayListSpy.add("addString");
    
    System.out.println(arrayListSpy.get(0));//null
    System.out.println(arrayListSpy.size());//1
    arrayListSpy.add("addString1");
    arrayListSpy.add("addString2");
    System.out.println(arrayListSpy.size());//3
    when(arrayListSpy.size()).thenReturn(5);
    System.out.println(arrayListSpy.size());//5
    arrayListSpy.add("addString3");
    System.out.println(arrayListSpy.size());//5

    verify(arrayListSpy).add("addString3");
    
  }
}
