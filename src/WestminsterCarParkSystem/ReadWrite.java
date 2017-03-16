/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WestminsterCarParkSystem;

import static WestminsterCarParkSystem.CarParkManager.vArray;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author LakshanG <lakshan.g at your.org>
 */
public class ReadWrite {

    public void writeData() {
        try {
            File f = new File(System.getProperty("user.home") + "/Desktop");//gets to the users desktop
            File f2 = new File(f, "WestminsterCarParkDetails.txt");//creates a text file on the desktop
            f2.createNewFile();//creates a new file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f2))) {//uses buffered writer to write data line by line

                for (Vehicle v : vArray) {
                    bw.write(v.getEntryDate() + " ");
                    bw.write(v.getVehicle_ID() + " ");
                    bw.write(v.getEntryTime() + " ");

                    bw.write(v.getVehicle_Type() + " ");
                    bw.newLine();
                }
                bw.flush();
                bw.close();

            }

        } catch (Exception e) {
            System.err.println("!! File Error ");
        }

    }

}
