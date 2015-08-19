import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.TreeSet;

public class Group implements GroupInterface,  Serializable  {
		protected final int maxGroupSize=20;
		private TreeSet<StudentInterface> group = new TreeSet<StudentInterface>();
		protected String groupName;
		protected StudentSorter studentSorter= new StudentSorter();
		
		public Group(String groupName) {
			this.groupName = groupName;
		}

        @Override
		public int getGroupSize() {
			return group.size();
		}

        @Override
		public String getGroupName() {
			return groupName;
		}

	    public void setGroupName(String groupName) {
			this.groupName = groupName;
		}

	    @Override
		public void sortStudents (String criteria){
	    	TreeSet <StudentInterface> newSet = new TreeSet(new StudentSorter(criteria));
	    	newSet.addAll(group);
	    	group = newSet; 
	    	newSet=null;
	    	System.out.println("Students are sorted by " + criteria);
	    }
	    
	    @Override
		public void listGroup(){
	    	for (StudentInterface s : group) {
	    	    System.out.println(s.toString());
	    	}
	    }
	    
        @Override
		public StudentInterface searchStudent (String name){
	    	for (StudentInterface s : group) {
	    		try{
	        	    if ( name.equals(s.getName()) ) {
	                    return s;
	                }
	            } catch (NullPointerException e) {
	            	return null;
	            }
	    	}
	        return null;
	    }

	    public void addStudent(StudentInterface s) {
	    	if (group.size()>maxGroupSize-1){
	    		System.out.println ("Error adding, goup is full");
	    	} else {
	    		group.add(s);
	    		System.out.println( "Student added to group: " +groupName+ " "+ s.info() );
	    	}
	    }


	    
	    public void readFromFile(String filename) {
	    	String myLine = null;
	    	String[] temp;
	    
			try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
				while ( ( myLine = br.readLine())!=null )
		    	{    
		    	    temp = myLine.split(" ");
		    	    this.addStudent(new Student(temp[1],temp[3],Integer.parseInt(temp[5]),temp[7]));
		    	}
		    	
			} catch (IOException e) {
				System.out.println("Error: " + e);
			}
		}
	    
	    public void serializeSave(String fileName){
	    	try( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
	            if (group==null) throw new GroupException();
					 out.writeObject(group);
	        }
	        catch (IOException ex)
	        {
	            System.out.println(ex);
	        }
	    }
	    public void serializeRead(String filename){
	    	group = null;
	        try (ObjectInputStream OIS=new ObjectInputStream(new FileInputStream(filename))){
	        	group = (TreeSet<StudentInterface>) OIS.readObject();
	        } catch(IOException | ClassNotFoundException e){
	        	System.out.println("ERROR load group !!!");
	    	}
	    }
	    
		public void saveToFile(String fileName) {
			try (PrintWriter pw = new PrintWriter( new FileWriter( new File(fileName)))) {
				for (StudentInterface st : group){
					pw.println(st.toString());
				}
			} catch (IOException e) {
				System.out.println("Error creating " + fileName);
		    }
	    }
		

}
