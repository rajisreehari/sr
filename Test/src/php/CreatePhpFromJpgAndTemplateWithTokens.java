package php;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreatePhpFromJpgAndTemplateWithTokens extends DadPhp{
	public static void main(String[] p) throws IOException{
		build("politics");
	}
	public static void build(String dir) throws IOException {
		String pathJpg = PATHToPAINTING + dir;
		Map<String, String> data = new HashMap<String, String>();
		
		List<String> jpgFileNames = getJpgFileNames(pathJpg);
		File template = new File("/Users/jorge/git/sr/Test/src/php/test/phptemplatetokens.php");
		for (String name : jpgFileNames) {
			File replaced = new File("/Users/jorge/git/sr/Test/src/php/test/1");
			data.put("xxxxxx", getUpper(name));
			data.put("yyyyyy", getUpper(name));
			data.put("zzzzzz", name);
			replace(data, template, replaced);
			copyFileUsingFileChannels(replaced, new File(pathJpg + "/" + name + ".php"));
		}
	}
}
