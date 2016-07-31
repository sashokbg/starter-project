package bg.kirilov.company.model;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CustomerRepository extends Repository<Customer,Long>{
//    @EntityGraph(value = "graph.Order.details", type = EntityGraph.EntityGraphType.LOAD)
    List<Customer> findAll();
}
