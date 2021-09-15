package ru.filimonov.hotelbusinessdatagenerator.generator;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Time;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private static final Random r = new Random();
    private static final int millisInDay = 24 * 60 * 60 * 1000;


    public static String generateText() {
        int length = r.nextInt(200);
        String s = r.ints(48, 122)
                .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return s;
    }

    public static String generatePhone() {
        return String.format("+7(9%d%d)%d%d%d-%d%d-%d%d", r.nextInt(10),
                r.nextInt(10), r.nextInt(10), r.nextInt(10),
                r.nextInt(10), r.nextInt(10), r.nextInt(10),
                r.nextInt(10), r.nextInt(10));
    }

    public static Integer generatePrice() {
        return 1000 + r.nextInt(10) * r.nextInt(10) * 1000;
    }

    public static String generateImageUrl() throws IOException {
        File resource = new ClassPathResource("room.txt").getFile();
        final List<String> urlsList = Files.readAllLines(resource.toPath());
        return urlsList.get(r.nextInt(urlsList.size()));
    }

    public static Time[] generateTimeInterval() {
        Time start = new Time(r.nextInt(millisInDay));
        Time end = new Time(start.getTime() + r.nextInt(1000 * 60 * 60));
        return new Time[]{start, end};
    }


}
