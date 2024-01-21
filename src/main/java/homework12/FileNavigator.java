package homework12;

import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap;
    public FileNavigator() {
        this.fileMap = new HashMap<>();
    }
    public List<FileData> find(String path) {
        return fileMap.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(String path, long maxSize) {
        List<FileData> files = fileMap.getOrDefault(path, new ArrayList<>());
        List<FileData> filteredFiles = new ArrayList<>();

        for (FileData file : files) {
            if (file.getSize() <= maxSize) {
                filteredFiles.add(file);
            }
        }

        return filteredFiles;
    }
    public void add(FileData fileData) {
        String path = fileData.getPath();

        // Перевірка консистентності
        if (!path.equals(getKeyFromPath(path))) {
            System.out.println("Error: Key path and file path do not match");
            return;
        }

        // Додавання файлу до відповідного шляху
        fileMap.computeIfAbsent(path, k -> new ArrayList<>()).add(fileData);
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> files : fileMap.values()) {
            allFiles.addAll(files);
        }

        allFiles.sort(new Comparator<FileData>() {
            @Override
            public int compare(FileData file1, FileData file2) {
                return Long.compare(file1.getSize(), file2.getSize());
            }
        });


        return allFiles;
    }

    // Метод для отримання ключа (шляху-ключа) з шляху
    private String getKeyFromPath(String path) {
        String[] pathParts = path.split("/");
        return pathParts[pathParts.length - 1];
    }

}
