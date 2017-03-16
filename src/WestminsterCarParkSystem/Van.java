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
public class Van extends Vehicle{
    
    private int cargoVolume;

    /**
     * @return the cargoVolume
     */
    public int getCargoVolume() {
        return cargoVolume;
    }

    /**
     * @param cargoVolume the cargoVolume to set
     */
    public void setCargoVolume(int cargoVolume) {
        this.cargoVolume = cargoVolume;
    }
    
    
    public Van(String vehicle_ID, String vehicle_Brand, String vehicle_Type, int cargoVolume){
    super(vehicle_ID, vehicle_Brand, vehicle_Type);
    this.cargoVolume=cargoVolume;
    
    }
    
}
