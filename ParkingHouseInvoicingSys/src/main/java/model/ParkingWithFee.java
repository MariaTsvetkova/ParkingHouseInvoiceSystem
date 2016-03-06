package model;

import java.math.BigDecimal;

public class ParkingWithFee extends Parking {
	private BigDecimal fee;
	private String vehicleNumber;
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	public ParkingWithFee(){
		super();
	}
	

}
