package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Cartao extends PanacheEntityBase { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true, nullable = false)
    private String numeroCartao;

    public Cartao() {
    }

    public Cartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public String toString() {
        return "Cartao{" +
               "id=" + id +
               ", numeroCartao='" + numeroCartao + '\'' +
               '}';
    }
}
