package php;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BuildMaster {
	private static String PAINTING_PATH = "/Users/jorge/git/sr/art/painting";
	private static String COMMON_PATH = "/Users/jorge/git/sr/art/common";
	
	public static void main(String[] args) throws IOException {
		List<String> folders = Arrays.asList("anxiety", "city", "cubes", "faces"
				, "ghosts", "hollywood", "lines", "mix"
				, "pigs", "politics", "turnheads", "war");
		
		//Builder.buildContentPageForFoldersSystemOut(PAINTING_PATH);
		//Builder.buildNavigationBarForFolders(PAINTING_PATH, COMMON_PATH);
		//Builder.buildSingleMasterPageWithAllThumbs(PAINTING_PATH);
		BuildForPaitingPhpClass.build(PAINTING_PATH, folders);
		//BuildNavLinksWithThumbs.build(FOLDER);
		//CreatePhpFromJpgAndTemplateWithTokens.build(FOLDER);
	}
}
