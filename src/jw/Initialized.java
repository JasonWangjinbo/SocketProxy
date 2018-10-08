package jw;

import java.io.*;
import java.net.*;

public class Initialized implements ConnectionState
{
	private final Configuration _configuration;

	public Initialized(final Configuration configuration)
	{
		_configuration = configuration;
	}

	@Override
	public ConnectionState connectInitiator() throws IOException
	{
		// Create ServerSocket and wait for connection from initiator to be established.
		Log.info("Listening on service port: %d", _configuration.getServicePort());
		final ServerSocket server = new ServerSocket(_configuration.getServicePort());
		final Socket initiatorSocket = server.accept();
		Log.info("Initiator connected from %s:%d", initiatorSocket.getInetAddress(), initiatorSocket.getPort());
		return new InitiatorConnected(_configuration, initiatorSocket);
	}

}
