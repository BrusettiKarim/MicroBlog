/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;
/**
 *
 * @author Karim
 */



@Entity
public class Commento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date dataOra;
    
    @Lob
    @Column(nullable = false)
    public String contenuto;
    
    @ManyToOne(targetEntity = Utente.class)
    @JoinColumn(nullable = false)
    public Utente utente;
    
    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(nullable = false)
    public Post post;


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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Commento() {
    }
    
    
    
}
