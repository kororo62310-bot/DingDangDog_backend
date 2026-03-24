package com.ddd.app.main.dto;

import java.time.LocalDate;

public class mainCareDTO {
	private int careNumber;
	private String careTitle;
	private LocalDate careDate;

	public int getCareNumber() {
		return careNumber;
	}

	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}

	public String getCareTitle() {
		return careTitle;
	}

	public void setCareTitle(String careTitle) {
		this.careTitle = careTitle;
	}

	public LocalDate getCareDate() {
		return careDate;
	}

	public void setCareDate(LocalDate careDate) {
		this.careDate = careDate;
	}

	@Override
	public String toString() {
		return "mainCareDTO [careNumber=" + careNumber + ", careTitle=" + careTitle + ", careDate=" + careDate + "]";
	}
}