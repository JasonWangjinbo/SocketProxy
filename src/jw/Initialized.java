package jw;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Initialized implements ConnectionState
{
	private final ServerSocket _serverSocket;

	public Initialized(final int servicePort) throws IOException
	{
		_serverSocket = new ServerSocket(servicePort);
	}

	@Override
	public ConnectionState execute() throws IOException
	{
		// Create ServerSocket and wait for connection from initiator to be established.
		final Socket s = _serverSocket.accept();
		return null;
	}

}
