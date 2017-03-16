/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WestminsterCarParkSystem;

import java.io.Serializable;

/**
 *
 * @author lakshanG
 */
public class Car extends Vehicle implements Serializable {

    private int noOfDoors;
    private String carColor;

    /**
     * @return the noOfDoors
     */
    public int getNoOfDoors() {
        return noOfDoors;
    }

    /**
     * @param noOfDoors the noOfDoors to set
     */
    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    /**
     * @return the carColor
     */
    public String getCarColor() {
        return carColor;
    }

    /**
     * @param carColor the carColor to set
     */
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Car(String vehicle_ID, String vehicle_Brand, String vehicle_Type, int noOfDoors, String carColor) {
        super(vehicle_ID, vehicle_Brand, vehicle_Type);
        this.noOfDoors = noOfDoors;
        this.carColor = carColor;

    }
}
