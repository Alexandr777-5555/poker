package shop.repo;


import shop.model.Item;

import java.util.List;

public interface ItemRepository {

    void add(Item item);

    void remove(Item item);

    void remove(long id);

    Item find(Item item);

    boolean exists(Item item);

    List<Item> findAll();

    List<Item> findAllWithCost();
}
