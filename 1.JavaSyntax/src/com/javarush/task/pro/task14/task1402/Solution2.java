package com.javarush.task.pro.task14.task1402;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        createMap();
    }
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> names = new HashMap<>();
        names.put("Сидоров", "Василий");
        names.put("Лентяев", "Николай");
        names.put("Слюнтяев", "Николай");
        names.put("Козлов", "Василий");
        names.put("Иванов", "Генадий");
        names.put("Васнецов", "Александр");
        names.put("Борцов", "Леонид");
        names.put("Кузнецов", "Александр");
        names.put("Свинцов", "Сергей");
        names.put("Бомжев", "Алексей");

        for (var item : names.entrySet()) {
            System.out.println(item);
        }
        return names;
    }
}
