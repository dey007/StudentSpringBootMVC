package com.nt.student.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

public class LocalDateTimeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] dateSplitter = text.split("-");
		int year = Integer.parseInt(dateSplitter[0]);
		int month = Integer.parseInt(dateSplitter[1]);
		int date = Integer.parseInt(dateSplitter[2]);
		
		LocalDate ldt = LocalDate.of(year, month, date);
		setValue(ldt);
	}
}
