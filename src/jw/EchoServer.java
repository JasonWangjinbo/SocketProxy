package jw;

import java.io.*;
import java.net.*;

/**
 * A simple application that echoes received packets.
 * 
 * @author Jason
 *
 */
public class EchoServer
{

	public static void main(final String[] args)
	{

		try (final ServerSocket socket = new ServerSocket(12001))
		{
			while (true)
			{
				_echo(socket.accept());
			}
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}

	}

	private static void _echo(final Socket s)
	{
		new Thread(() ->
		{
			try (final BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream())))
			{
				String line = null;
				do
				{
					s.getOutputStream().write("Telnet > ".getBytes());
					line = reader.readLine();
					s.getOutputStream().write(("Received: " + line + System.getProperty("line.separator")).getBytes());
					System.out.println("Received: " + line);
				}
				while (line != null);
			}
			catch (final IOException e)
			{
				e.printStackTrace();
			}

		}, "Telnet->" + s.getInetAddress()).start();
	}

}
