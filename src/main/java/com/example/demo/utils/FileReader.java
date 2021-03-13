package com.example.demo.utils;

public class FileReader {
    public static List<String> read(String path) {
        List<String> dataListFromFile = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            dataListFromFile = reader.lines().skip(1).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataListFromFile;
    }
}
