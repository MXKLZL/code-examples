package example.observer;

public interface AllInOneAppServer {
	
	public void updateApp(String feedback);	// called when sending information to the app
	public String updateServer(String key);	// called when app is communicating with server

}
