/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgg.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author franqlin
 */
@Entity
@Table(name="GELADEIRA")
@XmlRootElement
@NamedQueries({
@NamedQuery(name="Geladeira.findAll",query = "select g from Geladeira g " ),
@NamedQuery(name="Geladeira.findById", query="select g from Geladeira g where g.id= :id"),
@NamedQuery(name="Geladeira.findByDescricao",query="select g from Geladeira g where g.descricao= :descricao")        
})
public class Geladeira implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="ID")
    private Integer id;
    @Size(max=20)
    @Column(name="DESCRICAO")
    private String descricao;
    @JoinColumn(name="ID_LOCALIZACAO",referencedColumnName = "ID")
    @ManyToOne(optional=false)
    private Localizacao localizacao;
    @OneToMany(mappedBy = "geladeira")
    private Collection<Produto> produtoCollection;

    public Geladeira() {
    }
    public Geladeira(Integer id) {
        this.id =id;
    }
    
     
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
     * @return the localizacao
     */
    public Localizacao getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * @return the produtoCollection
     */
    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    /**
     * @param produtoCollection the produtoCollection to set
     */
    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
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
        if (!(object instanceof Geladeira)) {
            return false;
        }
        Geladeira other = (Geladeira) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgg.model.Geladeira[ id=" + id + " ]";
    }
    
}
