package pac;

import java.util.Comparator;

public class HumanGroup {
	public int Age = 0;
	public long Population = 0;
	public int YearsBeingApprentice = 0;
	public int YearsInTeaching = 0;
	public boolean IsDisciple = false;
	public boolean IsAprentice = false;
	
	public HumanGroup(long population, int age) {
		this.Population = population;
		this.Age = age;
	}
	
	public int getAge() {
		return this.Age;
	}
	
	public void setAge(int age) {
		this.Age = age;
	}
	
	public void Aging() {
		this.Age++;
		if (this.IsAprentice) {
			this.YearsBeingApprentice++;
		}
		if (this.IsDisciple && (this.Age + Human.ageAsApprentice <= Human.maxAge)) {
			this.YearsInTeaching++;
		}
	}
	
	public boolean CanBeApprentice() {
		return this.Age >= Human.ageAsApprentice && !this.IsAprentice && !this.IsDisciple;
	}
	
	public boolean HasBecomeDisciple() {
		if (this.IsAprentice) {
			if (this.YearsBeingApprentice == Human.yearsOfApprenmticeship) {
				this.IsAprentice = false;
				this.IsDisciple = true;
				return true;
			}
		}
		return false;
	}
	
	public boolean IsGivingBirth() {
		return this.Age == Human.ageOfGivingBirth;
	}
	
	public boolean CanTrainApprentice() {
		if (this.IsDisciple && (this.Age + Human.ageAsApprentice <= Human.maxAge)) {
			if (this.YearsInTeaching == Human.yearsOfApprenmticeship) {
				this.YearsInTeaching = 0;
				return true;
			} else if (this.YearsInTeaching == 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean IsDead() {
		return this.Age >= Human.maxAge;
	}
	
	public static Comparator<HumanGroup> AgeComparator = new Comparator<HumanGroup>() {
		  
        // Comparing attributes of students
        public int compare(HumanGroup s1, HumanGroup s2) {
        	int age1 = s1.getAge();
        	int age2 = s2.getAge();
        	if (age1 > age2) {
        		return 1;
        	} else if (age1 == age2) {
        		return 0;
        	} else {
        		return -1;
        	}
        }
	};
}
