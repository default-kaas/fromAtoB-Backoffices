package fromatobbackoffice;

import java.util.ArrayList;


public class Package {
  private int packageID;
  private String packageOwner;
  private String packageDeliver;
  private int startStation;
  private ArrayList<Integer> list = new ArrayList<Integer>();
  private int endStation;
  private  int packageStatus;
  
  public Package(){
      this.packageID = 10;
  }
  
  public String toString(){
      return packageID + "";
  }
  
  public String getPackageInfromation(){
      return null;
  }
  
  /*
  unsubscribePackage();???
  */
}
