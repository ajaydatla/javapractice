package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class PalindromeInteger {
    public static void main(String[] args) {
        List<String> csvLines = Arrays.asList("a,b,c", "d,e", "f,g,h");

//1, 2, 3 ---> 3, 6, 9

        List<String> dd=  csvLines.stream().map( h ->
                        h.split(","));


//                .forEach(System.out::println);
//                .collect(Collectors.toList())
        System.out.println(csvLines.stream().map( h ->
                        h.split(","))

                .collect(Collectors.toList()));

//        csvLines.stream().flatMap(
//                List :: stream
//        ).collect(Collectors.toCollection());

        // Output: [a, b, c, d, e, f, g, h]
    }
}




@Transactional
private void confirmPayment() {
    Transaction txn = new Transaction();
    ...
    ...set fields..
    txn.setStatus(IN_PROGRESS);
    repo.save(txn); //critical checkpoint


    compata.fute{
        try{
            notification.sendEmail(txn);//100%
            notification.notifyStore(txn);//100%
            notification.notifyThirdParty(txn);//100%
            txn.setStatus(COMPLETED);
            repo.sa
        }catch (Exception e){
            rollback mechanism;
        }


    }





//    notification.notifyStore(txn);
//    notification.notifyThirdParty(txn);


    repo.save(txn);
}



