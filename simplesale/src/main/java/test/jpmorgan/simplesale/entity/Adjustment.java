package test.jpmorgan.simplesale.entity;

import java.math.BigDecimal;

/**
 * The Class Adjustment.
 */
public class Adjustment {

	/** The product. */
	private String product;

	/** The operation. */
	private String operation;

	/** The value. */
	private BigDecimal value;

	/**
	 * Instantiates a new adjustment.
	 *
	 * @param product
	 *            the product
	 * @param operation
	 *            the operation
	 * @param value
	 *            the value
	 */
	public Adjustment(String product, String operation, BigDecimal value) {
		super();
		this.product = product;
		this.operation = operation;
		this.value = value;
	}

	/**
	 * Gets the product.
	 *
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * Sets the product.
	 *
	 * @param product
	 *            the new product
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * Sets the operation.
	 *
	 * @param operation
	 *            the new operation
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
