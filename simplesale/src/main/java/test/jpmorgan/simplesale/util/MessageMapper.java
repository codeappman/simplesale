package test.jpmorgan.simplesale.util;

import test.jpmorgan.simplesale.entity.Adjustment;
import test.jpmorgan.simplesale.entity.Message;
import test.jpmorgan.simplesale.entity.Sale;

/**
 * The Class MessageMapper.
 */
public class MessageMapper {

	/**
	 * To sale.
	 *
	 * @param m
	 *            the m
	 * @return the sale
	 */
	public static Sale toSale(Message m) {
		return new Sale(m.getProductType(), m.getAmount().orElse(1), m.getValue());
	}

	/**
	 * To adjustment.
	 *
	 * @param m
	 *            the m
	 * @return the adjustment
	 */
	public static Adjustment toAdjustment(Message m) {
		return new Adjustment(m.getProductType(), m.getOperation().get(), m.getValue());
	}
}
