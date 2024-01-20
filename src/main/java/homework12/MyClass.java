package homework12;

public class MyClass {
    public static void main(String[] args) {

        FileNavigator fileNavigator = new FileNavigator();

        FileData file1 = new FileData("files.txt", 100, "/path/to/file");
        FileData file2 = new FileData("firstApp.java", 200, "/path/to/file");

        fileNavigator.add(file1);
        fileNavigator.add(file2);

        System.out.println("Files at /path/to/file: " + fileNavigator.find("/path/to/file"));

        System.out.println("Filtered files at /path/to/file by size (maxSize=150): " +
                fileNavigator.filterBySize("/path/to/file", 150));

        fileNavigator.remove("/path/to/file");

        System.out.println("All files sorted by size: " + fileNavigator.sortBySize());

    }
}
