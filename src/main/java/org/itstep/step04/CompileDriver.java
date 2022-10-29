package org.itstep.step04;

import org.itstep.step02.Pair;

/**
 * Обобщения. Вопросы о компиляции
 *
 * @author Nathan Sprague
 * @version V1, 8/2016
 */
public class CompileDriver {

    public static void main(String[] args) {

        // TODO: перед удалением комментариев отметьте каждую строчку, где есть присвоение - сокмпилируется ли код или нет
        Pair<String, Integer> p1;
        Pair<String, Number> p2;
        Pair<Object, Object> p3;
        Pair<?, ?> p4;
        Pair<?, ? extends Number> p5;

        p1 = new Pair<String, Integer>("A", 7); // об'єкт створиться
        int a = p1.getSecond(); // скомпілюється

    //    p1 = new Pair<Integer, Double>(23, 12.0);  // не скомпілюється, різні типи

    //    p2 = new Pair<String, Integer>("B", 8);  // не скомпілюється, т.я передаться клас Integer не extends Number

    //    p3 = new Pair<String, Integer>("C", 9);  // не скомпілюється, т.я передаться класи String i Integer не extends Object

        p4 = new Pair<String, String>("House", "Car"); // скомпілюється
        p4 = new Pair<String, Integer>("D", 10); // скомпілюється

    //    Integer b = p4.getSecond(); // не скомпілюється, потрібне явне приведення
        Integer c = (Integer) p4.getSecond();  //скомпілюється

    //    p5 = new Pair<String, String>("E", "G");  // не скомпілюється різні типи у другому параметрі
        p5 = new Pair<String, Double>("E", 11.0); // скомпілюється Double похідний від Number
        p5 = new Pair<String, Integer>("E", 11);  // скомпілюється Integer похідний від Number

    //    Integer d = p5.getSecond();  // не скомпілюється, потрібне явне приведення
        Integer e = (Integer) p5.getSecond();  // скомпілюється
    }

}
