package test.jpmorgan.simplesale;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Stream;

import test.jpmorgan.simplesale.entity.Adjustment;
import test.jpmorgan.simplesale.entity.AuditLog;
import test.jpmorgan.simplesale.entity.Message;
import test.jpmorgan.simplesale.entity.Sale;
import test.jpmorgan.simplesale.service.SaleService;
import test.jpmorgan.simplesale.service.SaleServiceImpl;
import test.jpmorgan.simplesale.util.MessageMapper;
import test.jpmorgan.simplesale.util.MessageParser;

/**
 * The Class App.
 */
public class App {

	/** The Constant LOGGER. */
	private final static Logger LOGGER = Logger.getLogger(App.class.getName());

	/** The map. */
	private Map<String, List<Sale>> sales = new LinkedHashMap<>();

	/** The logs. */
	private List<AuditLog> logs = new ArrayList<>();

	/** The service. */
	private SaleService service = new SaleServiceImpl();

	/**
	 * Execute.
	 */
	private void execute() {
		Path path = Paths.get("input.txt");
		Stream<String> stream;

		AtomicInteger line = new AtomicInteger(0);
		try {
			stream = Files.lines(path);

			stream.forEach((str) -> {
				line.incrementAndGet();

				// parse JSON notification message to Message Class
				Message m = MessageParser.readJson(str);

				// determine the message is a sale or an adjustment
				if (!m.getOperation().isPresent()) {
					service.updateSale(sales, MessageMapper.toSale(m));
				} else {
					Adjustment adj = MessageMapper.toAdjustment(m);
					int updated = service.adjust(sales, adj);
					logs.add(new AuditLog(adj, updated));
				}

				// print per 10
				if (line.get() % 10 == 0) {
					System.out.println("/******* summary per 10 sales *******/");
					service.printSaleReport(sales);
					System.out.println("");
				}

				// print at 50
				if (line.get() % 50 == 0) {
					System.out.println("/************** report **************/");
					service.printAdjustmentReport(logs);
					System.out.println("Paused, stop accepting new messages");
				}

			});

		} catch (IOException e) {
			LOGGER.info(String.format("Cannot open file %s", path.getFileName()));
		}

	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		App app = new App();
		app.execute();
	}
}
