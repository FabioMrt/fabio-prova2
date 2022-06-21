package br.edu.univas.si7.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.order.dto.OrderDTO;
import br.edu.univas.si7.order.model.Order;
import br.edu.univas.si7.order.service.OrderService;

@RestController
@RequestMapping("/Orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping()
	public List<OrderDTO> getAllOrders(){
		return service.getAllOrders();
	}
	
	@GetMapping("/{id}")
	public OrderDTO getOrderById(@PathVariable String id) {
		Order ord = service.getOrderById(id);
		return new OrderDTO(ord);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createOrder(@RequestBody @Valid OrderDTO dto) {
		service.createOrder(dto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateOrder(@RequestBody @Valid OrderDTO dto, @PathVariable String id) {
		service.updateOrder(dto, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteOrder(@PathVariable String id) {
		service.deleteOrder(id);
	}

}
