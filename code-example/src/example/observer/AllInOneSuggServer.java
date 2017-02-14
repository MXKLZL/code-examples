package example.observer;

public class AllInOneSuggServer implements AllInOneAppServer {

	@Override
	public void updateApp(String feedback) {
		// TODO Auto-generated method stub

	}

	@Override
	public String updateServer(String key) {
		// TODO Auto-generated method stub
		System.out.println("From Suggestion Engine: Got the query: " + key);
		return key;
	}

}
