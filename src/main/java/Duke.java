import task.Deadline;
import task.Event;
import task.Todo;
import task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class Duke {
    public static void printGreeting(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
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

    public static void printTask(ArrayList<Task> tasks, int n){
        printLine();
        System.out.println("Got it. I've added this task:  ");
        System.out.println(tasks.get(n++));
        System.out.println("Now you have " + n + (n == 1 ? " task" : " tasks") + " in your list.");
        printLine();
    }

    public static void printExit(){
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
        System.out.println();
    }

    public static int addTask(ArrayList<Task> tasks, String command, int numberOfTasks) throws DukeException{
        if(command.equalsIgnoreCase("list")){
            printLine();
            System.out.println("Here are the tasks in your list:");
            for(int i=0; i<numberOfTasks; i++){
                System.out.println(i+1 + "." + tasks.get(i));
            }
            printLine();
        }

        else if(command.startsWith("delete")){
            int index = Integer.parseInt(command.substring(7)) - 1;
            if(index < numberOfTasks){
                printLine();
                System.out.println("Noted. I've removed this task:");
                System.out.println("  " + tasks.get(index));
                tasks.remove(index);
                System.out.println("Now you have " + tasks.size() + (tasks.size() == 1 ? " task" : " tasks") + " in your list.");
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
                tasks.get(index).setDone();
                printLine();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[\u2713] " + tasks.get(index).description);
                printLine();
            }
            else {
                printLine();
                System.out.println("☹ OOPS!!! There is no such a task in your list.");
                printLine();
            }
        }

        else if(command.startsWith("deadline")){
            tasks.add(new Deadline(command.substring(9, command.indexOf("/")),
                    command.substring(command.indexOf("/") + 4)));
            printTask(tasks, numberOfTasks);
        }

        else if(command.startsWith("event")){

            tasks.add(new Event(command.substring(6, command.indexOf("/")),
                    command.substring(command.indexOf("/") + 4)));
            printTask(tasks, numberOfTasks);

        }

        else if(command.startsWith("todo")){
            tasks.add(new Todo(command.substring(5)));
            printTask(tasks, numberOfTasks);
        }

        else{
            throw new DukeException();
        }

        return tasks.size();
    }

    private static void writeToFile(String filePath, ArrayList<Task> tasks, int number) throws IOException{
        FileWriter fw = new FileWriter(filePath);
        for(int i=0; i<number; i++){
            String thisTask = String.valueOf(tasks.get(i));
            if(thisTask.indexOf("T") == 1){
                fw.write("T |");
            }
            else if(thisTask.indexOf("D") == 1)
            {
                fw.write("D |");
            }
            else if(thisTask.indexOf("E") == 1)
            {
                fw.write("E |");
            }

            if(tasks.get(i).getStatus()){
                fw.write(" 1 | ");
            }
            else{
                fw.write(" 0 | ");
            }

            if(thisTask.indexOf("T") == 1){
                fw.write(tasks.get(i).description);
                fw.write(System.lineSeparator());
            }
            else{
                fw.write(thisTask.substring(7, thisTask.indexOf("(") - 1));
                fw.write(" /" +
                        thisTask.substring((thisTask.indexOf("(") + 1),
                                thisTask.indexOf(")")));
                fw.write(System.lineSeparator());
            }
        }
        fw.close();
    }


    public static void main(String[] args) {
        printGreeting();

        String fileDuke = "data/Duke.txt";
        //String fileDuke = "Duke.txt";

        //Task[] tasks = new Task[100];
        ArrayList<Task> tasks = new ArrayList<>(100);
        int numberOfTasks = 0;

        try{
            File f = new File(fileDuke);
            Scanner s = new Scanner(f);
            while(s.hasNext()){
                String thisTask = s.nextLine();
                if(thisTask.startsWith("T")){
                    tasks.add(new Todo(thisTask.substring(8)));
                }
                else if(thisTask.startsWith("D")){
                    tasks.add(new Deadline(thisTask.substring(8, thisTask.indexOf("/")),
                            thisTask.substring(thisTask.indexOf("/") + 4)));
                }
                else if(thisTask.startsWith("E")){
                    tasks.add(new Event(thisTask.substring(8, thisTask.indexOf("/")),
                                    thisTask.substring(thisTask.indexOf("/") + 4)));
                }
                numberOfTasks = tasks.size();
                if(thisTask.charAt(4) == '1'){
                    tasks.get(numberOfTasks - 1).setDone();
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (StringIndexOutOfBoundsException e) {
            printLine();
            System.out.println("☹ OOPS!!! The description of a task cannot be empty.");
            printLine();
        } catch(NumberFormatException e){
            printLine();
            System.out.println("☹ OOPS!!! The description of a task cannot be empty.");
            printLine();
        }


        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        //using class

        while(!command.equalsIgnoreCase("Bye")){
            try{
                numberOfTasks = addTask(tasks, command, tasks.size());
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

            try{
                for(int i=0; i<numberOfTasks; i++){
                    writeToFile(fileDuke, tasks, numberOfTasks);
                }
            } catch(IOException e){
                System.out.println("Something went wrong: " + e.getMessage());
            }

            command = sc.nextLine();
        }

        printExit();

    }
}

