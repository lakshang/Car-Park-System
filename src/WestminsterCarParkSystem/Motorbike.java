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
public class Motorbike extends Vehicle{
    
    private int sizeOfEngine;

    /**
     * @return the sizeOfEngine
     */
    public int getSizeOfEngine() {
        return sizeOfEngine;
    }

    /**
     * @param sizeOfEngine the sizeOfEngine to set
     */
    public void setSizeOfEngine(int sizeOfEngine) {
        this.sizeOfEngine = sizeOfEngine;
    }
    
    
    public Motorbike (String vehcile_ID, String vehicle_Brand, String vehicle_Type, int sizeOfEngine){
    super(vehcile_ID, vehicle_Brand, vehicle_Type);
    this.sizeOfEngine = sizeOfEngine;
    
    }
    
}
