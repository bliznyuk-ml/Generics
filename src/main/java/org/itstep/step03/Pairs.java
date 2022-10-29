package org.itstep.step03;

import org.itstep.step02.Pair;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Итерируемая коллекция объектов Pair.
 *
 * @author Michael S. Kirkpatrick and Nathan Sprague
 * @version V1, 8/2017
 */
public class Pairs<K, V> implements Iterable<Pair<K, V>> {

    /* TODO: Объявить массив фиксированного размера (максимум 10 элементов) объектов Pair */
    Pair<K, V>[] pair = new Pair[10];

    /**
     * Создайте коллекцию, в которой будут храниться элементы, добавленные парами.
     */

    private K first;
    private V second;
    private int indexCount = 0;

    public Pairs(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public Pairs() {
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }


    /**
     * TODO: Создайте новую пару и добавьте ее в коллекцию, если есть место.
     *
     * @param first  Первый объект
     * @param second Второй объект
     * @return true - если пара была добавлена, false - в противном случае
     */
    public boolean addPair(K first, V second) {
        if(indexCount < pair.length){
            pair[indexCount] = new Pair(first, second);
            indexCount++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new PairIterator();
    }

    /*
     * TODO: Реализуйте итератор здесь на основе документации API по адресу
     * https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html Throw the exceptions as
     * specified
     */
    private class PairIterator implements Iterator<Pair<K, V>> {
        private int index = -1;

        /**
         * TODO: Проверить наличие следующего элемента в итераторе
         */
        @Override
        public boolean hasNext() {
            //if (index ==  indexCount) throw new UnsupportedOperationException();
            return ++index < indexCount;
        }

        /**
         * TODO: Вернуть следующую пару в итератор.
         * //@throws NoSuchElementException - если больше нет элементов для итерации
         */
        @Override
        public Pair<K, V> next() {
            //if (!hasNext())throw new UnsupportedOperationException();
            return pair[index];

        }

        /**
         * TODO: Удалите предыдущую пару, возвращенную функцией next()
         */
        @Override
        public void remove() {
            //if(indexCount == 0) throw new UnsupportedOperationException();
            for (int i = index; i < indexCount-1; i++) {
                    pair[i] = pair[i+1];
            }
            indexCount--;
        }
    }
}
