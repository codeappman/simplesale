package test.jpmorgan.simplesale.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import test.jpmorgan.simplesale.entity.Adjustment;
import test.jpmorgan.simplesale.entity.AuditLog;
import test.jpmorgan.simplesale.entity.Sale;

public class SaleServiceImpl implements SaleService {

	@Override
	public void updateSale(Map<String, List<Sale>> map, Sale sale) {
		String productType = sale.getProduct();

		if (map.get(productType) == null) {
			List<Sale> sales = new ArrayList<>();
			sales.add(sale);
			map.put(productType, sales);
		} else {
			List<Sale> sales = map.get(productType);
			sales.add(sale);
		}
	}

	@Override
	public int adjust(Map<String, List<Sale>> map, Adjustment adj) {
		String productType = adj.getProduct();

		Consumer<Sale> consume = null;
		switch (adj.getOperation()) {
		case "add":
			consume = (sale) -> {
				sale.setValue(sale.getValue().add(adj.getValue()));
			};
			break;
		case "subtract":
			consume = (sale) -> {
				sale.setValue(sale.getValue().subtract(adj.getValue()));
			};
			break;
		case "multiply":
			consume = (sale) -> {
				sale.setValue(sale.getValue().multiply(adj.getValue()));
			};
			break;
		default:
		}

		if (map.get(productType) != null) {
			List<Sale> sales = map.get(productType);
			sales.stream().forEach(consume);

			return sales.size();
		}

		return 0;
	}

	@Override
	public void printSaleReport(Map<String, List<Sale>> map) {
		map.forEach((k, v) -> {
			int amount = v.stream().mapToInt(sale -> sale.getAmount()).sum();
			BigDecimal value = v.stream().map(sale -> sale.getValue().multiply(new BigDecimal(sale.getAmount())))
					.reduce(BigDecimal.ZERO, BigDecimal::add);

			System.out.println(String.format("Product: %s, Amount: %d, Value: %s", k, amount,
					value.setScale(2, BigDecimal.ROUND_HALF_UP).toString()));
		});
	}

	@Override
	public void printAdjustmentReport(List<AuditLog> logs) {
		logs.forEach((log) -> System.out.println(String.format("Adjusted %s by %s (%s), %d sale record(s) updated",
				log.getAdjustment().getProduct(), log.getAdjustment().getValue().toString(),
				log.getAdjustment().getOperation(), log.getNumUpdated())));

	}

}
