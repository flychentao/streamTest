package com.chen.refactoring.demo02;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<>();
	
	public Customer(String name) {
		_name = name;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public Vector<Rental> get_rentals() {
		return _rentals;
	}

	public void set_rentals(Vector<Rental> _rentals) {
		this._rentals = _rentals;
	}
	
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	
	public String statement() {
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for "+get_name()+"\n";
		
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			result +="\t" +each.get_movie().get_title()+"\t"+String.valueOf(each.getCharge())+"\n";
		}
		
		result += "Amount owed is "+String.valueOf(getTotalCharge())+"\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +"frequent renter points";
		
		return result;
	}
	
	public double getTotalCharge() {
		Enumeration<Rental> rentals = _rentals.elements();
		double totalAmount = 0;
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			totalAmount += each.getCharge();
		}
		return totalAmount;
	}
	
	public int getTotalFrequentRenterPoints() {
		Enumeration<Rental> rentals = _rentals.elements();
		int frequentRenterPoints = 0;
		while (rentals.hasMoreElements()) {
			Rental each = rentals.nextElement();
			frequentRenterPoints += each.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

}
