package sortedcollections;

/**
 * @author MithileshB
 * @created 26/08/2020 - 7:07 PM
 * @project mypractiseRepo
 */
public class MainChallenge {
    /*Modify the program so that adding items to the shopping basket doesn't
        actually reduce the stock count but ,instead,reserves the requested number of items.

        you will need to add a "reserved" field  to the stockItem class to store the number of items reserved.

    Items can continue to be added to the basket.but it should not be possible to reserve more than the available stock of
    any item.An item's available stock  is the stock count less that the reserved amount.
    The stock count of each item is reduced when basket is checked out,at which point all reserved items in the basket have their actual stockcount reduced
     Once checkout is complete, the contents of the basket  are cleared.

    It should also be possible to "unreserve" items that were added to the basket by mistake.

    The program should prevent any attempt to unreserve more items than were reserved for a basket.

    Add code to main that will unreserve items after they have been added to the basket ,
    as well as unreserving items that have not been added to make sure that the code can cope with invalid requests like that.

   After checking out the baskets,display the full stock list and the contents of each basket that you created.
    */
}
