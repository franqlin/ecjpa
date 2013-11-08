package sgg.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author franqlin
 */
@Entity
@Table(name="TIPO_PRODUTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoProduto.findAll", query = "SELECT t FROM TipoProduto t"),
    @NamedQuery(name = "TipoProduto.findById", query = "SELECT t FROM TipoProduto t WHERE t.id = :id"),
    @NamedQuery(name = "TipoProduto.findByDescricao", query = "SELECT t FROM TipoProduto t WHERE t.descricao = :descricao")})
public class TipoProduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="ID")
    private Integer id;
    @Size(max=30)
    @Column(name="DESCRICAO")
    private String  descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoProduto")
    private Collection<Produto> produtoCollection;

    public Integer getId() {
        return id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the produtoCollection
     */
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    /**
     * @param produtoCollection the produtoCollection to set
     */
    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProduto)) {
            return false;
        }
        TipoProduto other = (TipoProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgg.model.TipoProduto[ id=" + id + " ]";
    }
    
}
