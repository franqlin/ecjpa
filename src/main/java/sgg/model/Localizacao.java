/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name="LOCALIZACAO")
@XmlRootElement
@NamedQueries({
@NamedQuery(name="Localizacao.findAll",query = "SELECT l FROM Localizacao l "),
@NamedQuery(name="Localizacao.findById",query = "SELECT l FROM Localizacao l WHERE l.id = :descricao"),
@NamedQuery(name="Localizacao.findByDescricao",query = "SELECT l FROM Localizacao WHERE l.descricao = :descricao")
})
public class Localizacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="ID")
    private Integer id;
    @Size(max=20)
    @Column(name="DESCRICAO")
    private String descricao;  
    @OneToMany(cascade = CascadeType.ALL,mappedBy="localizacao")
    private Collection<Geladeira> geladeiraCollection;

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
     * @return the geladeiraCollection
     */
    public Collection<Geladeira> getGeladeiraCollection() {
        return geladeiraCollection;
    }

    /**
     * @param geladeiraCollection the geladeiraCollection to set
     */
    public void setGeladeiraCollection(Collection<Geladeira> geladeiraCollection) {
        this.geladeiraCollection = geladeiraCollection;
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
        if (!(object instanceof Localizacao)) {
            return false;
        }
        Localizacao other = (Localizacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgg.model.Localizacao[ id=" + id + " ]";
    }
    
}
