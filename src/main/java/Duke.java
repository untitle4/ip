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

        //set up scanner
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        //read the list in the file
        storage.readFile(tasks.tasks,"/Users/Acer/Desktop/duke.txt");

        while(!command.equals("bye")){

            //parse and add tasks
            parser.parse(command, tasks);

            command = sc.nextLine();

            //update the list in the file
            storage.writeToFile("/Users/Acer/Desktop/duke.txt", tasks.tasks);
        }

        ui.printExit();
    }
}

