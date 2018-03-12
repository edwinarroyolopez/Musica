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
@Table(name = "ARTISTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artista.findAll", query = "SELECT a FROM Artista a")
    , @NamedQuery(name = "Artista.findByIdartista", query = "SELECT a FROM Artista a WHERE a.idartista = :idartista")
    , @NamedQuery(name = "Artista.findByNombre", query = "SELECT a FROM Artista a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Artista.findByEdad", query = "SELECT a FROM Artista a WHERE a.edad = :edad")
    , @NamedQuery(name = "Artista.findByPais", query = "SELECT a FROM Artista a WHERE a.pais = :pais")
    , @NamedQuery(name = "Artista.findByGeneromusical", query = "SELECT a FROM Artista a WHERE a.generomusical = :generomusical")})
public class Artista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_artista")
    private Integer idartista;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "Edad")
    private int edad;
    @Column(name = "Pais")
    private String pais;
    @Column(name = "Genero_musical")
    private String generomusical;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idartista")
    private Collection<Album> albumCollection;

    public Artista() {
    }

    public Artista(Integer idartista) {
        this.idartista = idartista;
    }

    public Artista(Integer idartista, String nombre, int edad) {
        this.idartista = idartista;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Integer getIdartista() {
        return idartista;
    }

    public void setIdartista(Integer idartista) {
        this.idartista = idartista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGeneromusical() {
        return generomusical;
    }

    public void setGeneromusical(String generomusical) {
        this.generomusical = generomusical;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idartista != null ? idartista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artista)) {
            return false;
        }
        Artista other = (Artista) object;
        if ((this.idartista == null && other.idartista != null) || (this.idartista != null && !this.idartista.equals(other.idartista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Artista[ idartista=" + idartista + " ]";
    }
    
}
