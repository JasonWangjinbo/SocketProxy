package jw;

public class Configuration
{
	// This is the port SocketProxy listens from connection from initiator.
	private final int _servicePort;

	// This is the acceptor part of the connection.
	private final String _targetHost;

	// This is the port acceptor is listening on.
	private final int _targetPort;

	// Maximum number of kilobits allowed from acceptor to initiator
	private final int _inKbps;

	// Maximum number of kilobits allowed from initiator to acceptor
	private final int _outKbps;

	public Configuration(final String[] args)
	{
		if (args.length == 0)
		{
			throw new IllegalArgumentException("No parameters provided");
		}

		String targetHost = null;
		int targetPort = 0;
		int servicePort = 0;
		int inKbps = 0;
		int outKbps = 0;
		for (int i = 0; i < args.length - 1; i++)
		{
			final String parameter = args[i].trim();
			final String nextParameter = args[i + 1].trim();
			if ("-t".equalsIgnoreCase(parameter))
			{
				i++;
				targetHost = nextParameter.split(":")[0];
				targetPort = Integer.parseInt(nextParameter.split(":")[1]);
			}
			if ("-sp".equalsIgnoreCase(parameter))
			{
				i++;
				servicePort = Integer.parseInt(nextParameter);
			}
			if ("-in".equalsIgnoreCase(parameter))
			{
				i++;
				inKbps = Integer.parseInt(nextParameter.substring(0, nextParameter.indexOf("Kbps")));
			}
			if ("-out".equalsIgnoreCase(parameter))
			{
				i++;
				outKbps = Integer.parseInt(nextParameter.substring(0, nextParameter.indexOf("Kbps")));
			}
		}

		_servicePort = servicePort;
		_targetHost = targetHost;
		_targetPort = targetPort;
		_inKbps = inKbps;
		_outKbps = outKbps;
	}

	public int getServicePort()
	{
		return _servicePort;
	}

	public String getTargetHost()
	{
		return _targetHost;
	}

	public int getTargetPort()
	{
		return _targetPort;
	}

	public int getInKbps()
	{
		return _inKbps;
	}

	public int getOutKbps()
	{
		return _outKbps;
	}

}
