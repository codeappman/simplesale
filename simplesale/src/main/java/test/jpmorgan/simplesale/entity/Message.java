package test.jpmorgan.simplesale.entity;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

/**
 * The Class Message.
 */
public class Message {

	/** The Constant PRODUCT_TYPE_TAG. */
	public static final String PRODUCT_TYPE_TAG = "product";

	/** The Constant AMOUNT_TYPE_TAG. */
	public static final String AMOUNT_TYPE_TAG = "amount";

	/** The Constant VALUE_TYPE_TAG. */
	public static final String VALUE_TYPE_TAG = "value";

	/** The Constant OPERATION_TYPE_TAG. */
	public static final String OPERATION_TYPE_TAG = "operation";

	/** The product type. */
	private String productType;

	/** The value. */
	private BigDecimal value;

	/** The amount. */
	private Optional<Integer> amount;

	/** The operation. */
	private Optional<String> operation;

	/**
	 * Gets the product type.
	 *
	 * @return the product type
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * Sets the product type.
	 *
	 * @param productType
	 *            the new product type
	 */
	public void setProductType(String productType) {
		this.productType = productType;
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

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 * @throws ParseException
	 *             the parse exception
	 */
	public void setValue(String value) throws ParseException {
		Locale locale = Locale.UK;
		Number number = NumberFormat.getCurrencyInstance(locale).parse(value);
		this.value = new BigDecimal(number.toString());
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Optional<Integer> getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount
	 *            the new amount
	 */
	public void setAmount(Integer amount) {
		this.amount = Optional.ofNullable(amount);
	}

	/**
	 * Gets the operation.
	 *
	 * @return the operation
	 */
	public Optional<String> getOperation() {
		return operation;
	}

	/**
	 * Sets the operation.
	 *
	 * @param operation
	 *            the new operation
	 */
	public void setOperation(String operation) {
		this.operation = Optional.ofNullable(operation);
	}

}
