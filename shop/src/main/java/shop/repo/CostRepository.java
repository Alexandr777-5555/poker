package shop.repo;

import shop.model.Cost;

import java.util.List;

public interface CostRepository {

    void create(Cost cost);

    void remove(Cost cost);

    void remove(long id);

    Cost find(Cost cost);

    boolean exists(Cost cost);

    List<Cost> findAll();
}
