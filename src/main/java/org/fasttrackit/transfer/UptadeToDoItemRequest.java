package org.fasttrackit.transfer;

public class UptadeToDoItemRequest {

    private boolean done;
// inthe future we can update other properties as well if we need to

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "UptadeToDoItemRequest{" +
                "done=" + done +
                '}';
    }
}
