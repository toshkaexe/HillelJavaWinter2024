package homework11.task4zz;

public class WordOccurrence {
    private String name;
    private int occurrence;

    public WordOccurrence(String name) {
        this.name = name;
        this.occurrence = 1;
    }

    public String getName() {
        return name;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void incrementOccurrence() {
        this.occurrence++;
    }
}

