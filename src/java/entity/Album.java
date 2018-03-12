/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zero
 */
@Entity
@Table(name = "ALBUM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a")
    , @NamedQuery(name = "Album.findByIdalbum", query = "SELECT a FROM Album a WHERE a.idalbum = :idalbum")
    , @NamedQuery(name = "Album.findByDescripcion", query = "SELECT a FROM Album a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Album.findByAnio", query = "SELECT a FROM Album a WHERE a.anio = :anio")})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_album")
    private Integer idalbum;
    @Basic(optional = false)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "Anio")
    private int anio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalbum")
    private Collection<Cancion> cancionCollection;
    @JoinColumn(name = "Id_artista", referencedColumnName = "Id_artista")
    @ManyToOne(optional = false)
    private Artista idartista;

    public Album() {
    }

    public Album(Integer idalbum) {
        this.idalbum = idalbum;
    }

    public Album(Integer idalbum, String descripcion, int anio) {
        this.idalbum = idalbum;
        this.descripcion = descripcion;
        this.anio = anio;
    }

    public Integer getIdalbum() {
        return idalbum;
    }

    public void setIdalbum(Integer idalbum) {
        this.idalbum = idalbum;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @XmlTransient
    public Collection<Cancion> getCancionCollection() {
        return cancionCollection;
    }

    public void setCancionCollection(Collection<Cancion> cancionCollection) {
        this.cancionCollection = cancionCollection;
    }

    public Artista getIdartista() {
        return idartista;
    }

    public void setIdartista(Artista idartista) {
        this.idartista = idartista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalbum != null ? idalbum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.idalbum == null && other.idalbum != null) || (this.idalbum != null && !this.idalbum.equals(other.idalbum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Album[ idalbum=" + idalbum + " ]";
    }
    
}
