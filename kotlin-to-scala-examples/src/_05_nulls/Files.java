package _05_nulls;

import java.io.File;

public class Files {
    public static void main(String[] args) {
        File[] files = new File("test").listFiles();
        System.out.println(files.length);
    }
}
