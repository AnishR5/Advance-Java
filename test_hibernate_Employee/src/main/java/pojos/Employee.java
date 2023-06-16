package pojos;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.*;  // all specs

@Entity    //Mandatory ot tell hibernate, following class is a standalone entity and life cycle to be managed by hibernate
@Table(name="emps")  //to specify table name ==> optional Annotation
public class Employee {
	//MAndodaty requirement of hibernate only till v5.x  ID must be Serializable 
	//Can it be int/long : yess but not reccomended 
	//instead use Wrapper Classes 
	
	@Id //Mandatory, PK constraint  but we have to assign pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //this Annotation implies hibernate should generate ids Automatically, auto increment statergy
	@Column(name="emp_id")   //specifies the column name= emp_id , dont use - ,db doesnt accept hypen
	private Integer empId;
	@Column(name="first_name",length = 20)   //varchar size set to 20 which was 256 by default
	private String firstName;
	@Column(name="last_name",length = 20)
	private String lastName;
	@Column(length = 30,unique=true)   //unique Constraint
	private String email;
	@Column(length=20,nullable = false)  //Not null constraint
	private String password;
	@Transient // skips from persistence => no column generation
	private String confirmpassword;
	@Column(name="join_Date")
	private LocalDate joinDate;
	@Enumerated(EnumType.STRING)  // default ordinal i.e based on number column name will be be number .Change and set it to String
	private EmploymentType type;
	private double salary;
	@Lob  //=> Large Object, col type generated will be longlob :Mbs
	private byte[] image;
	
	public Employee() {
		
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", joinDate=" + joinDate + ", type=" + type + ", salary=" + salary + ", image="
				+ Arrays.toString(image) + "]";
	}

	public Employee(String firstName, String lastName, String email, String password, String confirmpassword,
			LocalDate joinDate, EmploymentType type, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.joinDate = joinDate;
		this.type = type;
		this.salary = salary;
	}
	public Employee(String firstName, String lastName, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public EmploymentType getType() {
		return type;
	}
	public void setType(EmploymentType type) {
		this.type = type;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getConfirmpassword() {
		return confirmpassword;
	}
	
	
	
	
}
