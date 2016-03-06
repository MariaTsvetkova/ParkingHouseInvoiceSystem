package temp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Customer;
import model.Parking;
import model.Vehicle;

public class TempDatas {

	public static List<Customer> getCustomersList() {

		Customer cus1 = new Customer();
		cus1.setNameLastname("Ivan Ivanov");
		cus1.setPhoneNumber("6337788");
		cus1.setIsic("4891919119");

		List<Vehicle> vehicleList1 = new ArrayList<>();
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleNumber("bb214");

		List<Parking> parkingList1 = new ArrayList<>();
		Parking parking1 = new Parking();
		parking1.setParkingHouse("ParkingHouse");
		Date startDate1 = new Date();
		Date endDate1 = new Date();
		endDate1.setTime(endDate1.getTime() + 60 * 60 * 1000 * 4);
		parking1.setStartDate(startDate1);
		parking1.setEndDate(endDate1);

		parkingList1.add(parking1);
		vehicle1.setParkingList(parkingList1);
		vehicleList1.add(vehicle1);

		cus1.setVehicleList(vehicleList1);
		///////////////////////////////////////////////////
		Customer cus2 = new Customer();
		cus2.setNameLastname("Petor Petrov");
		cus2.setPhoneNumber("655555");
		cus2.setIsic("33302100225");

		List<Vehicle> vehicleList2 = new ArrayList<>();
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleNumber("ss222");

		List<Parking> parkingList2 = new ArrayList<>();
		Parking parking2 = new Parking();
		parking2.setParkingHouse("ParkingHouse");

		Date endDate2 = new Date();
		endDate2.setTime(endDate2.getTime() + 60 * 60 * 1000 * 3);
		parking2.setStartDate(startDate1);
		parking2.setEndDate(endDate2);

		parkingList2.add(parking1);
		parkingList2.add(parking2);
		vehicle2.setParkingList(parkingList2);

		vehicleList2.add(vehicle1);
		vehicleList2.add(vehicle2);

		cus2.setVehicleList(vehicleList2);

		///////////////////////////////////////////////////
		Customer cus3 = new Customer();
		cus3.setNameLastname("Sidor Sidorov");
		cus3.setPhoneNumber("6545622");
		cus3.setIsic("3456100225");
		cus3.setPremium(true);

		List<Vehicle> vehicleList3 = new ArrayList<>();
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setVehicleNumber("df445");

		List<Parking> parkingList3 = new ArrayList<>();
		Parking parking3 = new Parking();
		parking3.setParkingHouse("ParkingHouse");

		Date endDate3 = new Date();
		endDate3.setTime(startDate1.getTime() + 60 * 60 * 1000 * 2);
		parking3.setStartDate(startDate1);
		parking3.setEndDate(endDate3);

		parkingList3.add(parking1);
		parkingList3.add(parking2);
		parkingList3.add(parking3);
		vehicle3.setParkingList(parkingList3);

		vehicleList3.add(vehicle3);

		cus3.setVehicleList(vehicleList3);

		List<Customer> customerList = new ArrayList<>();
		customerList.add(cus1);
		customerList.add(cus2);
		customerList.add(cus3);
		return customerList;
	}

	public static Customer getCustomer(String isic) {
		List<Customer> customerList = getCustomersList();
		for (Customer customer : customerList) {
			if (customer.getIsic().equals(isic)) {
				return customer;
			}
		}
		return null;
	}

	public static List<Vehicle> getVehicleListByMonth(Customer customer, int month) {

		List<Vehicle> newVehicleList = new ArrayList<>();
		for (Vehicle vehicle : customer.getVehicleList()) {
			List<Parking> newparkingList = new ArrayList<>();
			for (Parking parking : vehicle.getParkingList()) {
				System.out.println("start month = " + parking.getStartDate().getMonth());
				Calendar startCalendar = Calendar.getInstance();
				startCalendar.setTime(parking.getStartDate());
				Calendar endCalendar = Calendar.getInstance();
				endCalendar.setTime(parking.getEndDate());

				if (startCalendar.get(Calendar.MONTH) == month
						|| (startCalendar.get(Calendar.MONTH) != month && endCalendar.get(Calendar.MONTH) == month)) {
					newparkingList.add(parking);
				}
			}
			vehicle.setParkingList(newparkingList);
			newVehicleList.add(vehicle);
			System.out.println(
					"vehicle: " + vehicle.getVehicleNumber() + " newparkinglist.size: " + newparkingList.size());
		}
		System.out.println("newVehicleList.size() = " + newVehicleList.size());
		return newVehicleList;
	}

}
