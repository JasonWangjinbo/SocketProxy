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
		final String threadName = Thread.currentThread().getName();
		System.out.println(LocalDateTime.now().toString() + "\t" + threadName + "\t" + threadName + line);
	}
}
