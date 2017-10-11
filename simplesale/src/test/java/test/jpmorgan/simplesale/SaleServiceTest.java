package test.jpmorgan.simplesale;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import test.jpmorgan.simplesale.entity.Adjustment;
import test.jpmorgan.simplesale.entity.AuditLog;
import test.jpmorgan.simplesale.entity.Sale;
import test.jpmorgan.simplesale.service.SaleService;
import test.jpmorgan.simplesale.service.SaleServiceImpl;

/**
 * The Class SaleServiceTest.
 */
public class SaleServiceTest {

	/** The map. */
	Map<String, List<Sale>> map = new HashMap<>();

	/** The service. */
	SaleService service = new SaleServiceImpl();

	/**
	 * Prepare.
	 */
	@Before
	public void prepare() {
		Sale sale = new Sale("apple", 1, new BigDecimal("0.3"));
		service.updateSale(map, sale);
		sale = new Sale("apple", 20, new BigDecimal("0.1"));
		service.updateSale(map, sale);
	}

	/**
	 * Should update sale success.
	 */
	@Test
	public void shouldUpdateSaleSuccess() {
		// assert statements
		assertEquals(2, map.get("apple").size());
		assertEquals(1, map.get("apple").get(0).getAmount());
		assertEquals(20, map.get("apple").get(1).getAmount());
	}

	/**
	 * Should add sale success.
	 */
	@Test
	public void shouldAddSaleSuccess() {
		// add
		Adjustment adj = new Adjustment("apple", "add", new BigDecimal("0.2"));
		service.adjust(map, adj);

		// assert statements
		assertEquals(2, map.get("apple").size());
		assertEquals(new BigDecimal("0.5"), map.get("apple").get(0).getValue());
		assertEquals(new BigDecimal("0.3"), map.get("apple").get(1).getValue());

	}

	/**
	 * Should subtract sale success.
	 */
	@Test
	public void shouldSubtractSaleSuccess() {
		// add
		Adjustment adj = new Adjustment("apple", "subtract", new BigDecimal("0.05"));
		service.adjust(map, adj);

		// assert statements
		assertEquals(2, map.get("apple").size());
		assertEquals(new BigDecimal("0.25"), map.get("apple").get(0).getValue());
		assertEquals(new BigDecimal("0.05"), map.get("apple").get(1).getValue());

	}

	/**
	 * Should multiply sale success.
	 */
	@Test
	public void shouldMultiplySaleSuccess() {
		// add
		Adjustment adj = new Adjustment("apple", "multiply", new BigDecimal("2"));
		service.adjust(map, adj);

		// assert statements
		assertEquals(2, map.get("apple").size());
		assertEquals(new BigDecimal("0.6"), map.get("apple").get(0).getValue());
		assertEquals(new BigDecimal("0.2"), map.get("apple").get(1).getValue());

	}

	/**
	 * Should print sale report success.
	 */
	@Test
	public void shouldPrintSaleReportSuccess() {
		Sale sale = new Sale("Banana", 1, new BigDecimal("0.1"));
		service.updateSale(map, sale);
		sale = new Sale("Banana", 10, new BigDecimal("0.2"));
		service.updateSale(map, sale);

		service.printSaleReport(map);
	}

	/**
	 * Should print adjustment report success.
	 */
	@Test
	public void shouldPrintAdjustmentReportSuccess() {
		List<AuditLog> logs = new ArrayList<>();
		int updated = 0;

		Adjustment adj = new Adjustment("apple", "multiply", new BigDecimal("2"));
		updated = service.adjust(map, adj);
		logs.add(new AuditLog(adj, updated));

		adj = new Adjustment("apple", "add", new BigDecimal("0.2"));
		updated = service.adjust(map, adj);
		logs.add(new AuditLog(adj, updated));

		Sale sale = new Sale("banana", 1, new BigDecimal("0.1"));
		service.updateSale(map, sale);
		sale = new Sale("banana", 10, new BigDecimal("0.2"));
		service.updateSale(map, sale);

		adj = new Adjustment("banana", "add", new BigDecimal("0.2"));
		updated = service.adjust(map, adj);
		logs.add(new AuditLog(adj, updated));

		service.printAdjustmentReport(logs);
	}

}
