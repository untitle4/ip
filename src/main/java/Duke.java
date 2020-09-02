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

        /*while(!command.equalsIgnoreCase("Bye")){
            if(command.equalsIgnoreCase("list")){
                printLine();
                System.out.println("Here are the tasks in your list:");
                for(int i=0; i<Task.getNumbers(); i++){
                    System.out.println(i+1 + ".");
                }
                printLine();
                System.out.println();
            }
            else if(command.equalsIgnoreCase("Done")){

            }
            else{
                Task t = new Task(command);
                printLine();
                System.out.println("added: " + command);
                printLine();
                System.out.println();
            }

        }*/


        String[] tasks = new String[100];
        Boolean[] isDone = new Boolean[100];
        String[] typeOfTasks = new String[100];
        int numberOfTasks = 0;

        while(!command.equalsIgnoreCase("Bye")) {
            if(command.equalsIgnoreCase("list")){
                printLine();
                System.out.println("Here are the tasks in your list:");
                for(int i=0; i<numberOfTasks; i++){
                    String isTure = isDone[i] ? "[\u2713] " : "[\u2718] ";
                    System.out.println(i+1 + "." + typeOfTasks[i] + isTure + tasks[i]);
                }
                printLine();
                System.out.println();
            }
            else if(command.startsWith("todo")){
                String toDo = command.substring(5);
                tasks[numberOfTasks] = toDo;
                typeOfTasks[numberOfTasks] = "[T]";
                isDone[numberOfTasks++] = false;
                printLine();
                System.out.println("Got it. I've added this task:");
                System.out.println("  [T]" + "[\u2718] " + toDo);
                System.out.println("Now you have " + numberOfTasks + " tasks in the list.");
                printLine();
            }
            else if(command.startsWith("deadline")){
                String ddl = command.substring(9, command.indexOf("/"));
                String timeForDeadline = command.substring(command.indexOf("/")+4);
                tasks[numberOfTasks] = ddl + " (by: " + timeForDeadline + ")";
                typeOfTasks[numberOfTasks] = "[D]";
                isDone[numberOfTasks++] = false;
                printLine();
                System.out.println("Got it. I've added this task:");
                System.out.print("  [T]" + "[\u2718] " + ddl);
                System.out.println(" (by: " + timeForDeadline + ")");
                System.out.println("Now you have " + numberOfTasks + " tasks in the list.");
                printLine();
            }
            else if(command.startsWith("event")){
                String event = command.substring(6, command.indexOf("/"));
                String timeOfEvent = command.substring(command.indexOf("/")+4);
                tasks[numberOfTasks] = event + (" (at: " + timeOfEvent + ")");
                typeOfTasks[numberOfTasks] = "[E]";
                isDone[numberOfTasks++] = false;
                printLine();
                System.out.println("Got it. I've added this task:");
                System.out.print("  [T]" + "[\u2718] " + event);
                System.out.println(" (at: " + timeOfEvent + ")");
                System.out.println("Now you have " + numberOfTasks + " tasks in the list.");
                printLine();
            }
            else if(command.substring(0,4).equalsIgnoreCase("Done")){
                String id = command.substring(5);
                int idInt = Integer.parseInt(id)-1;
                isDone[idInt] = true;
                printLine();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[\u2713] " + tasks[idInt]);
                printLine();
                System.out.println();
            }
            else {
                printLine();
                System.out.println("added: " + command);
                printLine();
                System.out.println();
                tasks[numberOfTasks] = command;
                typeOfTasks[numberOfTasks] = "[W]";
                isDone[numberOfTasks++] = false;
            }
            command = sc.nextLine();
        }

        printExit();

    }
}

