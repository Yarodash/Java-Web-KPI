import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class FileProcess implements Runnable {

    final private String file_from, file_to, filename;

    FileProcess(String folder_from, String folder_to, String filename) {
        file_from = new File(folder_from, filename).getAbsolutePath();
        file_to = new File(folder_to, filename).getAbsolutePath();
        this.filename = filename;
    }

    private void do_process() throws IOException, InterruptedException {

        System.out.printf("Thread '%s' (%s) started.\n", Thread.currentThread().getName(), filename);

        BufferedReader reader = new BufferedReader(new FileReader(file_from));

        ArrayList<String> str = new ArrayList<>();
        String line = "";
        while((line=reader.readLine())!=null){
            str.add(line);
        }
        reader.close();

        System.out.printf("Thread '%s' (%s) read file.\n", Thread.currentThread().getName(), filename);

        Collections.sort(str);
        Thread.sleep(1000);

        System.out.printf("Thread '%s' (%s) sorted lines.\n", Thread.currentThread().getName(), filename);

        FileWriter writer = new FileWriter(file_to);
        for(String s: str){
            writer.write(s);
            writer.write("\r\n");
        }
        writer.close();

        System.out.printf("Thread '%s' (%s) finished.\n", Thread.currentThread().getName(), filename);

    }

    @Override
    public void run() {
        try {
            do_process();
        } catch (IOException | InterruptedException e) {
            System.out.printf("Thread '%s' got exception (%s).\n", Thread.currentThread().getName(), filename);
        }
    }
}
