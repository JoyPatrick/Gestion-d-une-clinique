import java.util.LinkedList;

public class FifoQueue {
    private LinkedList<Patient> queue;

    public FifoQueue() {
        queue = new LinkedList<>();
    }

    public void addAtBeginning(Patient obj) {
        queue.addFirst(obj);
    }

    public Patient popFromEnd() {
        return queue.removeLast();
    }

    public void add(Patient obj) {
        queue.add(obj);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
