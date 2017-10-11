package test.jpmorgan.simplesale.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import test.jpmorgan.simplesale.entity.Message;

/**
 * The Class MessageParser.
 */
public class MessageParser {

	/**
	 * Read json.
	 *
	 * @param str
	 *            the str
	 * @return the message
	 */
	public static Message readJson(String str) {
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(str);

			Message m = new Message();

			m.setProductType((String) json.get(Message.PRODUCT_TYPE_TAG));
			m.setValue((String) json.get(Message.VALUE_TYPE_TAG));
			m.setAmount(json.get(Message.AMOUNT_TYPE_TAG) == null ? null
					: Integer.valueOf((String) json.get(Message.AMOUNT_TYPE_TAG)));
			m.setOperation(json.get(Message.OPERATION_TYPE_TAG) == null ? null
					: (String) json.get(Message.OPERATION_TYPE_TAG));

			return m;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
