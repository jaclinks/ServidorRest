package br.com.senior.treinamento.spring.treinamentospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.senior.treinamento.spring.treinamentospring.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

}
