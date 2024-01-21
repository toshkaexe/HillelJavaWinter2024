package homework12;

import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap;

    public FileNavigator() {
        this.fileMap = new HashMap<>();
    }

    public void add(FileData file) {
        String path = file.getPath();
        if (fileMap.containsKey(path)) {
            List<FileData> fileList = fileMap.get(path);
            // Check consistency
            if (!fileList.isEmpty() && !fileList.get(0).getPath().equals(path)) {
                System.out.println("Error: Path inconsistency - Cannot add FileData with a different path.");
                return;
            }
            fileList.add(file);
        } else {
            List<FileData> fileList = new ArrayList<>();
            fileList.add(file);
            fileMap.put(path, fileList);
        }
    }

    public List<FileData> find(String path) {
        return fileMap.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(String path, long maxSize) {
        List<FileData> result = new ArrayList<>();
        if (fileMap.containsKey(path)) {
            for (FileData file : fileMap.get(path)) {
                if (file.getSize() <= maxSize) {
                    result.add(file);
                }
            }
        }
        return result;
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> fileList : fileMap.values()) {
            result.addAll(fileList);
        }
        result.sort(Comparator.comparingLong(FileData::getSize));
        return result;
    }
}
