package com.budgetapi.budgetapi.service;

import java.util.*;


import com.budgetapi.budgetapi.entity.Item;

public interface ItemService {

    Item saveitem(Item item);

    void deleteItemById(Long itemId);

    void spent(Long itemId,float spentAmt);



    Optional<Item> getItemyById(Long id);

    Item updateItem(Long itemId, Item item);

    List<Item> getList();

   
    
}
