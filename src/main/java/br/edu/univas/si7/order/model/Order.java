package br.edu.univas.si7.order.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Orders")
public class Order {
	
	@org.springframework.data.annotation.Id
	private String id;
    private String orderNumber;
    private String productCode;
    private String cpf;
    private String amount;
    private String dateSale;
    private String value;
    
    @DBRef(lazy = true)
    private Auditing auditing;
    
    public Order() {
    }

	public Order(String orderNumber, String productCode, String cpf, String amount, String dateSale, String value) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.cpf = cpf;
		this.amount = amount;
		this.dateSale = dateSale;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getorderNumber() {
		return orderNumber;
	}

	public void setorderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getproductCode() {
		return productCode;
	}

	public void setproductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getcpf() {
		return cpf;
	}

	public void setcpf(String cpf) {
		this.cpf = cpf;
	}

	public String getamount() {
		return amount;
	}

	public void setamount(String amount) {
		this.amount = amount;
	}

	public String getdateSale() {
		return dateSale;
	}

	public void setdateSale(String dateSale) {
		this.dateSale = dateSale;
	}


	public String getvalue() {
	return value;
	}

	public void setvalue(String value) {
	this.value = value;
}
	public Auditing getAuditing() {
		return auditing;
	}

	public void setAuditing(Auditing auditing) {
		this.auditing = auditing;
	}
	 

}