package jw;

import java.io.*;
import java.net.*;

/**
 * Acceptor connected. As this state, we are ready to send/receive message on
 * both sides.
 *
 * @author Jason
 *
 */
public class AcceptorConnected implements ConnectionState
{
	private final Configuration _configuration;
	private final Socket _initiatorSocket;
	private final Socket _acceptorSocket;

	public AcceptorConnected(final Configuration configuration, final Socket initiatorSocket,
			final Socket acceptorSocket)
	{
		_configuration = configuration;
		_initiatorSocket = initiatorSocket;
		_acceptorSocket = acceptorSocket;
	}

	@Override
	public ConnectionState execute() throws IOException
	{
		new PacketsControl("InitiatorToAcceptor", _initiatorSocket.getInputStream(), _acceptorSocket.getOutputStream(),
				_configuration.getOutKbps()).execute();
		Log.info("Started transmitting packets from %s to %s", _initiatorSocket.getInetAddress(),
				_acceptorSocket.getInetAddress());
		new PacketsControl("AcceptorToInitiator", _acceptorSocket.getInputStream(), _initiatorSocket.getOutputStream(),
				_configuration.getInKbps()).execute();
		Log.info("Started transmitting packets from %s to %s", _acceptorSocket.getInetAddress(),
				_initiatorSocket.getInetAddress());
		return this;
	}

}
