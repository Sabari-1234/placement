package org.taxi;

import org.Store.Store;

public class Taxi implements Cloneable {
        char currentLocation='A';
        char pickupPoint;
        char dropPoint;
        int taxiId;
        int custId;
        long earnings;
        int pickupTime;
        int dropTime;

        public int getPickupTime() {
                return pickupTime;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
                return super.clone();
        }

        public void setPickupTime(int pickupTime) {
                this.pickupTime = pickupTime;
        }

        public int getDropTime() {
                return dropTime;
        }

        public void setDropTime(int dropTime) {
                this.dropTime = dropTime;
        }



        public char getCurrentLocation() {
                return currentLocation;
        }

        public void setCurrentLocation(char currentLocation) {
                this.currentLocation = currentLocation;
        }

        public char getPickupPoint() {
                return pickupPoint;
        }

        public void setPickupPoint(char pickupPoint) {
                this.pickupPoint = pickupPoint;
        }

        public char getDropPoint() {
                return dropPoint;
        }

        public void setDropPoint(char dropPoint) {
                this.dropPoint = dropPoint;
        }

        public int getTaxiId() {
                return taxiId;
        }

        public void setTaxiId(int taxiId) {
                this.taxiId = taxiId;
        }

        public int getCustId() {
                return custId;
        }

        public void setCustId(int custId) {
                this.custId = custId;
        }

        public long getEarnings() {
                return earnings;
        }

        public void setEarnings(long earnings) {
                this.earnings = earnings;
        }

        @Override
        public String toString() {
                return "current Location:"+this.currentLocation+"\nTaxi Id:"+ this.taxiId+"\nCustId:"+ this.custId +"\nearnings:"+ this.earnings+"\npickupPoint:"+this.pickupPoint+"\ndropPoint:"+this.dropPoint+"\npicupTime"+this.pickupTime+"\ndropTime:"+this.dropTime ;
        }
}
