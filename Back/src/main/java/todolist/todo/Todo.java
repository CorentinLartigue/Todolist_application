package todolist.todo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Todo {

    @Id
    private Long id;

    private String nom;

    private String contenu;

    private Timestamp date_creation;
    private Statut statut;

    public Todo() {
    }
    public Todo(Long id, String nom, Statut statut,String contenu,Timestamp date_creation) {
        this.id = id;
        this.nom = nom;
        this.statut = statut;
        this.contenu = contenu;
        this.date_creation=date_creation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Timestamp getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Timestamp date_creation) {
        this.date_creation = date_creation;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) && Objects.equals(nom, todo.nom) && Objects.equals(contenu, todo.contenu) && Objects.equals(date_creation, todo.date_creation) && statut == todo.statut;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, contenu, date_creation, statut);
    }
}
