# User Guide

## Features 

This is a multifunctional robot call 'Duke'. It can store 3 types of tasks: `todo`, `event` and `deadline`.
When you add the tasks, they would be set undone, and when you finish the tasks you can update the state to be `done`. 
By `list` out the schedule, you would be able to see the tasks and their index. You can also `find` and `delete` tasks in the list
using their index. To exit the program, just say `bye` to the bot.

## Usage

Notes about the command format:
* Words in `UPPER_CASE` are the parameters to be supplied by the user.

  e.g. in `todo TASK`, `TASK` is a parameter which can be used as `todo read book'.

* Parameters must be in a certain order.

  e.g. if the command `event TASK /at TIME` is written as `event /at Time TASK`, it is not acceptable.

### Printing list: `list`
Print our the list of the schedule.

Format: `list`

Expected output: 
```
list
__________________________________
Here are the tasks in your list:
1.[T][✘] read book
2.[E][✘] CS2113T team meeting  (at: 8:30 p.m. 1st Oct)
3.[D][✘] CS2113T IP  (by: 2359 Fri)
__________________________________
```

### Adding a todo task: `todo`
Adds a task of type todo.

Format: `todo TASK`

Examples: 
* `todo read book` Adds the task `read book` into the schedule.

Expected output: 
```
todo read book
__________________________________
Got it. I've added this task:  
[T][✘] read book
Now you have 1 task in your list.
__________________________________
```

### Adding an event task: `event`
Adds a task of type event.

Format: `event TASK /at TIME`

Examples:
* `event CS2113T team meeting /at 8:30 p.m. 1st Oct` Adds an event `CS2113T team meeting` at the time `8:30 p.m. 1st Oct`.
* `event basketball match` would not be acceptable since it lacks the `/at TIME` parameter.

Expected output: 
```
event CS2113T team meeting /at 8:30 p.m. 1st Oct
__________________________________
Got it. I've added this task:  
[E][✘] CS2113T team meeting  (at: 8:30 p.m. 1st Oct)
Now you have 2 tasks in your list.
__________________________________

event basketball match
__________________________________
☹ OOPS!!! The description of a event basketball match cannot be empty.
__________________________________
```

### Adding a deadline task: `deadline`
Adds a task of type deadline.

Format: `deadline TASK /by TIME`

Examples:
* `deadline CS2113T IP /by 2359 Fri` Adds a deadline `CS2113T IP` by the time `2359 Fri`.
* `deadline CFG resume` would not be acceptable since it lacks the `/at TIME` parameter.

Expected output: 
```
deadline CS2113T IP /by 2359 Fri
__________________________________
Got it. I've added this task:  
[D][✘] CS2113T IP  (by: 2359 Fri)
Now you have 3 tasks in your list.
__________________________________

deadline CFG resume
__________________________________
☹ OOPS!!! The description of a deadline CFG resume cannot be empty.
__________________________________
```

### Deleting a task: `delete`
Deletes a task in the list.

Format: `delete INDEX`

Examples (suggest that there are 2 tasks in the list):
* `delete 1` Deletes the first task in the list.
* `delete 3` would not be acceptable since the index exceeds the total number of tasks in the list.

Expected output: 
```
delete 1
__________________________________
Noted. I've removed this task:
  [T][✘] read book
Now you have 2 tasks in your list.
__________________________________

delete 3
__________________________________
☹ OOPS!!! There is no such a task in your list.
__________________________________
```

### Finding a task: `find`
Finds a task in the list with certain keywords.

Format: `find KEYWORDS`

Examples:
* `find book` Finds tasks with the keyword `book` in the list.

Expected output: 
```
find book
__________________________________
Here are the matching tasks in your list:
1. [T][✘] read book
__________________________________
```

### Setting a task done: `done`
Sets the state of a task to be done.

Format: `done INDEX`

Examples:
* `done 1` Marks task 1 in the list as done.

Expected output: 
```
done 1
__________________________________
Nice! I've marked this task as done:
[✓] CS2113T team meeting 
__________________________________
```


### Exiting the program: `bye`
Exits the program.

Format: `bye`

Expected output: 
```
bye
__________________________________
Bye. Hope to see you again soon!
__________________________________
```

### Saving the data
Duke automatically saves the schedule list in the document `"*\data\Duke.txt"`. It would also read the schedule when the program is executed.


## Command and summary
Actions | Formats
---------- | -----------------
List | `list`
Todo | `todo TASK`
Event | `event TASK /at TIME`
Deadline | `deadline TASK /by TIME`
Delete | `delete INDEX`
Find | `find KEYWORDS`
Done | `done INDEX`
Exit | `bye`
