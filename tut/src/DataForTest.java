package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataForTest {
	@DataProvider
	public static Iterator<Object[]> myData() {
		List<Object[]> list = new ArrayList<Object[]>();
		File file = new File("TXT1.txt");
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(file));
			String s = br.readLine();
			while (s != null) {
				String[] parts = s.split("\\|");
				list.add(new Object[] { new TestLogInLogOutParameter(parts[0],
						parts[1], parts[2]) });
				s = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.iterator();
	}

}
