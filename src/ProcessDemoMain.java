import java.util.Arrays;

public class ProcessDemoMain {
    public static void main(String[] args) {
        ProcessUtils.runCommand(Arrays.asList("cmd", "/c", "dir"));


    }
}