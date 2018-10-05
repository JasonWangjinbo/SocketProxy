package jw;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * A proxy for socket connections, created to help test socket connections with
 * limited bandwidth.
 *
 * @author Jason
 *
 */
public class SocketProxy
{
	// This is the target socket to connect to send and receive packets.
	private Socket _targetSocket;

	// This is the socket created to listen to connection the initiator of the
	// connection.
	private ServerSocket _hostingSocket;

	// Inbound Kbps. Inbound is from connection initiator point of view.
	private int _inboundKbps;

	// Outbound Kbpls. Outbound is from connection initator point of view.
	private int _outboundKbps;

	public static void main(final String[] args)
	{
		// TODO Auto-generated method stub

	}

}
