package php;
import java.io.File;
import java.io.IOException;

public class CreatePhpTemplate extends DadPhp{
	private static final String PATH = "/Users/jorge/git/sr/Test/src/phptemplate.php";
	private static int numOfFiles = 11;

	public static void main(String[] p) throws IOException{
		File template = new File(PATH);
		for (int i = 1; i < numOfFiles; i++) {
			copyFileUsingFileChannels(template, new File("/Library/WebServer/Documents/jorge/painting/city/"+i+".php"));
		}
	}
}
