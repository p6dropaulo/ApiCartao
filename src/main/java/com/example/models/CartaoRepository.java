package com.example.models; 

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class CartaoRepository implements PanacheRepository<Cartao> {

    public Optional<Cartao> findByNumeroCartao(String numeroCartao) {
        return find("numeroCartao", numeroCartao).firstResultOptional();
    }
}
