package sample.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.service.CustomerSummaryService;
import sample.view.CustomerSummary;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Repository
public class CustomerSummaryServiceImpl implements CustomerSummaryService {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<CustomerSummary> findAllLastDatePurchase() {
        List<CustomerSummary> result = em.createQuery(
                "select new sample.view.CustomerSummary("+
                        "c.firstName , c.lastName , p.productId) from Customer c " +
                        "left join c.purchases p " +
                        "where p.buy=(select max(p2.buy) from Purchases p2 where p2.customer.id=c.id)",
                CustomerSummary.class).getResultList();
        return result;
    }
}
