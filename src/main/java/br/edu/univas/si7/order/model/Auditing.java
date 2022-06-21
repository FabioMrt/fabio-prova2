package br.edu.univas.si7.order.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Auditings")
public class Auditing {
	
	@Id
	private String identifier;
	private String operation;
    private LocalDateTime date;
    public Auditing() {
    	
    }

	public Auditing(String operation, LocalDateTime date) {
		super();
		this.operation = operation;
		this.date = date;
	}

	public String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public String getOperation() {
		return operation;
    
	}}
