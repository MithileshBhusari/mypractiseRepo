package com.mtb.ex;

import java.util.TreeMap;

/**
 * @author MithileshB
 * @created 16/01/2022 - 7:00 PM
 * @project interviewex
 */
/*
* Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
* */
public class StandOfStraightCardEx {

    public static boolean isNStraightHand(int[] hand,int w){
        TreeMap<Integer,Integer> card_counts=new TreeMap<>();
        for(int card:hand){
            if (!card_counts.containsKey(card)) {
                card_counts.put(card,1);
            }else{
                card_counts.replace(card,card_counts.get(card)+1);
            }
        }
        while(card_counts.size()>0){
            int first_card=card_counts.firstKey();
            for(int i=first_card;i<first_card+w;i++){
                if(!card_counts.containsKey(i)){
                    return false;
                }
                int count= card_counts.get(i);
                if(count==1){
                    card_counts.remove(i);
                }else{
                    card_counts.replace(i,card_counts.get(i)-1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int hand[]={1,2,3,6,2,3,4,7,8};
        int w=3;
        System.out.println(isNStraightHand(hand,w));
    }

}
