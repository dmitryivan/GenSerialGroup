
public class Main {

	public static void main(String[] args) {
	Student s1=new Student();
	Student s2=new Student("name1", "mutant" , 22, "No");
	Group g=new Group("1");
    g.addStudent(s1);
    g.addStudent(s2);

    
    System.out.println("");
	for (int i=0;i<20;i++){
		g.addStudent(new Student("name1"+i, "mutant" , 22+i, "No"));
	}
	
	

   // g.sortStudents("age");
    
  g.listGroup();
	
	g.serializeSave("8.txt");
    Group g2 = new Group("newgr");
    
    System.out.println("New group from file");
	g2.serializeRead("8.txt");
	g2.listGroup();
	
	
	}
	

}
