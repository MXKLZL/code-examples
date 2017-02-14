package example.observer;

public interface AllInOneAppServer {
	
	public void updateApp();	// called when sending information to the app
	public void updateServer();	// called when app is communicating with server

}
