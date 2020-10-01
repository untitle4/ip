package Duke.Storage;

import Duke.TaskList.TaskList;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// class storage for the reading and writing of file
public class Storage {
    public void readFile(ArrayList<Task> tasks, String fileDuke){
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
                if(thisTask.charAt(4) == '1'){
                    tasks.get(tasks.size() - 1).setDone();
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public void writeToFile(String filePath, ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for(int i=0; i<tasks.size(); i++){
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
}
