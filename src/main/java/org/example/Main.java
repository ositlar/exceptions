package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (Фамилия Имя Отчество дата_рождения номер_телефона пол):");
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        if (data.length != 6) {
            throw new IllegalArgumentException("Ошибка: Введено неверное количество данных.");
        }
        try {
            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            if (!surname.matches("[а-яА-Я]+") || !name.matches("[а-яА-Я]+") || !patronymic.matches("[а-яА-Я]+")) {
                throw new IllegalArgumentException("Ошибка: Неверный формат ФИО.");
            }
            String dob = data[3];
            String[] checkDob = dob.split("\\.");
            if (checkDob.length == 3) {
                for (int i = 0; i < checkDob.length; i++) {
                    if (checkDob[i].length() < 2 || !checkDob[i].matches("[0-9]+") || checkDob[i].length() > 4) {
                        throw new IllegalArgumentException("Ошибка: Неверный формат даты рождения.");
                    }
                }
            }

            long phoneNumber;
            try {
                if (data[4].length() != 11 || !data[4].matches("[0-9]+")) {
                    throw new IllegalArgumentException("Ошибка: Неверный формат номера телефона.");
                }
                phoneNumber = Long.parseLong(data[4]);
            } catch (Exception e) {
                throw new IllegalArgumentException("Ошибка: Неверный формат номера телефона.");
            }
            char gender = data[5].charAt(0);
            if (gender != 'm' && gender != 'f') {
                throw new IllegalArgumentException("Ошибка: Неверный формат пола.");
            }

            File file = new File(surname + ".txt");
            FileWriter writer = new FileWriter(file, true);
            writer.write(surname + " " + name + " " + patronymic + " " + dob + " " + phoneNumber + " " + gender + "\n");
            writer.close();
            System.out.println("Данные успешно записаны в файл: " + file.getName());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи в файл.");
        }
    }
}