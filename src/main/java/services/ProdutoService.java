package services;

import models.Produto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class ProdutoService {

    @Inject
    EntityManager entityManager;

    public List<Produto> getProdutos() {
        return entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public void salvaProduto(Produto produto) {
        entityManager.persist(produto);
    }
}
