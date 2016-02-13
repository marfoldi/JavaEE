package hu.marfoldi.example.javaee.model;

import javax.persistence.*;

/**
 * @author marfoldi
 */

@Entity
public class Phone extends BaseEntity {

	private static final long serialVersionUID = 1281933705411903759L;

	@Basic
	@Enumerated(EnumType.STRING)
	private PhoneType type;

	@Basic
	@Column(name = "PHONE_NUMBER", length = 30)
	private String number;

	@ManyToOne
	private Dude dude;

	/**
	 * @return the type
	 */
	public PhoneType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(PhoneType type) {
		this.type = type;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the dude
	 */
	public Dude getDude() {
		return dude;
	}

	/**
	 * @param dude
	 *            the dude to set
	 */
	public void setDude(Dude dude) {
		this.dude = dude;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dude == null) ? 0 : dude.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Phone)) {
			return false;
		}
		Phone other = (Phone) obj;
		if (dude == null) {
			if (other.dude != null) {
				return false;
			}
		} else if (!dude.equals(other.dude)) {
			return false;
		}
		if (number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!number.equals(other.number)) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}

}