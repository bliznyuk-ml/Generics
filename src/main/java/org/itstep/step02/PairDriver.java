package org.itstep.step02;

import org.itstep.step01.ObjectPair;

// TODO: Пишите ваш код здесь
public class PairDriver {
    public static void main(String[] args) {

        Pair<String, Integer>[] stadiums = new Pair[3];
        stadiums[0] = new Pair<String, Integer>("Bridgeforth Stadium", 25000);
        stadiums[1] = new Pair<String, Integer>("Michigan Stadium", 109901);
        stadiums[2] = new Pair<String, Integer>("Lane Stadium", 66233);

        System.out.println(largestStadium(stadiums));
    }

    public static String largestStadium(Pair<String, Integer>[] stadiums) {

        int maxCapacity = 0;
        int maxIndex = 0;
        for (int i = 0; i < stadiums.length; i++) {
            if (stadiums[i].getSecond() > maxCapacity) {
                maxCapacity = stadiums[i].getSecond();
                maxIndex = i;
            }
        }
        return stadiums[maxIndex].getFirst();
    }
}


