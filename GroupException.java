@SuppressWarnings("serial")
public class GroupException extends ArrayIndexOutOfBoundsException {

    public String toString(){
        return ("Unable to add another student. Group is full.");
    }
}
