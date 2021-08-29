package com.generator;

import java.math.BigDecimal;
import java.time.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class DataGeneration {

    public static String generateWord(int length, boolean capitalLetter, boolean eng, Random r){
        length = r.nextInt(length) + 1;
        String symbols_rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        String symbols_eng = "abcdefghijklmnopqrstuvwxyz";
        String s;
        if (eng) {
            s = r.ints(length, 0, symbols_eng.length())
                    .mapToObj(symbols_eng::charAt)
                    .map(Object::toString)
                    .collect(Collectors.joining());
        } else {
            s = r.ints(length, 0, symbols_rus.length())
                    .mapToObj(symbols_rus::charAt)
                    .map(Object::toString)
                    .collect(Collectors.joining());
        }
        if (capitalLetter) return s.substring(0, 1).toUpperCase() + s.substring(1);
        else return s;
    }

    public static String generateText(int length, boolean eng, boolean allCapitalLetter, Random r){
        length = r.nextInt(length);
        StringBuilder text;
        if (eng){
            text = new StringBuilder(generateWord(20, true, true, r));
                if (allCapitalLetter) {
                    for (int i = 0; i < length; i++ ) {
                        text.append(" ").append(generateWord(20, true, true, r));
                    }
            } else {
                    for (int i = 0; i < length; i++ ) {
                        text.append(" ").append(generateWord(20, false, true, r));
                        }
                }
        } else {
            text = new StringBuilder(generateWord(20, true, false, r));
            if (allCapitalLetter) {
                for (int i = 0; i < length; i++ ) {
                    text.append(" ").append(generateWord(20, true, false, r));
                }
            } else {
                for (int i = 0; i < length; i++ ) {
                    text.append(" ").append(generateWord(20, false, false, r));
                }
            }
        }
        return text.toString();
    }

    public static Integer generateNumber (int min, int max, Random r){
        return r.nextInt((max - min)+ 1) + min;
    }

    public static String generateNumberSequence(int length, Random r){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++){
            s.append(generateNumber(0, 9, r));
        }
        return s.toString();
    }

    public static Boolean generateBoolean(Random r){
        return r.nextBoolean();
    }

    public static BigDecimal generateMoney(int min, int max, Random r){
        StringBuilder s = new StringBuilder();
        s.append(generateNumber(min, max, r));
        if (Integer.parseInt(s.toString()) == max) {
            s.append(".00");
        } else {
            int afterPoint = generateNumber(0, 99, r);
            if (afterPoint == 0){
                s.append(".00");
            } else if (afterPoint >= 1 && afterPoint <= 9) {
                s.append(String.format(".0%d", afterPoint));
            } else {
                s.append(String.format(".%d", afterPoint));
            }
        }
        return new BigDecimal(s.toString());
    }

    public static String generatePhone(Random r) {
        String phone = "+79";
        return phone + generateNumberSequence(9, r);
    }

    public static String generateEmail(Random r){
        String lettersLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String lettersUpperCase = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        String numbers = "0123456789";
        String symbols = "!#$%&'*+-/=?^_`{|}~";
        int length1 = r.nextInt(15) + 1;
        int length2 = r.nextInt(5) + 1;
        String allSymbols1 = lettersLowerCase + lettersUpperCase + numbers;
        String allSymbols2 = lettersLowerCase + lettersUpperCase + numbers + symbols;
        String name = r.ints(length1, 0, allSymbols2.length())
                .mapToObj(allSymbols2::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        String domenLeft = r.ints(length1, 0, allSymbols1.length())
                .mapToObj(allSymbols1::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        String domenRight = r.ints(length2, 0, allSymbols1.length())
                .mapToObj(allSymbols1::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        return name + "@" + domenLeft + "." + domenRight;
    }

    public static String generatePolicyNumber(Random r) {
        String s;
        String symbols = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        int i = r.nextInt(symbols.length());
        return s = symbols.charAt(i) + generateNumberSequence(4, r) + "-" + generateNumberSequence(9, r);
    }

    public static LocalDateTime generateDateBetween(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);
        return LocalDateTime.from(LocalDate.ofEpochDay(randomDay).atTime(LocalTime.now()));
    }

}
