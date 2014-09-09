package facebook;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Page;
import com.restfb.types.User;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] p){
		AccessToken accessToken =
				  new DefaultFacebookClient().obtainAppAccessToken("605804262870556", "b672632d8976d053fbfe0a096d6fb06b");
		

		FacebookClient facebookClient = new DefaultFacebookClient(accessToken.getAccessToken(), "b672632d8976d053fbfe0a096d6fb06b");
		User user = facebookClient.fetchObject("me", User.class);
		Page page = facebookClient.fetchObject("cocacola", Page.class);

		System.out.println("User name: " + user.getName());
		System.out.println("Page likes: " + page.getLikes());
	}
}
