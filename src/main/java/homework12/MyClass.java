package homework12;

import java.util.List;

public class MyClass {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        FileData file1 = new FileData("files.txt", 100, "/path/to/file");
        FileData file2 = new FileData("firstApp.java", 200, "/path/to/file");
        FileData file3 = new FileData("anotherFile.txt", 150, "/another/path/");

        fileNavigator.add(file1);
        fileNavigator.add(file2);
        fileNavigator.add(file3);  // This should print an error due to path inconsistency

        List<FileData> filesAtPath = fileNavigator.find("/path/to/file");
        System.out.println("Files at /path/to/file: " + filesAtPath.toString());

        List<FileData> filteredFiles = fileNavigator.filterBySize("/path/to/file", 150);
        System.out.println("Files at /path/to/file with size <= 150: " + filteredFiles);

        fileNavigator.remove("/path/to/file");
        filesAtPath = fileNavigator.find("/path/to/file");
        System.out.println("Files at /path/to/file after removal: " + filesAtPath);

        List<FileData> sortedFiles = fileNavigator.sortBySize();
        System.out.println("Sorted files by size: " + sortedFiles);
    }

}
