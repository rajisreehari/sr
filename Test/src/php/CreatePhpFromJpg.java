package php;
import java.io.File;
import java.io.IOException;


public class CreatePhpFromJpg extends DadPhp{
	private static final String PATH = "/Library/WebServer/Documents/jorge/painting/anxiety/";
	private static final String PATH_TEMPLATE = "/Users/jorge/git/sr/Test/src/phptemplate.php";

	public static void main(String[] p) throws IOException{
		File[] files = new File(PATH).listFiles();
		File template = new File(PATH_TEMPLATE);
		for (File file : files) {
			String name = file.getName();
			if(name.indexOf(".jpg") != -1){
				String onlyName = name.substring(0, name.indexOf("."));
				copyFileUsingFileChannels(template, new File(PATH+onlyName+".php"));
			}
		}
	}
}
