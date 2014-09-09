package php;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreatePhpFromJpgAndTemplate extends DadPhp{
	private static final String PATHJPG = "/Users/jorge/git/sr/Art/painting/mix";
	private static final String PATHTEMPLATE = "/Users/jorge/git/sr/Test/src/php/phptemplate.php";
	public static void main(String[] p) throws IOException{
		File template = new File(PATHTEMPLATE);
		List<String> jpgFileNames = getJpgFileNames(PATHJPG);
		for (String name : jpgFileNames) {
			copyFileUsingFileChannels(template, new File(PATHJPG + "/" + name + ".php"));
		}
	}

}
