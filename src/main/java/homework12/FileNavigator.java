package homework12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            System.out.println("Помилка: Шлях-ключ і шлях до файлу не співпадають");
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

        allFiles.sort((file1, file2) -> Long.compare(file1.getSize(), file2.getSize()));

        return allFiles;
    }

    private String getKeyFromPath(String path) {
        // Метод для отримання ключа (шляху-ключа) з шляху
        // Реалізація може бути змінена в залежності від вашого формату шляхів
        // У цьому прикладі просто повертаємо останній каталог у шляху
        String[] pathParts = path.split("/");
        return pathParts[pathParts.length - 1];
    }


}
