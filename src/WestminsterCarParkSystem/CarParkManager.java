/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WestminsterCarParkSystem;

import java.util.ArrayList;

/**
 *
 * @author lakshanG
 */
public interface CarParkManager {

    static final int SLOTCAPACITY = 20;
    static ArrayList<Vehicle> vArray = new ArrayList<>();

    void addVehicle(Vehicle obj); //add vehicle to free slots available

    void deleteVehicle(String vehicleID); //delete a parked vehicle

    void vehicleDetails();//print general list of vehicles in the park

    void printStats(); // print the required statistics (Percentages, Longest/Last Parked)

    void displaySpecifiedDayList(); //searches for a specific day and display

    void displayCharge(Vehicle obj, long leaveTime); //charges for the parking

}
