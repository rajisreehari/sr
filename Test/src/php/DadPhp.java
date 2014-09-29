package php;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class DadPhp {
	protected static void replace(Map<String, String> data, File in, File out) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(in));
		PrintWriter writer = new PrintWriter(new FileWriter(out));
		String line = null;
		Set<String> keys = data.keySet();
		while ((line = reader.readLine()) != null) {
			for (String key : keys) {
				line = line.replaceAll(key, data.get(key));
			}
			writer.println(line);
		}
		reader.close();
		writer.close();
	}

	protected static String getUpper(String name) {
		name = name.replace("_", " ");
		return upperCaseFirstLetter(name);
	}

	protected static void copyFileUsingFileChannels(File source, File dest) throws IOException {
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		try {
			inputChannel = new FileInputStream(source).getChannel();
			outputChannel = new FileOutputStream(dest).getChannel();
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		} finally {
			inputChannel.close();
			outputChannel.close();
		}
	}

	protected static List<String> getJpgFileNames(String path) {
		List<String> result = new ArrayList<String>();
		File[] files = new File(path).listFiles();
		for (File file : files) {
			String name = file.getName();
			if (name.indexOf("jpg") != -1) {
				result.add(name.substring(0, name.indexOf(".")));
			}
		}
		return result;
	}

	protected static String upperCaseFirstLetter(String source) {
		StringBuffer res = new StringBuffer();

		String[] strArr = source.split(" ");
		for (String str : strArr) {
			char[] stringArray = str.trim().toCharArray();
			stringArray[0] = Character.toUpperCase(stringArray[0]);
			str = new String(stringArray);

			res.append(str).append(" ");
		}

		return res.toString().trim();
	}

	protected static void createImage(File file, String extension, int imageSize, String fileName) throws IOException {
		BufferedImage src = ImageIO.read(new ByteArrayInputStream(read(file)));
		File destination = new File(fileName);
		ImageIO.write(Scalr.resize(src, imageSize), extension, destination);
	}

	protected static byte[] read(File file) throws IOException {
		byte[] buffer = new byte[(int) file.length()];
		InputStream ios = null;
		try {
			ios = new FileInputStream(file);
			if (ios.read(buffer) == -1) {
				throw new IOException("EOF reached while trying to read the whole file");
			}
		} finally {
			try {
				if (ios != null)
					ios.close();
			} catch (IOException e) {
			}
		}
		return buffer;
	}

}
