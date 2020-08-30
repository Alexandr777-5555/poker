package shop.init;

import org.springframework.beans.factory.annotation.Autowired;
import shop.model.Cost;
import shop.repo.CostRepository;

import javax.annotation.PostConstruct;

public class CostInit {

    @Autowired
    private CostRepository costRepository;

    @PostConstruct
    public void init() {
        Cost cost=new Cost();
        cost.setNoNumber("abc123");
        cost.setPrice(11.1);
        costRepository.create(cost);
    }
}
