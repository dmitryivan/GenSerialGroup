import java.io.Serializable;
import java.util.Comparator;

public class StudentSorter implements Serializable,Comparator <StudentInterface>{
    private String sortCriteria;
    
	public StudentSorter() {
		super();
		this.sortCriteria = "name";
	}
	public StudentSorter(String sortCriteria) {
		super();
		this.sortCriteria = sortCriteria;
	}

	public void setSortCriteria(String sortCriteria) {
		this.sortCriteria = sortCriteria;
	}

	@Override
	public int compare(StudentInterface s1, StudentInterface s2) {
		switch (sortCriteria) {
        case "age":
    	if (s1.getAge()>s2.getAge()) return 1;
  	    else if(s1.getAge()<s2.getAge()) return -1;
        break;
        case "gender":
        return s1.getGender().compareTo( s2.getGender() );
        case "name":
     	return s1.getName().compareTo( s2.getName() );
        case "contract":
     	return s1.getContract().compareTo( s2.getContract() );
    }
    return 0;
	}

}
