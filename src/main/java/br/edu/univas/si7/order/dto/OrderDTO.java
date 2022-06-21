package br.edu.univas.si7.order.dto;

import javax.validation.constraints.NotNull;

import br.edu.univas.si7.order.model.Order;

public class OrderDTO {
	
	@NotNull(message = "o numero de compra não pode ser null.")
	private String orderNumber;
	
	@NotNull(message = "o codigo do produto não pode ser null.")
    private String productCode;
	
	@NotNull(message = "o cpf não pode ser null.")

    private String cpf;
	
	@NotNull(message = "A quantia não pode ser null.")
    private String amount;
	
	@NotNull(message = "a data da venda não pode ser null.")
    private String dateSale;
	
	@NotNull(message = "o valor não pode ser null.")

    private String value;
	
	public OrderDTO() {
	}
	
	public OrderDTO(Order ord) {
		this.orderNumber = ord.getorderNumber();
		this.productCode = ord.getproductCode();
		this.cpf = ord.getcpf();
		this.amount = ord.getamount();
		this.dateSale = ord.getdateSale();
		this.value = ord.getvalue();
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
	public String getValue() {
		return value;
	}

	public void setValue(String Value) {
		this.value = Value;
	}
	
	

}