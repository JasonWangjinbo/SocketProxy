package jw;

import java.io.*;

/**
 * A proxy for socket connections, created to help test socket connections with
 * limited bandwidth.
 *
 * @author Jason
 *
 */
public class SocketProxy
{
	private final ConnectionState _state;

	public SocketProxy(final Configuration configuration)
	{
		_state = new Initialized(configuration);
	}

	public void execute() throws IOException
	{
		_state.execute();
	}

	public static void main(final String[] args)
	{
		try
		{
			final Configuration configuration = new Configuration(args);
			new SocketProxy(configuration).execute();
		}
		catch (final IOException e)
		{
			Log.exception(e, "Exception when running SocketProxy");
		}
	}

}
