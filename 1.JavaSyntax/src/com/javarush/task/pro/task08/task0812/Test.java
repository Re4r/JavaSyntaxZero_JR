package com.javarush.task.pro.task08.task0812;

import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        // Карта, в которой мы будем хранить количество выпадений какого-то числа
        Map<Integer, Integer> map = new TreeMap<>();

        // За 10000 операций
        for (int i = 0; i < 10000; i++) {

            // Сгенерируем рандомное число от -10 включительно до 10 включительно
            final Integer randomNumber = randomInARange(-10, 10);


            if (!map.containsKey(randomNumber)) {
                // Если карта еще не содержит "выпавшего случайного числа"
                // Положим его в карту с кол-вом выпадений = 1
                map.put(randomNumber, 1);
            } else {
                // Иначе, увеличим количество выпадений данного числа на 1
                map.put(randomNumber, map.get(randomNumber) + 1);
            }
        }

        // Выведем на экран содержимое карты в формате ключ=[значение]
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(String.format("%d=[%d]", entry.getKey(), entry.getValue()));
        }
    }

    static int randomInARange(int min, int max) {
        return  (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
