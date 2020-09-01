import java.util.Scanner;

public class Duke {
    public static void printGreeting(){
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
    }

    public static void printLine(){
        String line = "__________________________________";
        System.out.println(line);
    }

    public static void printExit(){
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
        System.out.println();
    }

    public static void main(String[] args) {
        printGreeting();

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        String[] tasks = new String[100];
        int numberOfTasks = 0;

        while(!command.equalsIgnoreCase("Bye")) {
            if(!command.equalsIgnoreCase("list")){
                printLine();
                System.out.println("added: " + command);
                printLine();
                System.out.println();
                tasks[numberOfTasks++] = command;
            }
            else {
                printLine();
                for(int i=0; i<numberOfTasks; i++){
                    System.out.println(i+1 + ". " + tasks[i]);
                }
                printLine();
                System.out.println();
            }
            command = sc.nextLine();
        }
        printExit();

    }
}

