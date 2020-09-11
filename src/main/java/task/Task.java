package task;

public class Task {
    public String description;
    protected boolean isDone;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public void setDone(){
        this.isDone = true;
    }

    public String getStatusIcon(){
        return (isDone ? "[\u2713]" : "[\u2718]");
    }

    public String toString(){
        return getStatusIcon() + " " + description;
    }
}
