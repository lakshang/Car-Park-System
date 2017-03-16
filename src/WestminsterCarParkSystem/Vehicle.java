/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WestminsterCarParkSystem;

/**
 *
 * @author lakshanG
 */
public abstract class Vehicle {

    private String vehicle_ID;
    private String vehicle_Brand;
    private String vehicle_Type;
    private String entryDate;
    private String entryTime;
    private long entry;

    /**
     * @return the vehicle_ID
     */
    public String getVehicle_ID() {
        return vehicle_ID;
    }

    /**
     * @param vehicle_ID the vehicle_ID to set
     */
    public void setVehicle_ID(String vehicle_ID) {
        this.vehicle_ID = vehicle_ID;
    }

    /**
     * @return the vehicle_Brand
     */
    public String getVehicle_Brand() {
        return vehicle_Brand;
    }

    /**
     * @param vehicle_Brand the vehicle_Brand to set
     */
    public void setVehicle_Brand(String vehicle_Brand) {
        this.vehicle_Brand = vehicle_Brand;
    }

    /**
     * @return the vehicle_Type
     */
    public String getVehicle_Type() {
        return vehicle_Type;
    }

    /**
     * @param vehicle_Type the vehicle_Type to set
     */
    public void setVehicle_Type(String vehicle_Type) {
        this.vehicle_Type = vehicle_Type;
    }

    /**
     * @return the entryDate
     */
    public String getEntryDate() {

        return entryDate;
    }

    public void setEntryDate() {
        String[] time = DateTime.displayTime();
        this.entryDate = time[0];
    }

    /**
     * @return the entryTime
     */
    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime() {
        String[] time = DateTime.displayTime();
        this.entryTime = time[1];

    }

    public long getEntry() {
        return entry;
    }

    public void setEntry() {
        this.entry = entry = DateTime.getCurrentTime();
    }

    public Vehicle(String vehicle_ID, String vehicle_Brand, String vehicle_Type) {
        this.vehicle_ID = vehicle_ID;
        this.vehicle_Brand = vehicle_Brand;
        this.vehicle_Type = vehicle_Type;
        setEntry();
        setEntryTime();
        setEntryDate();
        
    }

  
}
