package com.example.endpointexample.service;

import com.example.endpointexample.model.Item;
import com.example.endpointexample.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> performOperation(String operation, Item item) {
        switch (operation.toLowerCase()) {
            case "findall":
                return getAllItems();
            default:
                throw new IllegalArgumentException("Operacio no valida: " + operation);
        }
    }

    private List<Item> getAllItems1() {
        log.info("fetching all items");
        log.info("this is the service");
        List<Item> items = itemRepository.findAll();
        log.info("Retrieved {} items", items.size());
        for (Item item : items) {
            System.out.println(items);
        }
        return items;

    }

    private List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item postCreateItem(Item newitem) {
        return itemRepository.save(newitem);
    }

    public void insertDiscountByCategory(Item item) {
        switch (item.getCategory()) {
            case "Electronic":
                item.setDiscount(10);
                break;
            case "Home":
                item.setDiscount(20);
                break;
            case "Clothes":
                item.setDiscount(30);
                break;
            case "Shoes":
                item.setDiscount(40);
                break;
            default:
                break;
        }

        itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);

    }

    public void patchItem(Item item) {
        itemRepository.save(item);
    }

    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }
}


