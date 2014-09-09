package php;

import java.io.IOException;
import java.util.List;

public class BuildLinksForNavBar extends DadPhp{
	public static void main(String[] p) throws IOException{
		build("mix");
	}

	public static void build(String folder) {
		String pathJpg = PATHToPAINTING + folder;
		System.out.println();
		System.out.println("--- Building Nav Links --------------------------------------");
		List<String> jpgFileNames = getJpgFileNames(pathJpg);
		for (String name : jpgFileNames) {
			String link = "<li><a href=\"/jorge/painting/"+folder+"/"+name+".php\">"+
					"<IMG src=\"/jorge/painting/"+folder+"/"+name+".jpg\" class=\"navImage\">&nbsp;" +
					"<small>"+getUpper(name)+"</small></a></li>";
			//String link = "<a href=\"/jorge/painting/mix/"+name+".php\"><IMG src=\"/jorge/painting/mix/"+name+".jpg\" class=\"img-thumbnail lonelyImage indexImage370\"></a>";
			System.out.println(link);
		}
		System.out.println();
	}
}
