package requestsdev;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Invoice;
import model.Parking;
import model.ParkingWithFee;
import model.Vehicle;
import temp.TempDatas;
import utils.DateUtil;

public class InvoiceGenerate {
	
	private String isic;
	private int month;
	private final static int START_HOUR=7;
	private static final int END_HOUR=19;

	private static final BigDecimal MONTHLY_FEE_REGULAR=new BigDecimal(0.0);
	private static final BigDecimal MONTHLY_FEE_PREMIUM=new BigDecimal(20.0);
	private static final BigDecimal PARKING_FEE_START_REGULAR=new BigDecimal(1.50);
	private static final BigDecimal PARKING_FEE_START_PREMIUM=new BigDecimal(1.0);
	private static final BigDecimal PARKING_FEE_END_REGULAR=new BigDecimal(1.0);
	private static final BigDecimal PARKING_FEE_END_PREMIUM=new BigDecimal(0.75);
	private static final BigDecimal MAXIMUM_INVOICE_PREMIUM=new BigDecimal(300.0);
	private static final BigDecimal MAXIMUM_INVOICE_REGULAR=new BigDecimal(0.0);

	
	public InvoiceGenerate(String personIsic,int month){
		this.isic=personIsic;
		this.month=month;
	}

	public Invoice getInvoice() {
		Invoice invoice= new Invoice();
		Customer customer=TempDatas.getCustomer(isic);
		BigDecimal fullMonthFee=new BigDecimal(0.0);
		boolean isPermium=customer.isPremium();
		List<Vehicle>vehicleList=TempDatas.getVehicleListByMonth(customer, month);
		BigDecimal sum=new BigDecimal(0.0);
		List<ParkingWithFee>parkingWithFeeList=new ArrayList<>();
		for(Vehicle vehicle: vehicleList){
			sum=new BigDecimal(0.0);
			for(Parking parking: vehicle.getParkingList()){
				ParkingWithFee parkingWithFee=new ParkingWithFee();
				int[] arr=DateUtil.devideDateByHours(parking.getStartDate(), parking.getEndDate(), month, START_HOUR, END_HOUR);
				
				if(isPermium){
					sum= new BigDecimal(arr[0]*PARKING_FEE_START_PREMIUM.doubleValue()+arr[1]*PARKING_FEE_END_PREMIUM.doubleValue());
				}else{
					sum= new BigDecimal(arr[0]*PARKING_FEE_START_REGULAR.doubleValue()+arr[1]*PARKING_FEE_END_REGULAR.doubleValue());
				}
				
					parkingWithFee.setEndDate(parking.getEndDate());
					parkingWithFee.setStartDate(parking.getStartDate());
					parkingWithFee.setFee(sum);
					parkingWithFee.setParkingHouse(parking.getParkingHouse());
					parkingWithFee.setVehicleNumber(vehicle.getVehicleNumber());
					parkingWithFeeList.add(parkingWithFee);
					
					fullMonthFee=fullMonthFee.add(sum);			
			}	
		}
		
		
		fullMonthFee=fullMonthFee.add( (isPermium) ? MONTHLY_FEE_PREMIUM : MONTHLY_FEE_REGULAR );	
		invoice.setCustomer(customer);
		invoice.setFeeForDate(parkingWithFeeList);
		invoice.setFeeMonth((isPermium && fullMonthFee.compareTo(MAXIMUM_INVOICE_PREMIUM)==1 )? MAXIMUM_INVOICE_PREMIUM : fullMonthFee);
		invoice.setCustomerStutusMonthlyFee( (isPermium) ? MONTHLY_FEE_PREMIUM : MONTHLY_FEE_REGULAR );
		return invoice;
	}

}
