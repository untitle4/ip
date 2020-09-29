package Duke.Parser;

import Duke.TaskList.TaskList;
import task.Task;

public class Parser {
    public void parse(String command, TaskList tasks){
        // print list
        if(command.equals("list")){
            tasks.printList();
        }

        // todo
        else if(command.startsWith("todo")){
            tasks.addTodo(command);
        }

        // event
        else if(command.startsWith("event")){
            tasks.addEvent(command);
        }

        // deadline
        else if(command.startsWith("deadline")){
            tasks.addDeadline(command);
        }

        // delete tasks
        else if(command.startsWith("delete")){
            tasks.delete(command);
        }

        // done tasks
        else if(command.startsWith("done")){
            tasks.done(command);
        }

        // find tasks
        else if(command.startsWith("find")){
            tasks.find(command);
        }

        // invalid command
        else{
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

}
