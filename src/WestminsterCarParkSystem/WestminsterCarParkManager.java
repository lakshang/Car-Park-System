/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WestminsterCarParkSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author lakshanG
 */
public class WestminsterCarParkManager implements CarParkManager {

    static int freeSlots = 20;

    @Override

    public void addVehicle(Vehicle obj) {//Add vehicle to the car park
        if (obj.getVehicle_Type().equalsIgnoreCase("Van")) { //checks if the vehicle is a van
            if (freeSlots >= 2) {
                vArray.add(obj);
                freeSlots -= 2;
                System.out.println("Currently Available Parking Slots : " + freeSlots);
            } else {
                System.err.println("No Parking Slots Available");
            }
            System.out.println("__________");
        } else if (freeSlots > 0) {
            vArray.add(obj);
            freeSlots -= 1;
            System.out.println("***************************************");
            System.out.println("Available Parking Slots : " + freeSlots);
            System.out.println("***************************************");
            System.out.println("");

            System.out.println("*** Operation Sucessful ! ***");
            System.out.println("");

        } else {
            System.out.println("");
            System.out.println("***************************************");
            System.err.println("No Parking Slots Available");
            System.out.println("***************************************");
        }

    }

    public void menuaddVehicle() {
        System.out.println("*** Add Vehicle Menu ***");

        System.out.print("Enter Vehicle ID :");
        String vehicle_ID = input.nextLine();

        System.out.print("Enter Vehicle Brand :");
        String vehicle_Brand = input.nextLine();

        System.out.print("Enter Vehicle Type :");
        String vehicle_Type = input.nextLine().toLowerCase();

        switch (vehicle_Type) {

            case "car":
                try {
                    System.out.print("Enter number of Doors :");

                    String noDoors = input.nextLine();
                    int noOfDoors = Integer.parseInt(noDoors);

                    System.out.print("Enter car Color :");
                    String carColor = input.nextLine();

                    Car carObj = new Car(vehicle_ID, vehicle_Brand, vehicle_Type, noOfDoors, carColor);
                    obj.addVehicle(carObj);
                } catch (NumberFormatException e) {
                    System.err.println("**** Invalid Input ****");
                    menuaddVehicle();
                }

                break;
            case "van":
                try {
                    System.out.print("Enter Cargo Volume :");
                    String scargoVolume = input.nextLine();

                    int cargoVolume = Integer.parseInt(scargoVolume);

                    Van vanObj = new Van(vehicle_ID, vehicle_Brand, vehicle_Type, cargoVolume);
                    obj.addVehicle(vanObj);
                } catch (NumberFormatException e) {
                    System.err.println("**** Invalid Input ****");
                    menuaddVehicle();

                }

                break;

            case "motorbike":
                try {
                    System.out.print("Enter Engine Size :");
                    String vsizeOfEngine = input.nextLine();

                    int sizeOfEngine = Integer.parseInt(vsizeOfEngine);

                    Motorbike motoObj = new Motorbike(vehicle_ID, vehicle_Brand, vehicle_Type, sizeOfEngine);
                    obj.addVehicle(motoObj);
                } catch (NumberFormatException e) {
                    System.err.println("**** Invalid Input ****");
                    menuaddVehicle();
                }

                break;
            default:
                System.err.println("*** Invalid Input ! ***");
                menuaddVehicle();
                break;

        }

    }

    @Override

    public void deleteVehicle(String vehicleID) {//delete vehicle from car park
        boolean check = false;
        Iterator<Vehicle> it = vArray.iterator(); //iterates through the object array
        while (it.hasNext()) {
            Vehicle v = it.next();
            if (v.getVehicle_ID().equalsIgnoreCase(vehicleID)) {
                it.remove();
                check = true;
                long leaveTime = DateTime.getCurrentTime();
                System.out.println(v.getVehicle_ID() + " | " + v.getVehicle_Type());//display vehicleID & vehicleType
                String returnTimeArr[] = DateTime.displayTime();//get the time and date
                System.out.println(returnTimeArr[1] + " | " + returnTimeArr[0]);//display time and date
                if (v.getVehicle_Type().equalsIgnoreCase("van")) {
                    freeSlots += 2;
                } else {
                    freeSlots += 1;
                }
                displayCharge(v, leaveTime);//Calculates the charge
            }
            if (check == false) {
                System.err.println("No such vehicle exsists");

            }
        }

        //vArray.remove(obj);
        System.out.println("***************************************");
        System.out.println("Available Parking Slots: " + freeSlots);
        System.out.println("***************************************");

    }

    public void menudeleteVehicle() {
        System.out.println("*** Delete Vehicle Menu ***");

        System.out.print("Enter Vehicle ID :");
        String vehicleID = input.nextLine();

        //check whether theres a vehicle;
        obj.deleteVehicle(vehicleID);
        obj.vehicleDetails();

        System.out.println("*** Operation Sucessful ! ***");

    }

    @Override
    public void vehicleDetails() { //print the list of vehicles currently parked in chronological order
        ArrayList<Vehicle> arr = new ArrayList<>();

    //    if (!(vArray.isEmpty())) {

            for (int i = 0; i < vArray.size(); i++) {
                arr.add(vArray.get(i));//adds to new array

            }
            for (int i = arr.size() - 1; i >= 0; i--) {//gives out the last object first
                System.out.println("***************************************************");
                System.out.println("Vehicle ID          :" + arr.get(i).getVehicle_ID());
                System.out.println("Vehicle Entry Time  :" + arr.get(i).getEntryTime());
                System.out.println("Vehicle Type        :" + arr.get(i).getVehicle_Type());

            }

            System.out.println("*** Operation Sucessful ! ***");

      //  } else {
           // System.err.println("No vehicle currently parked");
       // }
    }

    @Override
    public void printStats() { //prints the statistics
        int countC = 0;
        int countV = 0;
        int countMB = 0;
        int tot = 0;

        double perCar, perVan, perMotorbike;
        if (!vArray.isEmpty()) {
            for (Vehicle obj1 : vArray) {
                switch (obj1.getVehicle_Type()) {
                    case "car":
                        countC += 1;
                        tot++;
                        break;
                    case "van":
                        countV += 1;
                        tot++;
                        break;
                    case "motorbike":
                        countMB += 1;
                        tot++;
                        break;
                    default:
                        break;
                }
            }

            // System.out.println(countC);
            // System.out.println(countV);
            //System.out.println(countMB);
            //  tot=countC+countV+countMB;
            // System.out.println(tot);
            //perCar = (countC / tot);
            //System.out.println(perCar * 100);
            //System.out.println(tot);
            //System.out.println(countV/tot);
            //* 100;
            System.out.println("***************************************");//calculation of percentage
            perCar = (((float) countC / (float) tot));
            perVan = ((float) countV / (float) tot);
            perMotorbike = ((float) countMB / (float) tot);
            System.out.println("Percentage of Cars :" + perCar * 100.0);
            System.out.println("Percentage of Vans :" + perVan * 100.0);
            System.out.println("Percentage of MotorBikes :" + perMotorbike * 100);

            System.out.println("***************************************");
            System.out.println(" Vehicle Details ");
            System.out.print("Longest Parked Vehicle :");
            displayStatsLongest(vArray.get(0));
            //System.out.print("---------------------------------------");

            System.out.print("Last Parked Vehicle :");
            displayStatsLongest(vArray.get(vArray.size() - 1));
            //System.out.println("---------------------------------------");

            System.out.println("*** Operation Sucessful ! ***");

        } else {
            System.err.println("**No vehicles are currently parked**");
        }

    }

    @Override
    public void displaySpecifiedDayList() { //search for a specific date
        ArrayList<String> readData = new ArrayList<>(20);
        try {
            File f = new File(System.getProperty("user.home") + "/Desktop/WestminsterCarParkDetails.txt");//gets the stored file from the desktop
            BufferedReader br = new BufferedReader(new FileReader(f));//uses buffered reader
            String line;
            while ((line = br.readLine()) != null) {//reads until not null
                readData.add(line);
            }
            br.close();

        } catch (IOException e) {
            System.out.println(" File not Found ");
        }
        try {
            System.out.println("*** Search For Vehicle ***");

            System.out.print("Enter Day : ");
            String dateS = input.nextLine();
            int date = Integer.parseInt(dateS);
            if (date <= 31) {
                System.out.print("Enter Month : ");
                String monthS = input.nextLine();
                int month = Integer.parseInt(monthS);
                if (month <= 12) {
                    System.out.print("Enter Year : ");
                    String yearS = input.nextLine();
                    int year = Integer.parseInt(yearS);

                    String format = dateS + monthS + yearS;
                    boolean k = false;
                    for (String check : readData) {
                        String dateArr[] = check.split("\\s");

                        int compre = check.compareToIgnoreCase(dateArr[0]);
                        if (dateArr[0].equals(format)) {
                            System.out.print(dateArr[1] + " ");
                            System.out.print(dateArr[2] + " ");
                            System.out.print(dateArr[3] + " ");
                            System.out.println();
                            k = true;

                        }
                    }
                    System.out.println("*** Operation Sucessful ! ***");
                    if (k == false) {
                        System.out.println("No vehicles");
                    }
                } else {
                    System.err.println("*** Invalid Input ***");
                }

            } else {
                System.err.println("*** Invalid Input ***");
            }

        } catch (Exception e) {
            System.err.println("*** Invalid Input ***");
        }
    }

    @Override
    public void displayCharge(Vehicle obj, long leaveTime) {

        int perHr = 9;
        double chargeH, chargeM, chargePM;
        int arr[] = DateTime.calTime(obj.getEntry(), leaveTime); //gets the duration
        DecimalFormat timeFormat = new DecimalFormat("#.00");
        if (arr[1] < 3) {
            chargePM = (3 / 60d);
            chargeH = (int) (arr[1] * 3);
            chargeM = (arr[0] * chargePM);
        } else {
            chargePM = (1 / 60d);
            int extraHrs = (arr[1] - 3);
            chargeH = (perHr + extraHrs * 1);
            chargeM = (arr[0] * chargePM);
        }
        double charge = (chargeH + chargeM);
        System.out.println("Total Charge: " + timeFormat.format(charge));
        System.out.println("*** Operation Sucessful ! ***");
    } //To change body of generated methods, choose Tools | Templates.

    

    public void displayStatsLongest(Vehicle obj) {
        System.out.print("\n" + obj.getVehicle_ID() + "    ");
        System.out.print(obj.getVehicle_Type() + "    ");
        System.out.print(obj.getEntryTime() + "    ");
        System.out.print(obj.getEntryDate() + "    ");

    }

    static Scanner input = new Scanner(System.in);
    static CarParkManager obj = new WestminsterCarParkManager();

    public void mainMenu() {
        boolean token = true;
        while (token) {

            System.out.println("******** WELCOME TO WESTMINSTER CAR PARK SYSTEM ********");
            System.out.println("");
            System.out.println("********************************************************");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Delete Vehicle");
            System.out.println("3. Vehicle Details");
            System.out.println("4. Parking Statistics");
            System.out.println("5. Search");
            System.out.println("6. Exit");
            System.out.println("********************************************************");

            System.out.print("Press to Proceed : ");
            String consoleInput = input.nextLine();

            switch (consoleInput) {
                case "1":
                    menuaddVehicle();
                    ReadWrite writeData = new ReadWrite();
                    writeData.writeData();

                    break;
                case "2":
                    menudeleteVehicle();

                    break;
                case "3":
                    obj.vehicleDetails();

                    break;
                case "4":
                    obj.printStats();

                    break;
                case "5":
                    obj.displaySpecifiedDayList();
                    break;

                case "6":
                    System.exit(0);
                    break;
                default:
                    System.err.println("*** Invalid Input ! ***");
                    mainMenu();
                    break;
            }

        }

    }

    public static void main(String[] args) {
        WestminsterCarParkManager m = new WestminsterCarParkManager();
        m.mainMenu();

    }
}
