package org.main;

import org.Store.Store;
import org.taxi.Taxi;

import java.util.Scanner;

public class Main {
    public  static  Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws CloneNotSupportedException {
        while(true){
            System.out.println("1.Booking\n2.Display");
            System.out.println("Enter your choice");

            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    book();
                    break;
                case 2:
                    displayTaxi();
                    break;
            }

        }
    }

    private static void displayTaxi() {
        for(Taxi t:Store.history){
            System.out.println(t.toString());
        }
    }

    private static void book() throws CloneNotSupportedException {
        System.out.println("enter pick up point");
        char pickupPoint=sc.next().charAt(0);
        System.out.println("enter drop up point");
        char dropPoint=sc.next().charAt(0);
        System.out.println("enter a pickup time");
        int pickUpTime=sc.nextInt();
        Taxi t1=null;
        if(Store.taxis.size()<Store.taxiLimit) {
            t1 = new Taxi();
            System.out.println(t1.getDropTime()+ " "+ t1.getCurrentLocation()+ " "+t1.getEarnings());
            Store.taxis.add(t1);
        }
        int min =Integer.MAX_VALUE;
        Taxi availableTaxi=t1;
        long minEarn =Integer.MAX_VALUE;
        for(Taxi t:Store.taxis){
            if(t.getDropTime()<=pickUpTime && Math.abs(t.getCurrentLocation()-pickupPoint)<=min && t.getEarnings()<minEarn ){
                availableTaxi=t;
                min=Math.abs(t.getCurrentLocation()-pickupPoint);
                minEarn=t.getEarnings();
            }
        }
        if(availableTaxi==null){
            System.out.println("no taxi available");
            return;
        }

        availableTaxi.setTaxiId(Store.taxis.indexOf(availableTaxi)+1);
        availableTaxi.setCustId(Store.custId++);
        availableTaxi.setEarnings(availableTaxi.getEarnings()+200*Math.abs(pickupPoint-dropPoint));
        availableTaxi.setPickupPoint(pickupPoint);
        availableTaxi.setDropPoint(dropPoint);
        availableTaxi.setCurrentLocation(dropPoint);
        availableTaxi.setPickupTime(pickUpTime);
        availableTaxi.setDropTime(pickUpTime+Math.abs(pickupPoint-dropPoint));
        Store.history.add(((Taxi)availableTaxi.clone()));
        System.out.println("taxi no:"+ availableTaxi.getTaxiId()+ "is allocated");
    }
}
