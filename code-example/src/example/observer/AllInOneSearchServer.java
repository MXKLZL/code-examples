package example.observer;

public class AllInOneSearchServer implements AllInOneAppServer {

	@Override
	public void updateApp(String feedback) {
		// TODO Auto-generated method stub

	}

	@Override
	public String updateServer(String key) {
		// TODO Auto-generated method stub
		System.out.println("From Search Engine: Got the query: " + key);
		return key;
	}

}
