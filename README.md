# Banking-System-ASD

## Specification
 - Memory base persistence
 - File base persistence
 - 


##Account
-definition: is the aggregation the entries against items. 
Eg. If you want to implement our interface to a Refrigerator App
the Account is the Refrigerator, and the items that we insert in 
there milk is the items or entries. That is the definition of the 
Account Pattern. 

##Behaviour
the BalanceBehaviour is the one that will give us the cumulative or the summ 
of the items that we have. If it is currency app, the balanceBehaviour is going
to add the amount of money to our inventory, i.e bankAccount.
If it is the Refrigerator App then it will add number of milk items to our inventory.
i.e the Refrigerator.

We are using the strategy pattern here so that we can have the flexibilty of
adding any ind of logic that we need to use.

##Hook
