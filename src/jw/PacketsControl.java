package jw;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * The class that controls packets transmitted is within specified rate.
 *
 * @author Jason
 *
 */
public class PacketsControl implements Runnable
{
	private final String _name;
	private final InputStream _in;
	private final OutputStream _out;
	private final int _kbps;
	private final int _maxBytesInOneSecond;
	private byte[] _remainingBuffer = null;

	public PacketsControl(final String name, final InputStream in, final OutputStream out, final int kbps)
	{
		_name = name;
		_in = in;
		_out = out;
		_kbps = kbps;
		_maxBytesInOneSecond = _kbps * 1000 / 8;
	}

	public void execute()
	{
		Executors.newSingleThreadScheduledExecutor(r -> new Thread(r, _name)).scheduleAtFixedRate(this, 0, 1000,
				TimeUnit.MILLISECONDS);
	}

	@Override
	public void run()
	{
		int totalWrite = 0;
		try
		{
			// Write _remainingBuffer if it is not null.
			if (_remainingBuffer != null)
			{
				_out.write(_remainingBuffer);
				totalWrite += _remainingBuffer.length;
				_remainingBuffer = null;
			}

			// _remainingBuffer is definitely small than _maxBytesReadInOneSecond
			while (true)
			{
				final byte[] buffer = new byte[_maxBytesInOneSecond];
				final int bytesRead = _in.read(buffer);
				if (totalWrite + bytesRead < _maxBytesInOneSecond)
				{
					_out.write(buffer);
					totalWrite += bytesRead;
					continue;
				}
				else
				{
					final int bytesToSend = _maxBytesInOneSecond - totalWrite;
					_out.write(buffer, 0, bytesToSend);
					_remainingBuffer = Arrays.copyOfRange(buffer, bytesToSend, buffer.length);
					break;
				}
			}
		}
		catch (final IOException e)
		{
			Log.exception(e, "IOException while reading/writing packets");
		}

	}

}
