/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Karim
 */



@Entity
public class Post implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date dataOra;
    
    @Basic
    @Column(unique = true, nullable = false)
    public String titolo;
    
    @Lob
    @Column(nullable = false)
    public String contenuto;
    
    @ManyToOne(targetEntity = Utente.class)
    @JoinColumn(nullable = false, name="UTENTE_USERNAME")
    public Utente utente;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataOra() {
        return dataOra;
    }

    public void setDataOra(Date dataOra) {
        this.dataOra = dataOra;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Post() {
    }

}


