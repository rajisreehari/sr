package php;
import java.io.File;
import java.io.IOException;

public class BuildSinglePageWithAllThumbs extends DadPhp{
	public static void main(String[] p) throws IOException{
		build();
	}
	public static void build() throws IOException {
		File[] dirs = new File(PATHToPAINTING).listFiles();
		for (File dir : dirs) {
			if(dir.isDirectory()){
				String dirName = dir.getName();
				File[] files = dir.listFiles();
				for (File file : files) {
					String name = file.getName();
					if(name.indexOf("tumb") != -1){
						String output = "<a href=\"/jorge/painting/"+dirName+"/"+getName(name)+".php\"><IMG src=\"/jorge/painting/"+dirName+"/"+name+"\" class=\"allThumbs\"></a>";

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
