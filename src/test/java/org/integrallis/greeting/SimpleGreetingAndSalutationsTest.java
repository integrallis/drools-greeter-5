package org.integrallis.greeting;

import static org.integrallis.greeting.Person.Education.DROPOUT;
import static org.integrallis.greeting.Person.Gender.MALE;
import static org.integrallis.greeting.Person.MaritalStatus.SINGLE;
import static org.junit.Assert.*;

import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.QueryResultsRow;
import org.integrallis.drools.junit.BaseDroolsTestCase;
import org.junit.Test;

public class SimpleGreetingAndSalutationsTest extends BaseDroolsTestCase {

	public SimpleGreetingAndSalutationsTest() {
		super("greetings.drl");
	}

	@Test
	public void testGreetingForMorningTimes() {
		TimeOfDay nineAm = new TimeOfDay(9, 0);
		Person person = new Person("Stephen Falken", MALE, 48, SINGLE, DROPOUT);
		
		knowledgeSession.insert(nineAm);
		knowledgeSession.insert(person);
		
		knowledgeSession.fireAllRules();
		
		// Query here!
		QueryResults results = knowledgeSession.getQueryResults( "GetAllGreetingAndSalutations" );
		
		// Make Assertions
		assertEquals("There should be only one greeting and salutation", 1, results.size());

		for ( QueryResultsRow row : results ) {
		    GreetingAndSalutation greeting = (GreetingAndSalutation) row.get( "greeting" );
		    assertEquals("Greeting should be Good Morning", "Good Morning", greeting.getGreeting());
		}
	}
	
	@Test
	public void testGreetingForAfterNoonTimes() {
		TimeOfDay onePm = new TimeOfDay(13, 0);
		Person person = new Person("Stephen Falken", MALE, 48, SINGLE, DROPOUT);
		
		knowledgeSession.insert(onePm);
		knowledgeSession.insert(person);
		
		knowledgeSession.fireAllRules();
		
		// Query here!
		QueryResults results = knowledgeSession.getQueryResults( "GetAllGreetingAndSalutations" );
		
		// Make Assertions
		assertEquals("There should be only one greeting and salutation", 1, results.size());

		for ( QueryResultsRow row : results ) {
		    GreetingAndSalutation greeting = (GreetingAndSalutation) row.get( "greeting" );
		    assertEquals("Greeting should be Good Afternoon", "Good Afternoon", greeting.getGreeting());
		}
	}	

}
