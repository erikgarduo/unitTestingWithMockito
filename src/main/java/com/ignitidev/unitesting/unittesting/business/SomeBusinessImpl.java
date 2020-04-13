package com.ignitidev.unitesting.unittesting.business;

import com.ignitidev.unitesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

  
  SomeDataService someDataService;
  
  
  public void setSomeDataService(SomeDataService someDataService) {
    this.someDataService = someDataService;
  }

  public int calculateSum(int [] data) {
    int sum =0;
    for (int value:data) {
      sum+=value;
    }
    return sum;
  }
  
  public int calculateSumUsingSomeDataService() {
    int sum =0;
    int[] data =someDataService.retrievAllData();
    for (int value:data) {
      sum+=value;
    }
    
    //Some dataservice.store()sum
    return sum;
  }
}
