package model;

import java.util.Date;

public class Parking {
	private Date startDate;
	private Date endDate;
	private String parkingHouse;
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getParkingHouse() {
		return parkingHouse;
	}

	public void setParkingHouse(String parkingHouse) {
		this.parkingHouse = parkingHouse;
	}

	public Parking(){
		super();
	}

}
