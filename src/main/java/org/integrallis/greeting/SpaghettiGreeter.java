package org.integrallis.greeting;

import static org.integrallis.greeting.Person.Education.COLLEGE;
import static org.integrallis.greeting.Person.Gender.MALE;
import static org.integrallis.greeting.Person.MaritalStatus.SINGLE;

public class SpaghettiGreeter {
	
	public static void greet(Person person, TimeOfDay timeOfDay) {
		if (timeOfDay.getHour() < 12) {
			System.out.print("Good Morning, ");
		} else if ((timeOfDay.getHour() >= 12) && (timeOfDay.getHour() <= 17)) {
			System.out.print("Good Afternoon, ");
	    } else if ((timeOfDay.getHour() >= 18) && (timeOfDay.getHour() <= 22)) {
			System.out.print("Good Evening, ");
	    } else {
	    	System.out.print("Good Night, ");
	    }
		
		System.out.println(person.getName());
	}
	
	public static void main(String[] args) {
		Person mauriceMoss = new Person("Maurice Moss", MALE, 32, SINGLE, COLLEGE);
		TimeOfDay nineAm = new TimeOfDay(9, 0);
		
		greet(mauriceMoss, nineAm);
	}

}
