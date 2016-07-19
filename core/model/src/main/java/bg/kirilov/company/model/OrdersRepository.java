package bg.kirilov.company.model;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrdersRepository extends Repository<Order, Long> {
    List<Order> findAll();
    List<Order> findByNumber(Long number);
}
