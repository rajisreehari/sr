package php;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BuildNavLinksWithThumbs extends DadPhp{
	public static void main(String[] p) throws IOException{
		build("war");
	}

	public static void build(String folder) throws IOException {
		String pathJpg = PATHToPAINTING + folder;
		System.out.println();
		System.out.println("--- Building Nav Links With Thumbs --------------------------------------");
		List<String> jpgFileNames = getJpgFileNames(pathJpg);
		for (String name : jpgFileNames) {
			String link = "<li><a href=\"/jorge/painting/"+folder+"/"+name+".php\">"+
					"<IMG src=\"/jorge/painting/"+folder+"/"+name+"_tumb.jpg\" class=\"navImage\">&nbsp;" +
					"<small>"+getUpper(name)+"</small></a></li>";
			System.out.println(link);
		}
		System.out.println();
		
		File[] files = new File(pathJpg).listFiles();
		for (File file : files) {
			if(file.getName().indexOf("jpg") != -1){
				createImage(file, "jpg", 100, pathJpg + "/" + 
						file.getName().substring(0, file.getName().indexOf(".")) + "_tumb.jpg");
			}
		}
	}
}
