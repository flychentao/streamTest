package com.chen.refactoring.demo02;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
//	private int _priceCode;
	private Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
		set_priceCode(priceCode);
	}

	public String get_title() {
		return _title;
	}

	public void set_title(String _title) {
		this._title = _title;
	}

	public int get_priceCode() {
		return _price.getPriceCode();
	}

	public void set_priceCode(int _priceCode) {
		switch (_priceCode) {
		case Movie.REGULAR:
			_price = new RegularPrice();
			break;
		case Movie.NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		case Movie.CHILDRENS:
			_price = new ChildrensPrice();
			break;
		default:
			throw new IllegalArgumentException("unknow priceCode!");
		}
	}

	public Price get_price() {
		return _price;
	}

	public void set_price(Price _price) {
		this._price = _price;
	}

}
