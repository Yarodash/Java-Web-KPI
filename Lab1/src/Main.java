import java.io.File;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        String folder_from;
        while (true) {
            System.out.print("Input folder: ");
            folder_from = scanner.nextLine();

            if (new File(folder_from).exists())
                break;

            System.out.println("Try again!");
        }

        String folder_to;
        while (true) {
            System.out.print("Output folder: ");
            folder_to = scanner.nextLine();

            if (!Objects.equals(folder_to, folder_from))
                break;

            System.out.println("Try again!");
        }

        int threads_count;
        while (true) {
            System.out.print("nThreads: ");
            threads_count = scanner.nextInt();
            if (threads_count > 0 && threads_count <= 64)
                break;

            System.out.println("Try again!");
        }

        ExecutorService executor = Executors.newFixedThreadPool(threads_count);

        new File(folder_to).mkdirs();

        File[] files = new File(folder_from).listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith("txt")) {
                executor.execute(new FileProcess(folder_from, folder_to, file.getName()));
            }
        }

        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException ignored) {}

        System.out.println("Executor terminated.");
    }
}