package homework2;

public class CreditSummary {

	private int salary;
	private int patrimony;
	private boolean isDefaulter;
	private boolean hasCredit;

	public CreditSummary(int salary, int patrimony, boolean isDefaulter, boolean hasCredit) {
		this.salary = salary;
		this.patrimony = patrimony;
		this.isDefaulter = isDefaulter;
		this.hasCredit = hasCredit;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getPatrimony() {
		return patrimony;
	}

	public void setPatrimony(int patrimony) {
		this.patrimony = patrimony;
	}

	public boolean isDefaulter() {
		return isDefaulter;
	}

	public void setDefaulter(boolean isDefaulter) {
		this.isDefaulter = isDefaulter;
	}

	public boolean hasCredit() {
		return hasCredit;
	}

	public void setHasCredit(boolean hasCredit) {
		this.hasCredit = hasCredit;
	}

	@Override
	public String toString() {
		return "CreditSummary [salary=" + salary + ", patrimony=" + patrimony + ", isDefaulter=" + isDefaulter
				+ ", hasCredit=" + hasCredit + "]";
	}

}
