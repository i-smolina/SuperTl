package com.example.supertl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperTlLibrary {

    public static void main(String[] args) {
        SpringApplication.run(SuperTlLibrary.class, args);

        Port port = new Port(args);

        Integer[][] digits= port.parse();
        System.out.println("Преобразовать массив строк в массив чисел:");
        Utils.printArray(digits);

        System.out.println("Вернуть уникальные упорядоченные группы:");
        Integer[][] seq = port.sequence();
        Utils.printArray(seq);
    }
}
