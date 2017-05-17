package fromatobbackoffice;

public class Locker {
    private int lockerID;
    private int lockerStatus;
    private int lockerCode;
    private int stationID;
  //private ??? lockerLocation;

    public String toString(){
    return lockerID + " " + lockerStatus + " "+ lockerCode;
    }
	
    public int getLockerID() {
        return lockerID;
    }

    public void setLockerID(int lockerID) {
        this.lockerID = lockerID;
    }

    public int getLockerStatus() {
        return lockerStatus;
    }

    public void setLockerStatus(int lockerStatus) {
        this.lockerStatus = lockerStatus;
    }

    public int getLockerCode() {
        return lockerCode;
    }

    public void setLockerCode(int lockerCode) {
        this.lockerCode = lockerCode;
    }
    
    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    } 
}
