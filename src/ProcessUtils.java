import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ProcessUtils {

    public static int runCommand(List<String> command) {
        ProcessBuilder pb = new ProcessBuilder(command);
        System.out.println("Commande : " + command);

        try {
            Process process = pb.start();

            BufferedReader stdOut = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            BufferedReader stdErr = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );

            String line;

            System.out.println("----- Sortie standard -----");
            while ((line = stdOut.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("----- Sortie d'erreur -----");
            while ((line = stdErr.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Code de sortie : " + exitCode);
            return exitCode;

        } catch (IOException e) {
            System.err.println("Erreur lors du lancement du processus : " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Le thread courant a été interrompu : " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        return -1;
    }
}