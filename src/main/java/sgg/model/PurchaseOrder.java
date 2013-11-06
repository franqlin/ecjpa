/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgg.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author franqlin
 */
@Entity
@Table(name = "PURCHASE_ORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrder.findAll", query = "SELECT p FROM PurchaseOrder p"),
    @NamedQuery(name = "PurchaseOrder.findByOrderNum", query = "SELECT p FROM PurchaseOrder p WHERE p.orderNum = :orderNum"),
    @NamedQuery(name = "PurchaseOrder.findByFreightCompany", query = "SELECT p FROM PurchaseOrder p WHERE p.freightCompany = :freightCompany"),
    @NamedQuery(name = "PurchaseOrder.findByQuantity", query = "SELECT p FROM PurchaseOrder p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "PurchaseOrder.findBySalesDate", query = "SELECT p FROM PurchaseOrder p WHERE p.salesDate = :salesDate"),
    @NamedQuery(name = "PurchaseOrder.findByShippingCost", query = "SELECT p FROM PurchaseOrder p WHERE p.shippingCost = :shippingCost"),
    @NamedQuery(name = "PurchaseOrder.findByShippingDate", query = "SELECT p FROM PurchaseOrder p WHERE p.shippingDate = :shippingDate")})
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDER_NUM")
    private Integer orderNum;
    @Column(name = "FREIGHT_COMPANY")
    private String freightCompany;
    @Column(name = "QUANTITY")
    private Short quantity;
    @Column(name = "SALES_DATE")
    @Temporal(TemporalType.DATE)
    private Date salesDate;
    @Column(name = "SHIPPING_COST")
    private Long shippingCost;
    @Column(name = "SHIPPING_DATE")
    @Temporal(TemporalType.DATE)
    private Date shippingDate;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    @ManyToOne
    private Product productId;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne
    private Customer customerId;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getFreightCompany() {
        return freightCompany;
    }

    public void setFreightCompany(String freightCompany) {
        this.freightCompany = freightCompany;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public Long getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Long shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderNum != null ? orderNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.orderNum == null && other.orderNum != null) || (this.orderNum != null && !this.orderNum.equals(other.orderNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgg.model.PurchaseOrder[ orderNum=" + orderNum + " ]";
    }
    
}
