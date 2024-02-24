package org.hillel;

import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        String directoryPath;

        if(args.length == 0) {
            System.out.println("Анализ текущей дикертории");
            directoryPath = System.getProperty("user.dir");
            System.out.println(directoryPath);
        } else {
            System.out.println("Аргументы командной строки:");
            for(int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
             directoryPath = args[0];
        }

        convertFiles(directoryPath);
    }

    public static void convertFiles(String directoryPath) {
        File directory = new File(directoryPath);
        System.out.println(directory.toString());
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }
        File convertedDir = new File(directory, "converted");
        System.out.println(convertedDir);
        // Проверяем, существует ли папка "converted"
        if (convertedDir.exists()) {
            // Если папка существует, очищаем ее содержимое
            clearDirectory(convertedDir);
        } else {
            // Если папка не существует, создаем ее
            convertedDir.mkdir();
        }


        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Error listing files in directory.");
            return;
        }

        boolean hasJsonOrYamlFiles = Arrays.stream(files)
                .anyMatch(file -> file.isFile() &&
                        (file.getName().endsWith(".json") || file.getName().endsWith(".yaml")));

        // Если среди файлов нет файлов с расширением .json или .yaml, выводим сообщение
        if (!hasJsonOrYamlFiles) {
            System.out.println("In this current dir we do not have  any json- or yaml- files" );
        }

        // Преобразуем массив файлов в поток (Stream<File>)
        Arrays.stream(files)
                // Фильтруем только файлы (не каталоги)
                .filter(File::isFile)
                // Преобразуем каждый файл в его имя (String)
                .map(File::getName)
                // Выводим каждое имя файла на консоль
                .forEach(System.out::println);
        try (FileWriter logFileWriter = new FileWriter(new File(directory, "result.log"))) {
            for (File file : files) {
                if (file.isFile()) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".json")) {
                        String outputFileName = fileName.replace(".json", ".yaml");
                        File outputFile = new File(convertedDir, outputFileName);
                       try {
                            long startTime = System.currentTimeMillis();
                             convertJsonToYaml(file, outputFile);
                            long endTime = System.currentTimeMillis();
                            long duration = endTime - startTime;
                            String logEntry = String.format("%s -> %s, %dms, %d -> %d\n",
                                    fileName, outputFileName, duration, file.length(), outputFile.length());
                           logFileWriter.write(logEntry);
                        } catch (IOException e) {
                            System.out.println("Error converting file: " + fileName);
                            e.printStackTrace();
                        }
                    } else if (fileName.endsWith(".yaml")) {
                        String outputFileName = fileName.replace(".yaml", ".json");
                        File outputFile = new File(convertedDir, outputFileName);
                        try {
                            long startTime = System.currentTimeMillis();
                            convertYamlToJson(file, outputFile);
                            long endTime = System.currentTimeMillis();
                            long duration = endTime - startTime;
                            String logEntry = String.format("%s -> %s, %dms, %d -> %d\n",
                                    fileName, outputFileName, duration, file.length(), outputFile.length());
                            logFileWriter.write(logEntry);
                        } catch (IOException e) {
                            System.out.println("Error converting file: " + fileName);
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error writing to log file.");
            e.printStackTrace();
        }
    }

    private static void clearDirectory(File directory) {
        // Получаем список файлов и подкаталогов в указанной директории
        File[] files = directory.listFiles();

        // Проверяем, что список файлов не пуст
        if (files != null) {
            // Проходимся по каждому файлу и подкаталогу в папке
            for (File file : files) {
                // Если это файл, удаляем его
                if (file.isFile()) {
                    file.delete();
                }
                // Если это каталог, вызываем метод clearDirectory для рекурсивного удаления его содержимого
                else if (file.isDirectory()) {
                    clearDirectory(file);
                }
            }
        }
    }

    public static void convertJsonToYaml(File jsonFile, File yamlFile) throws IOException {
        try (InputStream inputStream = new FileInputStream(jsonFile);
             OutputStream outputStream = new FileOutputStream(yamlFile)) {

            Gson gson = new Gson();

            InputStreamReader reader = new InputStreamReader(inputStream);
            Object json = gson.fromJson(reader, Object.class);

            // Convert JSON to YAML
            Yaml yaml = new Yaml();
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            String yamlString = yaml.dump(json);
            outputStream.write(yamlString.getBytes());
        }
      }


    public static void convertYamlToJson(File yamlFile, File jsonFile) throws IOException {

        try (InputStream inputStream = new FileInputStream(yamlFile);
             OutputStream outputStream = new FileOutputStream(jsonFile)) {
            Yaml yaml = new Yaml();
            StringBuilder sb = new StringBuilder();

            int data;
            while ((data = inputStream.read()) != -1) {
                sb.append((char) data);
            }

            Object yamlObject = yaml.load(sb.toString());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String str = gson.toJson(yamlObject);

            outputStream.write(str.getBytes());
        }
    }

}