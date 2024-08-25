package iuh.fit.se;

/**
 * @description:  This class represents oop exercises
 * @author:  Bui Van Tai
 * @version: 1.0
 * @created: Aug 23, 2024
 */
public class CourseList{
	private final Course[] courses;
	private int count =0;
	/**
	 * ham kho tao
	 * @param n
	 */
	public CourseList(int n) {
		if(n<=0) {
			throw new IllegalAccessError("N must be grater than 0");
		}
		courses =new Course[n];
	}
	/**
	 * them mot course vao mang
	 * @param course
	 * @return
	 */
	public boolean addCourse(Course course) {
		if(course == null) return false;
		if(isExists(course)) return false;
		if(count < courses.length) {
			courses[count++] = course;
			return true;
		}
		return false;
	}
	/**
	 * ham khiem tra course da ton tai chua
	 * ho tro ham addCourse
	 * @param course
	 * @return
	 */
	private boolean isExists(Course course) {
		for(Course temp : courses) {
			if(temp != null && temp.getId().equalsIgnoreCase(course.getId()))
				return true;
		}
		return false;
	}
	/**
	 * ham lay danh sach kho hoc
	 * @return
	 */
	public Course[] getCourses() {
		 Course[] currentCourses = new Course[count];
	        System.arraycopy(courses, 0, currentCourses, 0, count);
	        return currentCourses;
	}
	/**
	 * ham xoa mot khoa hoc
	 * @param id
	 * @return
	 */
	public boolean removeCourse(String id) {
		int d=findLocation(id);
		if(d==-1) {
			throw new IllegalAccessError("not find");
		}
		System.arraycopy(courses, d+1, courses, d, count-d-1);
		courses[--count] = null;
		return true;
	}
	/**
	 * tim vi tri cua Course de xoa
	 * @param id
	 * @return
	 */
	private int findLocation(String id) {
	    for (int i = 0; i < count; i++) {
	        if (id.equalsIgnoreCase(courses[i].getId())) {
	            return i;
	        }
	    }
	    return -1;
	}
	/**
	 * tim danh sach courses bang ten phong ban
	 * @param department
	 * @return
	 */
	public Course[] searchCourseByDepartment(String department) {
		int d=0,index=0;
		for (int i = 0; i < count; i++) {
	        if (department.equalsIgnoreCase(courses[i].getDepartment())) d++;
	    }
		Course[] temp = new Course[d];
		for (int i = 0; i < count; i++) {
	        if (department.equalsIgnoreCase(courses[i].getDepartment())) {
	            temp[index++]=courses[i];
	        }
	    }
		if(d!=0) return temp;
		return null;
	}
	/**
	 * tim Course bang id
	 * @param id
	 * @return
	 */
	public Course searchCourseById(String id) {
	    for (int i = 0; i < count; i++) {
	        if (id.equalsIgnoreCase(courses[i].getId())) {
	            return courses[i];
	        }
	    }
	    return null;
	}
	/**
	 * tim Course bang ten
	 * @param title
	 * @return
	 */
	public Course[] searchCourse(String title) {
		int d=0,index=0;
		for (int i = 0; i < count; i++) {
	        if (title.equalsIgnoreCase(courses[i].getTitle())) d++;
	    }
		Course[] temp = new Course[d];
		for (int i = 0; i < count; i++) {
	        if (title.equalsIgnoreCase(courses[i].getTitle())) {
	            temp[index++]=courses[i];
	        }
	    }
		if(d!=0) return temp;
		return null;
	}
	/**
	 * xap xep danh scah Course
	 * @return
	 */
	public Course[] sortCourses() {
		Course temp;
		for(int i=0;i<count-1;i++) {
			for(int j=i+1;j<count;j++) {
				if(courses[i].getTitle().compareTo(courses[j].getTitle())>0)
				{
					temp=courses[i];
					courses[i]=courses[j];
					courses[j]=temp;
				}
			}
		}
		return courses;
	}
	/**
	 * tim danh sach Courses cos nhiu tinh chi nhat
	 * @return
	 */
	public Course[] findMaxCreditCourses() {
		int d=0,index=0;
		Course[] temp = new Course[count];
		for(int i=0;i<count;i++) {
			if(d<courses[i].getCredit()) d=courses[i].getCredit();
		}
		for(int i=0;i<count;i++) {
			if(d==courses[i].getCredit())
				temp[index++]=courses[i];
		}
		return temp;
	}
	/**
	 * tim khoa co nhiu khoa hoc nhat
	 * @return
	 */
	public String findDepartmentWithMostCourses() {
		String[] departments = new String[courses.length];
		int[] departmentCounts = new int[courses.length];
		int uniqueDepartments=0;
		for(Course course : courses) {
			if(course != null) {
				String department = course.getDepartment();
				int index = findDepartmentIndex(departments,uniqueDepartments,department);
				if(index==-1) {
					departments[uniqueDepartments]=department;
					departmentCounts[uniqueDepartments]=1;
					uniqueDepartments++;
				}
				else departmentCounts[index]++;
			}
		}
		int maxIndex=0;
		for(int i=1 ; i<uniqueDepartments; i++) {
			if(departmentCounts[i]>departmentCounts[maxIndex]) maxIndex=i;
		}
		return departments[maxIndex];
	}
	/**
	 * ho tro ham findDepartmentWithMostCourses
	 * @param departments
	 * @param uniqueDepartments
	 * @param department
	 * @return
	 */
	private int findDepartmentIndex(String[] departments, int uniqueDepartments, String department) {
		for(int i=0;i<uniqueDepartments;i++) {
			if(departments[i].equals(department)) return i;
		}
		return -1;
	}
}