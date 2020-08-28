package shop.init;


import org.springframework.beans.factory.annotation.Autowired;
import shop.model.Item;
import shop.repo.ItemRepository;

import javax.annotation.PostConstruct;

public class ItemInit {

    @Autowired
    private ItemRepository itemRepository;

    @PostConstruct
    public void init(){

        Item item=new Item();
        item.setName("milk");
        item.setNoNumber("abc123");
        itemRepository.add(item);
    }




}
