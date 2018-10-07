package jw;

import java.time.*;

/**
 * Logging bridge.
 *
 * @author Jason
 *
 */
public class Log
{

	public static void info(final String message, final Object... parameters)
	{
		final String line = String.format(message, parameters);
		System.out.println(_header() + line);
	}

	private static String _header()
	{
		return LocalDateTime.now().toString() + "\t" + Thread.currentThread().getName() + ":\t";
	}

	public static void exception(final Throwable e, final String message)
	{
		System.err.println(_header() + message);
		e.printStackTrace();
	}
}
