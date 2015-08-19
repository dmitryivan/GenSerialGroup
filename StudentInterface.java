import java.io.Serializable;

public interface StudentInterface extends Serializable {
String info();
void setContract(String contract);
String getContract();
int getAge();
String getName();
String getGender();
void setSortCriteria(String criteria);
}
