package jw;

import java.net.*;

public class AcceptorConnected implements ConnectionState
{
	private final Socket _initiatorSocket;
	private final Socket _acceptorSocket;

	public AcceptorConnected(final Socket initiatorSocket, final Socket acceptorSocket)
	{
		_initiatorSocket = initiatorSocket;
		_acceptorSocket = acceptorSocket;
	}

	@Override
	public ConnectionState execute()
	{
		// TODO: read inbound from both and send to the other
		return this;
	}

}
