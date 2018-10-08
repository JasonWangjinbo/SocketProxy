package jw;

import java.io.*;

public interface ConnectionState
{
	public default ConnectionState connectInitiator() throws IOException
	{
		return this;
	};

	public default ConnectionState connectAcceptor() throws IOException
	{
		return this;
	};

	public default ConnectionState startPacketsTransmit() throws IOException
	{
		return this;
	};
}
