package com.domaine.criteria;

public class PersonneCriteria implements Criteria {

	
	private int id;

	public PersonneCriteria(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
