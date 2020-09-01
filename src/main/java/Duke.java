import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        String line = "__________________________________";
        System.out.println("Hello from\n" + logo);
        System.out.println(line);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println(line + "\n");

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        while(!command.equalsIgnoreCase("Bye")) {
            System.out.println(line);
            System.out.println(command);
            System.out.println(line + "\n");
            command = sc.nextLine();
        }
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(line + "\n");

    }
}

