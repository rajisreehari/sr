package php;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class BuildIndexPhp extends DadPhp{

	public static void main(String[] p) throws IOException{
		build("mix");
	}

	public static void build(String dir) throws IOException {
		String pathJpg = PATHToPAINTING + dir;
		StringBuffer links = new StringBuffer();
		buildHead(links);
		List<String> jpgFileNames = getJpgFileNames(pathJpg);
		for (String name : jpgFileNames) {
			if(name.indexOf("tumb") != -1){
				continue;
			}
			//String link = "<li><a href=\"/jorge/painting/mix/"+name+".php\"><small>"+name+"</small></a></li>";
			String link = "<a href=\"/jorge/painting/"+dir+"/"+name+".php\"><IMG src=\"/jorge/painting/"+
			dir+"/"+name+".jpg\" class=\"img-thumbnail lonelyImage indexImage370\"></a>";
			links.append(link);
			links.append("\n");
		}
		buildFoot(links);
		
		FileUtils.writeStringToFile(new File(pathJpg + "/index.php"), links.toString());
	}

	private static void buildFoot(StringBuffer links) {
		links.append("</div>");
		links.append("\n");
		links.append("<?php include $_SERVER['DOCUMENT_ROOT'].\"/jorge/common/footer.php\"; ?>");
		links.append("\n");
	}

	private static void buildHead(StringBuffer links) {
		links.append("<?php include $_SERVER['DOCUMENT_ROOT'].\"/jorge/common/header.php\"; ?>");
		links.append("\n");
		links.append("<div class=\"row\">");
		links.append("\n");
		links.append("<h1> <br><small>(Inspired By )</small></h1>");
		links.append("\n");
		links.append("</div>");
		links.append("\n");
		links.append("<div class=\"row\">");
		links.append("\n");
	}
}
