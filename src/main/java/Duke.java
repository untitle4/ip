import task.Deadline;
import task.Event;
import task.Todo;
import task.Task;

import Duke.Storage.Storage;
import Duke.Ui.Ui;
import Duke.TaskList.TaskList;
import Duke.Parser.Parser;

import java.io.IOException;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) throws IOException {

        Storage storage = new Storage();
        Ui ui = new Ui();
        TaskList tasks = new TaskList();
        Parser parser = new Parser();
        ui.printGreeting();
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        storage.readFile(tasks.tasks,"data/Duke.txt");

        while(!command.equals("bye")){
            parser.parse(command, tasks);
            command = sc.nextLine();
            storage.writeToFile("data/Duke.txt", tasks.tasks);
        }

        ui.printExit();
    }
}

