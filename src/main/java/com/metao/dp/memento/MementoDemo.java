package com.metao.dp.memento;

public class MementoDemo {

	public static void main(String[] args) {

		// caretaker
		DietInfoCaretaker dietInfoCaretaker = new DietInfoCaretaker();

		// originator
		DietInfo dietInfo = new DietInfo("Fred", 1, 100);
		System.out.println(dietInfo);

		dietInfo.setDayNumberAndWeight(2, 99);
		System.out.println(dietInfo);

		System.out.println("Saving state.");
		dietInfoCaretaker.saveState(dietInfo);

		dietInfo.setDayNumberAndWeight(3, 98);
		System.out.println(dietInfo);

		dietInfo.setDayNumberAndWeight(4, 97);
		System.out.println(dietInfo);

		System.out.println("Restoring saved state.");
		dietInfoCaretaker.restoreState(dietInfo);
		System.out.println(dietInfo);

	}

}