package com.domain.criteria;

/**
 * En guise de critere pour nos personne, nous n'avons besoin que d'un id.
 */
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
