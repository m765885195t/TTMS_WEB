package util;

import cn.motian.model.Ticket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {

    public static void main(String[] args) {
        List ticketList = Collections.singletonList("1,2,3");


        double ticketAmount = Stream.of("1","2","3.2")
                .map(o -> Double.parseDouble(o))
                .reduce((x, y) -> x + y).get();

        System.out.println(ticketAmount);
    }
}


