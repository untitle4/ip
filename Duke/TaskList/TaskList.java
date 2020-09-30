package Duke.TaskList;

import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.util.ArrayList;

public class TaskList {
    public ArrayList<Task> tasks = new ArrayList<>(100);
    String line = "__________________________________";

    public void printList(){
        printLine();
        System.out.println("Here are the tasks in your list:");
        for(int i=0; i<tasks.size(); i++){
            System.out.println(i+1 + "." + tasks.get(i));
        }
        printLine();
    }

    public void addTodo(String command){
        try{
            tasks.add(new Todo(command.substring(5)));
            printTask(tasks, tasks.size());
        } catch (StringIndexOutOfBoundsException e) {
            printLine();
            System.out.println("☹ OOPS!!! The description of a " + command + " cannot be empty.");
            printLine();
        } catch(NumberFormatException e){
            printLine();
            System.out.println("☹ OOPS!!! The description of a " + command + " cannot be empty.");
            printLine();
        }
    }

    public void addEvent(String command){
        try{
            tasks.add(new Event(command.substring(6, command.indexOf("/")),
                    command.substring(command.indexOf("/") + 4)));
            printTask(tasks, tasks.size());
        } catch (StringIndexOutOfBoundsException e) {
            printLine();
            System.out.println("☹ OOPS!!! The description of a " + command + " cannot be empty.");
            printLine();
        } catch(NumberFormatException e){
            printLine();
            System.out.println("☹ OOPS!!! The description of a " + command + " cannot be empty.");
            printLine();
        }
    }

    public void addDeadline(String command){
        try{
            tasks.add(new Deadline(command.substring(9, command.indexOf("/")),
                    command.substring(command.indexOf("/") + 4)));
            printTask(tasks, tasks.size());
        } catch (StringIndexOutOfBoundsException e) {
            printLine();
            System.out.println("☹ OOPS!!! The description of a " + command + " cannot be empty.");
            printLine();
        } catch(NumberFormatException e){
            printLine();
            System.out.println("☹ OOPS!!! The description of a " + command + " cannot be empty.");
            printLine();
        }
    }

    public void delete(String command){
        try{
            int index = Integer.parseInt(command.substring(7)) - 1;
            if(index < tasks.size()){
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
        }catch(NumberFormatException e){
            printLine();
            System.out.println("☹ OOPS!!! The description of a \" + command + \" cannot be empty.");
            printLine();
        } catch(StringIndexOutOfBoundsException e){
            printLine();
            System.out.println("☹ OOPS!!! The description of a \" + command + \" cannot be empty.");
            printLine();
        }
    }

    public void done(String command){
        int index = Integer.parseInt(command.substring(5)) - 1;
        if(index < tasks.size()){
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

    public void find(String command){
        String tasksToFind = command.substring(5);
        printLine();
        System.out.println("Here are the matching tasks in your list:");
        for(int i=0, n=1; i<tasks.size(); i++){
            String thisTask = tasks.get(i).toString();
            if(thisTask.contains(tasksToFind)){
                System.out.println(n + ". " + thisTask);
                n++;
            }
        }
        printLine();
    }

    public void printTask(ArrayList<Task> tasks, int n){
        printLine();
        System.out.println("Got it. I've added this task:  ");
        System.out.println(tasks.get(n-1));
        System.out.println("Now you have " + n + (n == 1 ? " task" : " tasks") + " in your list.");
        printLine();
    }

    public void printLine(){
        System.out.println(line);
    }

}
