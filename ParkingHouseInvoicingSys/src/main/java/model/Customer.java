package model;

import java.util.List;

public class Customer {

	private String nameLastname;
	private String phoneNumber;
	private String isic;
	private boolean isPremium;
	private List<Vehicle> vehicleList;
	public Customer(){
		super();
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	public String getNameLastname() {
		return nameLastname;
	}
	public void setNameLastname(String nameLastname) {
		this.nameLastname = nameLastname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getIsic() {
		return isic;
	}
	public void setIsic(String isic) {
		this.isic = isic;
	}
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

}
