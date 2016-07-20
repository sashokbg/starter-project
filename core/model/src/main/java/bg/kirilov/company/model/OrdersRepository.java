package bg.kirilov.company.model;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrdersRepository extends Repository<Order, Long> {
    @EntityGraph(value = "graph.Order.details", type = EntityGraph.EntityGraphType.LOAD)
    List<Order> findAll();
    List<Order> findByNumber(Long number);
}
