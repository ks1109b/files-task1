import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] directories = {
                "Games/src/main",
                "Games/src/test",
                "Games/res/drawables",
                "Games/res/vectors",
                "Games/res/icons",
                "Games/savegames",
                "Games/temp"
        };

        String[] files = {
                "Games/src/main/Main.java",
                "Games/src/main/Utils.java",
                "Games/temp/temp.txt"
        };

        StringBuilder log = new StringBuilder();

        for (String dir : directories) {
            createDirectory(dir, log);
        }

        for (String file : files) {
            createFile(file, log);
        }

        try (FileWriter fw = new FileWriter("Games/temp/temp.txt")) {
            fw.write(log.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createDirectory(String path, StringBuilder log) {
        File dir = new File(path);
        if (dir.mkdirs()) {
            log.append("Directory ")
                    .append(path)
                    .append(" has been created.\n");
        } else {
            log.append("Directory ")
                    .append(path)
                    .append(" has not been created.\n");
        }
    }

    private static void createFile(String path, StringBuilder log) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                log.append("File ").append(path).append(" has been created.\n");
            } else {
                log.append("File ").append(path).append(" has not been created.\n");
            }
        } catch (IOException e) {
            log.append("File ")
                    .append(path)
                    .append(" ERROR: ")
                    .append(e.getMessage())
                    .append("\n");
        }
    }
}
