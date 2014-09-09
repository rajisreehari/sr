package php;
import java.io.File;


public class MoveToPhp {
	private static final String PATH = "/Library/WebServer/Documents/jorge/painting/pigs/";

	public static void main(String[] p){
		File[] files = new File(PATH).listFiles();
		for (File file : files) {
			String name = file.getName();
			if(name.indexOf("htm") != -1){
				String onlyName = name.substring(0, name.indexOf("."));
				System.out.println(onlyName);
				file.renameTo(new File(PATH+onlyName+".php"));
			}
		}
	}
}
