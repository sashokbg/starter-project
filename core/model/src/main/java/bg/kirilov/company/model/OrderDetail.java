package bg.kirilov.company.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "orderdetails")
public class OrderDetail implements Serializable{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderNumber")
    @Id
    private Order order;

    @Column(name = "productCode", nullable = false)
    @Id
    private String productCode;

    @Column(name = "orderLineNumber")
    private int lineNumber;

    @Column(name = "quantityOrdered")
    private int quantity;

    @Column(name = "priceEach")
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

}
