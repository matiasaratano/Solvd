package homework2;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(hasCredit, isDefaulter, patrimony, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CreditSummary other = (CreditSummary) obj;
		return hasCredit == other.hasCredit && isDefaulter == other.isDefaulter && patrimony == other.patrimony
				&& salary == other.salary;
	}

	@Override
	public String toString() {
		return "CreditSummary [salary=" + salary + ", patrimony=" + patrimony + ", isDefaulter=" + isDefaulter
				+ ", hasCredit=" + hasCredit + "]";
	}

}
