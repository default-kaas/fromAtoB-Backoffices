package fromatobbackoffice;

public class Locker {
    private int lockerID;
    private int lockerStatus;
    private int lockerCode;
  //private ??? lockerLocation;
    
    public Locker(){
		
	}
	
	public String toString(){
		return lockerID + " " + lockerStatus + " "+ lockerCode;
	}
	
	public int getLockerInformation(){
		return lockerID + lockerStatus + lockerCode;
	}
}
