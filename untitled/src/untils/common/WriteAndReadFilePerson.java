package untils.common;

import model.person.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFilePerson {
    public static List<String> readFile(String path) {
        List<String> strings = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File không tồn tại");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return strings;
    }

    public static void writeFile(String path, List<String> strings, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(path, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(String str: strings) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Lôi đọc file");
        }
    }

}
