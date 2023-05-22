package com.budgetapi.budgetapi.service;

import java.util.Objects;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.budgetapi.budgetapi.entity.Item;

import com.budgetapi.budgetapi.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    public ItemRepository itemRepository;

    @Override
    public Item saveitem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItemById(Long itemId) {
    itemRepository.deleteById(itemId);
    }


    @Override
    public Optional<Item> getItemyById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public void spent(Long itemId,float spentAmt) {
     Item itemDB = itemRepository.findById(itemId).get();

     itemDB.setRemainingAmt(itemDB.getBudgetedAmt() - spentAmt); 
    
    
    }

    @Override
    public Item updateItem(Long itemId, Item item) {


        Item itemDB = itemRepository.findById(itemId).get();

        itemDB.setSpentAmt(itemDB.getSpentAmt() + item.getSpentAmt());
      
        itemDB.setRemainingAmt(itemDB.getBudgetedAmt()-itemDB.getSpentAmt());

        
    return itemRepository.save(itemDB);
    }

    @Override
    public List<Item> getList() {
        return itemRepository.findAll();
    }

   
}
