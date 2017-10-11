package test.jpmorgan.simplesale.entity;

import java.math.BigDecimal;

/**
 * The Class Sale.
 */
public class Sale {

	/** The product. */
	private String product;

	/** The amount. */
	private Integer amount;

	/** The value. */
	private BigDecimal value;

	/**
	 * Instantiates a new sale.
	 *
	 * @param product
	 *            the product
	 * @param amount
	 *            the amount
	 * @param value
	 *            the value
	 */
	public Sale(String product, Integer amount, BigDecimal value) {
		super();
		this.product = product;
		this.amount = amount;
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
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount
	 *            the new amount
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
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
