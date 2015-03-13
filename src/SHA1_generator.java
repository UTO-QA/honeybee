import java.io.FileWriter;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.swing.SwingUtilities;

import com.csvreader.CsvWriter;

public class SHA1_generator {

	public static void main(String[] args) throws Exception {
		// Start gui of MainFrame
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SHA1_generator_GUI();
			}
		});
	}

	public static String encrypt(String key) throws Exception {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(key.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}

	public static void generateCsvFile(String sFileName, String baseKey,
			int numberOfHashes) throws Exception {
		CsvWriter writer = new CsvWriter(new FileWriter(sFileName), ',');

		// Row heading
		writer.write("Nid");
		writer.write("Nid+BaseKey");
		writer.write("Hash");
		writer.endRecord();

		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		for (int i = 0; i < numberOfHashes; i++) {
			String nid = Integer.toString(sr.nextInt()).substring(1, 6);
			String temp = nid + baseKey;
			writer.write(nid);
			writer.write(temp);
			writer.write(encrypt(temp));
			writer.endRecord();
		}
		writer.flush();
		writer.close();
	}
}
