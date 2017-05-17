package fromatobbackoffice;

public class Locker {
    private int id;
    private int stationID;
    private int locker_number;
    private int locker_code;
    private int occupied;

    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getStationID() {
        return stationID;
    }
    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public int getLocker_number() {
        return locker_number;
    }
    public void setLocker_number(int locker_number) {
        this.locker_number = locker_number;
    }

    public int getLocker_code() {
        return locker_code;
    }
    public void setLocker_code(int locker_code) {
        this.locker_code = locker_code;
    }

    public int getOccupied() {
        return occupied;
    }
    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }
    
}
