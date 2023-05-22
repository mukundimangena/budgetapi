package com.budgetapi.budgetapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    
    private String itemName;
    private float budgetedAmt;
    private float spentAmt;
    private float remainingAmt;

   
/*
 * expense deducts a spent amt from the budget
 */
    public void expense(float spentAmt){
        remainingAmt-=spentAmt;
    }
}
