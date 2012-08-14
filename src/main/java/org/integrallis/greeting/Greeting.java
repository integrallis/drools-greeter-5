package org.integrallis.greeting;

public class Greeting {
	private Person person;
    private String greeting;
    private String salutation;
    
	public Person getPerson() { return person; }
	public void setPerson(Person person) { this.person = person; }
    public String getSalutation() { return salutation; }
    public void setSalutation(String salutation) { this.salutation = salutation; }
	public void setGreeting(String greeting) { this.greeting = greeting; }
    public String getGreeting() { return greeting; }
    
    public String greet() { return greeting + ", " + salutation + " " + person.getName(); }
    
    @Override
    public String toString() {
    		return greet();
    }
}
