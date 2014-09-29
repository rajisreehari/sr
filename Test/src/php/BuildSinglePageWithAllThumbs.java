package php;
import java.io.File;
import java.io.IOException;

public class BuildSinglePageWithAllThumbs extends DadPhp{
	private static String PAINTING_PATH = "/Users/jorge/git/sr/art/painting";
	public static void main(String[] p) throws IOException{
		build();
	}
	public static void build() throws IOException {
		File[] dirs = new File(PAINTING_PATH).listFiles();
		for (File dir : dirs) {
			if(dir.isDirectory()){
				String dirName = dir.getName();
				System.out.println("<div class=\"panel panel-heading\" align=\"left\" style=\"color: gray;\"><h1>"
						+ "<a href=\""+PAINTING_PATH + "/" + dirName +"\">"+
				dirName+"</a></h1></div>");
				File[] files = dir.listFiles();
				for (File file : files) {
					String name = file.getName();
					if(name.indexOf("tumb") != -1){
						String output = "<a href=\"/art/painting/"+dirName+"/"+getName(name)+".php\"><IMG src=\"/art/painting/"+dirName+"/"+name+"\" class=\"allThumbs\"></a>";

						System.out.println(output);
					}
				}
			}
		}
	}
	
	private static String getName(String name) {
		int fIndex = name.indexOf("tumb");
		return name.substring(0, fIndex-1);
	}
}
