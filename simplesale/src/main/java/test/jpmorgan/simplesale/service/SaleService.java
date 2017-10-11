package test.jpmorgan.simplesale.service;

import java.util.List;
import java.util.Map;

import test.jpmorgan.simplesale.entity.Adjustment;
import test.jpmorgan.simplesale.entity.AuditLog;
import test.jpmorgan.simplesale.entity.Sale;

/**
 * The Interface SaleService.
 */
public interface SaleService {

	/**
	 * Update sale.
	 *
	 * @param map
	 *            the map
	 * @param sale
	 *            the sale
	 */
	void updateSale(Map<String, List<Sale>> map, Sale sale);

	/**
	 * Adjust.
	 *
	 * @param map
	 *            the map
	 * @param adj
	 *            the adj
	 * @return the int
	 */
	int adjust(Map<String, List<Sale>> map, Adjustment adj);

	/**
	 * Prints the sale report.
	 *
	 * @param map
	 *            the map
	 */
	void printSaleReport(Map<String, List<Sale>> map);

	/**
	 * Prints the adjustment report.
	 *
	 * @param logs
	 *            the logs
	 */
	void printAdjustmentReport(List<AuditLog> logs);
}
