public interface GroupInterface {
void addStudent(StudentInterface s);
String getGroupName();
int getGroupSize();
StudentInterface searchStudent(String name);
void sortStudents(String criteria);
void listGroup();
}
