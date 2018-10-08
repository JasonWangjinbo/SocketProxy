package jw;

import java.io.*;
import java.net.*;

public class InitiatorConnected implements ConnectionState
{
	private final Configuration _configuration;
	private final Socket _initiatorSocket;

	public InitiatorConnected(final Configuration configuration, final Socket initiatorSocket)
	{
		_configuration = configuration;
		_initiatorSocket = initiatorSocket;
	}

	@Override
	public ConnectionState connectAcceptor() throws IOException
	{
		// Create Socket to connect to target host on target port
		Log.info("Connecting to acceptor %s:%d", _configuration.getTargetHost(), _configuration.getTargetPort());
		final Socket acceptorSocket = new Socket(_configuration.getTargetHost(), _configuration.getTargetPort());
		Log.info("Acceptor connected");
		return new AcceptorConnected(_configuration, _initiatorSocket, acceptorSocket);
	}

}
