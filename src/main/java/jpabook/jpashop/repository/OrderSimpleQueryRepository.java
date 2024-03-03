package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;

import java.util.List;

public class OrderSimpleQueryRepository {
    private final EntityManager em;

    public OrderSimpleQueryRepository (EntityManager em) {
        this.em = em;
    }

    public List<SimpleOrderQueryDto> findOrderDtos() {
        return em.createQuery(
                "select new jpabook.jpashop.repository.SimpleOrderQueryDto(o.id, m.name, o.orderDate, o.status, d.address) " +
                        "from Order o "+
                        "join o.member m " +
                        "join o.delivery d", SimpleOrderQueryDto.class
        ).getResultList();
    }
}
