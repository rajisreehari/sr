package php;

import java.io.IOException;

public class BuildMaster {
	private static final String FOLDER = "cubes";
	public static void main(String[] args) throws IOException {
		//DadPhp.PATHToPAINTING = "/Users/jorge/git/sr/Test/src/php/";
		//BuildIndexPhp.build(FOLDER); doesn't work any more since i added content.php
		CreatePhpFromJpgAndTemplateWithTokens.build(FOLDER);
		BuildNavLinksWithThumbs.build(FOLDER);
	}
}
