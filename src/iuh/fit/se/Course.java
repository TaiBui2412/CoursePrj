package iuh.fit.se;
/**
 * @description:  This class represents oop exercises
 * @author:  Bui Van Tai
 * @version: 1.0
 * @created: Aug 23, 2024
 */

public class Course {
	private int credit;
	private String department;
	private String id;
	private String title;
	/**
	 * ham kho tao
	 */
	public Course() {
		this("","",0,"");
	}
	/**
	 * ham kho tao
	 * @param credit
	 * @param department
	 * @param id
	 * @param title
	 */
	public Course(String id, String title,int credit, String department) {
		if(id.length()<3 && title!= null&& credit>0) throw new IllegalAccessError("Wrong input information");
		this.id = id;
		this.title = title;
		this.credit = credit;
		this.department = department;
	}
	/**
	 * lay credit
	 * @return credit
	 */
	public int getCredit() {
		return credit;
	}
	/**
	 * sua credit
	 * @param credit
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}
	/**
	 * lay department
	 * @return department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * sua department
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * lay id
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * sua id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * lay title
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * sua title
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
        return String.format("|%-7s|%-35s|%3d|%-5s|", id, title, credit, department);
    }
}
