package com.spark.custompatterns.model;
import java.sql.Date;

public class Declaration {
	 public String getDeclaration_id() {
		return declaration_id;
	}

	public void setDeclaration_id(String declaration_id) {
		this.declaration_id = declaration_id;
	}

	public Short getDeclaration_version() {
		return declaration_version;
	}

	public void setDeclaration_version(Short declaration_version) {
		this.declaration_version = declaration_version;
	}

	public Short getDeclaration_type() {
		return declaration_type;
	}

	public void setDeclaration_type(Short declaration_type) {
		this.declaration_type = declaration_type;
	}

	public Date getDeclaration_date() {
		return declaration_date;
	}

	public void setDeclaration_date(Date declaration_date) {
		this.declaration_date = declaration_date;
	}

	public DeclarationDetails[] getDeclaration_details() {
		return declaration_details;
	}

	public void setDeclaration_details(DeclarationDetails[] declaration_details) {
		this.declaration_details = declaration_details;
	}

	private String declaration_id;
	private Short declaration_version;

	private Short declaration_type;

	private Date declaration_date;

	private DeclarationDetails[] declaration_details;
}
