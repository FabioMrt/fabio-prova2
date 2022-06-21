package br.edu.univas.si7.order.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.univas.si7.order.controller.exception.InvalidDataException;
import br.edu.univas.si7.order.controller.exception.ObjectNotFoundException;
import br.edu.univas.si7.order.dto.OrderDTO;
import br.edu.univas.si7.order.model.Auditing;
import br.edu.univas.si7.order.model.Order;
import br.edu.univas.si7.order.repository.AuditingMongoRepository;
import br.edu.univas.si7.order.repository.OrderMongoRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderMongoRepository ordRepo;
	
	@Autowired
	private AuditingMongoRepository audRepo;
	
	public List<OrderDTO> getAllOrders(){
		List<Order> listord = ordRepo.findAll();
		
		return listord.stream()
				.map(ord -> new OrderDTO(ord))
				.collect(Collectors.toList());
	}
	
	public Order getOrderById(@PathVariable String id){
		if(id == null) {
			throw new InvalidDataException("ID NAO PODE SER NULL");
		}
		Optional<Order> obj = ordRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("MENSAGEM NAO ENCONTRADA " + id));
	}
	
	public void createOrder(OrderDTO dto) {
		Order ord = toOrder(dto);
		Auditing aud = new Auditing();
		aud.setOperation("CREATE");
		aud.setDate(LocalDateTime.now());
		audRepo.save(aud);
		ord.setAuditing(aud);
		ordRepo.save(ord);
	}
	
	public void updateOrder(OrderDTO dto, String id) {
		if(dto == null) {
			throw new InvalidDataException("MENSAGEM NAO PODE SER NULL");
		}
		Order ord = getOrderById(id);
		updateData(dto, ord);
		Auditing aud = new Auditing();
		aud.setOperation("UPDATE");
		aud.setDate(LocalDateTime.now());
		audRepo.save(aud);
		ord.setAuditing(aud);
		ordRepo.save(ord);
	}
	
	public void deleteOrder(String id) {
		Order ord = getOrderById(id);
		Auditing aud = new Auditing();
		aud.setOperation("DELETE");
		aud.setDate(LocalDateTime.now());
		audRepo.save(aud);
		ord.setAuditing(aud);
		ordRepo.delete(ord);
	}
	
	private void updateData(OrderDTO dto, Order ord) {
		ord.setorderNumber(dto.getorderNumber());
		ord.setproductCode(dto.getproductCode());
		ord.setcpf(dto.getcpf());
		ord.setamount(dto.getamount());
		ord.setdateSale(dto.getdateSale());
		ord.setvalue(dto.getValue());
	}
	
	private Order toOrder(OrderDTO dto) {
		Order ord = new Order();
		ord.setorderNumber(dto.getorderNumber());
		ord.setproductCode(dto.getproductCode());
		ord.setcpf(dto.getcpf());
		ord.setamount(dto.getamount());
		ord.setdateSale(dto.getdateSale());
		ord.setvalue(dto.getValue());
		
		return ord;
	}

}
