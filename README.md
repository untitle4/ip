# Duke project template

This is a project template for a greenfield Java project. It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Setting up in Intellij

Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
1. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
1. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
1. After the importing is complete, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:
   ```
   Hello from
    ____        _        
   |  _ \ _   _| | _____ 
   | | | | | | | |/ / _ \
   | |_| | |_| |   <  __/
   |____/ \__,_|_|\_\___|
   ```

## Features

Notes about the command format:
* Words in `UPPER_CASE` are the parameters to be supplied by the user.

  e.g. in `todo TASK`, `TASK` is a parameter which can be used as `todo read book'.

* Parameters must be in a certain order.

  e.g. if the command `event TASK /at TIME` is written as `event /at Time TASK`, it is not acceptable.

### Printing list: `list`
Print our the list of the schedule.
Format: `list`


### Adding a todo task: `todo`
Adds a task of type todo.
Format: `todo TASK`
Examples: 
* `todo read book` Adds the task `read book` into the schedule.


### Adding an event task: `event`
Adds a task of type event.
Format: `event TASK /at TIME`
Examples:
* `event CS2113T team meeting /at 8:30 p.m. 1st Oct` Adds an event `CS2113T team meeting` at the time `8:30 p.m. 1st Oct`.
* `event basketball match` would not be acceptable since it lacks the `/at TIME` parameter.


### Adding a deadline task: `deadline`
Adds a task of type deadline.
Format: `deadline TASK /by TIME`
Examples:
* `deadline CS2113T IP /by 2359 Fri` Adds a deadline `CS2113T IP` by the time `2359 Fri`.
* `deadline CFG resume` would not be acceptable since it lacks the `/at TIME` parameter.


### Deleting a task: `delete`
Deletes a task in the list.
Format: `delete INDEX`
Examples (suggest that there are 2 tasks in the list):
* `delete 1` Deletes the first task in the list.
* `delete 3` would not be acceptable since the index exceeds the total number of tasks in the list.


### Finding a task: `find`
Finds a task in the list with certain keywords.
Format: `find KEYWORDS`
Examples:
* `find book` Finds tasks with the keyword `book` in the list.


### Setting a task done: `done`
Sets the state of a task to be done.
Format: `done INDEX`
Examples:
* `done 1` Marks task 1 in the list as done.


### Exiting the program: `bye`
Exits the program.
Format: `bye`


### Saving the data
Duke automatically saves the schedule list in the document `"*\data\Duke.txt"`. It would also read the schedule when the program is executed.


## Command and summary
Actions | Formats
------- | -----------------
List | `list`
Todo | `todo TASK`
Event | `event TASK /at TIME`
Deadline | `deadline TASK /by TIME`
Delete | `delete INDEX`
Find | `find KEYWORDS`
Done | `done INDEX`
Exit | `bye`