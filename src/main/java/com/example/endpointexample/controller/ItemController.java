package com.example.endpointexample.controller;

import com.example.endpointexample.model.Item;
import com.example.endpointexample.repository.ItemRepository;
import com.example.endpointexample.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/inventory")
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    public ItemController(ItemRepository itemRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @GetMapping("/find")
    public List<Item> getAllItems() {
        log.info("Fetching all items");
        log.info("this is the controller");
        List<Item>items = itemRepository.findAll();
        log.info("Retrieved {} items",items.size());
        return itemRepository.findAll();
    }

    @PostMapping("/create")
    public Item postCreateItem(@RequestBody Item item) {
        itemService.insertDiscountByCategory(item);
        return itemRepository.save(item);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }

    @PatchMapping("/edit")
    public void patchItem(@RequestBody Item item) {
        itemRepository.save(item);
    }

    @PutMapping("update")
    public Item updateItem(@RequestBody Item item) {
        return itemService.updateItem(item);
    }
}


