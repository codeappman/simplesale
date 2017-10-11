package test.jpmorgan.simplesale;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * The Class NioTest.
 */
public class NioTest {

	/**
	 * Should read file success.
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void shouldReadFileSuccess() throws IOException {
		Path path = Paths.get("input.txt");

		Stream<String> stream = Files.lines(path);
		long size = stream.count();

		stream.close();

		// assert statements
		assertEquals(size, 51l);
	}

}
