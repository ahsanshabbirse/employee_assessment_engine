package uk.co.planetbeyond.service.application.constants;

import uk.co.planetbeyond.util.CustomResourceBundle;

public class Constants extends CustomResourceBundle
{
	public Constants()
	{
		super("service");
	}

	private static Constants instance = null;

	public static synchronized Constants get()
	{
		if (instance == null || instance.reloadProperties())
		{
			instance = new Constants();
		}

		return instance;
	}

	// Specify the machine origin which is hosting the running application
	public final String ACCESS_CONTROL_ALLOW_ORIGIN = getString("ACCESS_CONTROL_ALLOW_ORIGIN");
	public final String ACCESS_CONTROL_ALLOW_CREDENTIALS = getString("ACCESS_CONTROL_ALLOW_CREDENTIALS");
	public final boolean EMPLOYEE_STATUS_ACTIVE = false;

	public static final String CROSS_ORIGIN = "*";
}
