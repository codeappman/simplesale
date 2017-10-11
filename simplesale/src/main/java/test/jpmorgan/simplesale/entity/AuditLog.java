package test.jpmorgan.simplesale.entity;

/**
 * The Class AuditLog. log the adjustments that have been made to each sale type
 */
public class AuditLog {

	/** The adjustment. */
	private Adjustment adjustment;

	/** The num updated. */
	private int numUpdated;

	/**
	 * Instantiates a new audit log.
	 *
	 * @param adjustment
	 *            the adjustment
	 * @param numUpdated
	 *            the num updated
	 */
	public AuditLog(Adjustment adjustment, int numUpdated) {
		super();
		this.adjustment = adjustment;
		this.numUpdated = numUpdated;
	}

	/**
	 * Gets the adjustment.
	 *
	 * @return the adjustment
	 */
	public Adjustment getAdjustment() {
		return adjustment;
	}

	/**
	 * Sets the adjustment.
	 *
	 * @param adjustment
	 *            the new adjustment
	 */
	public void setAdjustment(Adjustment adjustment) {
		this.adjustment = adjustment;
	}

	/**
	 * Gets the num updated.
	 *
	 * @return the num updated
	 */
	public int getNumUpdated() {
		return numUpdated;
	}

	/**
	 * Sets the num updated.
	 *
	 * @param numUpdated
	 *            the new num updated
	 */
	public void setNumUpdated(int numUpdated) {
		this.numUpdated = numUpdated;
	}

}
