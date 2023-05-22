package com.budgetapi.budgetapi.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import com.budgetapi.budgetapi.entity.Item;
import com.budgetapi.budgetapi.service.ItemService;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;
  //Save a budgeted item 
   @PostMapping("/additem")
   public Item saveitem(@RequestBody Item item){
    return itemService.saveitem(item);
   }
//deletes any budget item 
   @DeleteMapping("/item/{id}")
   public String deleteItemById(@PathVariable("id") Long itemId){
    itemService.deleteItemById(itemId);
   return "Successfully Deleted Item.";}


  //this was supposed to be what we use for deduction in our budgets
   @PutMapping("/item/{id}/{spentAmt}")
   public String spent(@PathVariable("id") Long itemId,@PathVariable("spentAmt") float spentAmt){
           itemService.spent(itemId,spentAmt);
           return "You have spent = "+ spentAmt;
   }
   //get the budget item using its itemId
  @GetMapping("/items/{id}")
   public Optional<Item> getItemById(@PathVariable("id") Long id){
        return itemService.getItemyById(id);

   }

   //we use the updateItem for deducting the the amount we spent
   @PutMapping("/item/{id}")
   public Item updateItem(@PathVariable("id") Long itemId,@RequestBody Item item){
        return itemService.updateItem(itemId,item);
   }

   //List the different items in the budget 
   @GetMapping("items")
   public List<Item> getList(){

        return itemService.getList();
   }
}
