package com.javarush.task.pro.task15.task1519;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Поверхностное копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());

        try (DirectoryStream<Path> dirStreamSource = Files.newDirectoryStream(sourceDirectory)) {
            for (Path item : dirStreamSource) {
                if (Files.isRegularFile(item)) {
                    Path resolve = targetDirectory.resolve(item.getFileName());
                    Files.copy(item, resolve);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

