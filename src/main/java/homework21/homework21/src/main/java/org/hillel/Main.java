package org.hillel;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
      String directoryPath = "src/main/java/homework21/homework21/src/main/java/org/hillel";
        convertFiles(directoryPath);
    }

    public static void convertFiles(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        File convertedDir = new File(directory, "converted");
        if (!convertedDir.exists()) {
            convertedDir.mkdir();
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Error listing files in directory.");
            return;
        }

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