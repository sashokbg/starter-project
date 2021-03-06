package bg.kirilov.company.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
@NamedEntityGraph(
        name = "ordersWithDetails",
        attributeNodes = {
            @NamedAttributeNode(value = "details", subgraph = "graph.OrderDetail.product")
        },
        subgraphs = {
            @NamedSubgraph(name = "graph.OrderDetail.product", attributeNodes = @NamedAttributeNode("product"))
        }
)
public class Order implements Serializable{
    @Id
    @Column(name = "orderNumber")
    private Long number;

    @Column(name = "orderDate")
    private Date date;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> details;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }
    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }
}
