import task.Deadline;
import task.Event;
import task.Todo;
import task.Task;

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
        printLine();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        printLine();
    }

    public static void printLine(){
        String line = "__________________________________";
        System.out.println(line);
    }

    public static void printTask(Task thisTask, int n){
        printLine();
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + thisTask);
        System.out.println("Now you have " + n + (n == 1 ? " task" : " tasks") + " in your list.");
        printLine();
    }

    public static void printExit(){
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
        System.out.println();
    }

    public static int addTask(Task[] tasks, String command, int numberOfTasks) throws DukeException{
        if(command.equalsIgnoreCase("list")){
            printLine();
            System.out.println("Here are the tasks in your list:");
            for(int i=0; i<numberOfTasks; i++){
                System.out.println(i+1 + "." + tasks[i]);
            }
            printLine();
        }

        else if(command.startsWith("delete")){
            int index = Integer.parseInt(command.substring(7)) - 1;
            if(index < numberOfTasks){
                printLine();
                System.out.println("Noted. I've removed this task:");
                System.out.println("  " + tasks[index]);
                System.arraycopy(tasks, index + 1, tasks, index, numberOfTasks - index);
                numberOfTasks--;
                System.out.println("Now you have " + numberOfTasks + (numberOfTasks == 1 ? " task" : " tasks") + " in your list.");
                printLine();

            }
            else {
                printLine();
                System.out.println("☹ OOPS!!! There is no such a task in your list.");
                printLine();
            }
        }

        else if(command.startsWith("done")){
            int index = Integer.parseInt(command.substring(5)) - 1;
            if(index < numberOfTasks){
                tasks[index].setDone();
                printLine();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[\u2713] " + tasks[index].description);
                printLine();
            }
            else {
                printLine();
                System.out.println("☹ OOPS!!! There is no such a task in your list.");
                printLine();
            }
        }

        else if(command.startsWith("deadline")){
            tasks[numberOfTasks] = new Deadline(command.substring(9, command.indexOf("/")),
                    command.substring(command.indexOf("/") + 4));
            printTask(tasks[numberOfTasks], numberOfTasks+1);
            numberOfTasks++;
        }

        else if(command.startsWith("event")){

            tasks[numberOfTasks] = new Event(command.substring(6, command.indexOf("/")),
                    command.substring(command.indexOf("/") + 4));
            printTask(tasks[numberOfTasks], numberOfTasks+1);
            numberOfTasks++;

        }

        else if(command.startsWith("todo")){
            tasks[numberOfTasks] = new Todo(command.substring(5));
            printTask(tasks[numberOfTasks], numberOfTasks+1);
            numberOfTasks++;
        }

        else{
            throw new DukeException();
        }

        return numberOfTasks;
    }

    public static void main(String[] args) {
        printGreeting();

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        //using class
        Task[] tasks = new Task[100];
        int numberOfTasks = 0;

        while(!command.equalsIgnoreCase("Bye")){
            try{
                numberOfTasks = addTask(tasks, command, numberOfTasks);
            } catch(DukeException e){
                printLine();
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                printLine();
            } catch (StringIndexOutOfBoundsException e) {
                printLine();
                System.out.println("☹ OOPS!!! The description of a " + command + " cannot be empty.");
                printLine();
            } catch(NumberFormatException e){
                printLine();
                System.out.println("☹ OOPS!!! The description of a " + command + " cannot be empty.");
                printLine();
            }


            command = sc.nextLine();
        }

        printExit();

    }
}

