package model;

import java.util.List;

public class Vehicle {
	private String vehicleNumber;
	private List<Parking> parkingList;
	
	public Vehicle(){
		super();
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public List<Parking> getParkingList() {
		return parkingList;
	}
	public void setParkingList(List<Parking> parkingList) {
		this.parkingList = parkingList;
	}

}
