package ch.zli.m223.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Coffee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Long price;
    
    @ManyToMany
    @JoinTable(
      name = "user_coffee",
      joinColumns = @JoinColumn(name = "coffee_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
      @JsonIgnore
      private Set<User> users;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public Long getPrice() {
      return price;
    }

    public void setPrice(Long price) {
      this.price = price;
    }

    public Set<User> getUsers() {
      return users;
    }

    public void setUsers(Set<User> users) {
      this.users = users;
    }
}