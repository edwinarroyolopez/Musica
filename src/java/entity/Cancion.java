/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zero
 */
@Entity
@Table(name = "CANCION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancion.findAll", query = "SELECT c FROM Cancion c")
    , @NamedQuery(name = "Cancion.findByIdcancion", query = "SELECT c FROM Cancion c WHERE c.idcancion = :idcancion")
    , @NamedQuery(name = "Cancion.findByDescripcion", query = "SELECT c FROM Cancion c WHERE c.descripcion = :descripcion")})
public class Cancion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_cancion")
    private Integer idcancion;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "Id_album", referencedColumnName = "Id_album")
    @ManyToOne(optional = false)
    private Album idalbum;

    public Cancion() {
    }

    public Cancion(Integer idcancion) {
        this.idcancion = idcancion;
    }

    public Cancion(Integer idcancion, String descripcion) {
        this.idcancion = idcancion;
        this.descripcion = descripcion;
    }

    public Integer getIdcancion() {
        return idcancion;
    }

    public void setIdcancion(Integer idcancion) {
        this.idcancion = idcancion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Album getIdalbum() {
        return idalbum;
    }

    public void setIdalbum(Album idalbum) {
        this.idalbum = idalbum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcancion != null ? idcancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.idcancion == null && other.idcancion != null) || (this.idcancion != null && !this.idcancion.equals(other.idcancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cancion[ idcancion=" + idcancion + " ]";
    }
    
}
