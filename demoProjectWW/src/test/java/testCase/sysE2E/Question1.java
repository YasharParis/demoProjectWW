package testCase.sysE2E;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Question1 {

	public boolean doesFileExist(String path) {
		try {
			Path filePath = Paths.get(path);
			return Files.exists(filePath);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<String> readFileContent(String path) {

		List<String> content = new ArrayList<>();

		// only process when file exits
		if (this.doesFileExist(path)) {

			try (Stream<String> stream = Files.lines(Paths.get(path))) {
				stream.forEach(line -> processLine(line, content));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return content;
	}

	private void processLine(String line, List<String> content) {
		String[] split = line.split(" – ");

		// get word part
		String word = split[0];
		System.out.println(word);

		content.add(word);

		// get meanings part
		String remaining = split[1];
		String[] meanings = remaining.split(", ");

		for (int i = 0; i < meanings.length; i++) {
			String meaning = meanings[i];
			System.out.println(meaning);
			content.add(meaning);
		}
		System.out.println("========================================");

	}

	public static void main(String[] args) {

		String path = "/Users/Elif/eclipse-workspace_DemoProject/demoProjectWW/src/test/resources/testData/dictionary.txt";

		Question1 q = new Question1();
		q.doesFileExist(path);

		q.readFileContent(path);

	}

}
