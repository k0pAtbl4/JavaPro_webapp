package fileWork;

import java.util.HashMap;

public class WordProcessor {
    private String filename;
    private HashMap<String, Integer> data;

    public WordProcessor(String filename) {
        this.filename = filename;
        this.data = new HashMap<>();
    }

    public void read() {
        if (!data.isEmpty()) {
            data.clear();
        }
        ioTool reader = new ioTool();
        String fileData = reader.readFile(filename);
        String[] words = new String[0];
        if (fileData != null) {
            fileData = fileData.replace(", ", " ").replace(". ", " ");
            words = fileData.split(" ");
        }
        for (int i = 0; i < words.length; i++) {
            if (data.containsKey(words[i])) {
                int count = data.get(words[i]) + 1;
                data.put(words[i], count);
            } else {
                data.put(words[i], 1);
            }
        }
    }

    public int findWord(String word) {
        int amount = 0;
        if (data.containsKey(word)) {
            amount = data.get(word);
        }
        return amount;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
