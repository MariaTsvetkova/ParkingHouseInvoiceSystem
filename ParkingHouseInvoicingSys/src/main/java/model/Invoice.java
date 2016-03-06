package model;

import java.math.BigDecimal;
import java.util.List;

public class Invoice {
	private Customer customer;
	
	private BigDecimal feeMonth;
	private List<ParkingWithFee> feeForDate;
	private BigDecimal customerStutusMonthlyFee;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public BigDecimal getFeeMonth() {
		return feeMonth;
	}
	public void setFeeMonth(BigDecimal feeMonth) {
		this.feeMonth = feeMonth;
	}
	public List<ParkingWithFee> getFeeForDate() {
		return feeForDate;
	}
	public void setFeeForDate(List<ParkingWithFee> feeForDate) {
		this.feeForDate = feeForDate;
	}
	public BigDecimal getCustomerStutusMonthlyFee() {
		return customerStutusMonthlyFee;
	}
	public void setCustomerStutusMonthlyFee(BigDecimal customerStutusMonthlyFee) {
		this.customerStutusMonthlyFee = customerStutusMonthlyFee;
	}

	
	

}
