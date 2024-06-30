import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("C://Games"),
                new File("C://Games//temp"),
                new File("C://Games//src"),
                new File("C://Games//res"),
                new File("C://Games//savegames"),
                new File("C://Games//src//main"),
                new File("C://Games//src//test"),
                new File("C://Games//res//drawables"),
                new File("C://Games//res//vectors"),
                new File("C://Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("C://Games//src//main//Main.java"),
                new File("C://Games//src//main//Utils.java"),
                new File("C://Games//temp//temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Каталог " + folder + " создан\n");
            else sb.append("Каталог " + folder + " не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("D://Games//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("C://Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}