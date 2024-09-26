package ca.bcit.comp2522.lab03;

/**
 * Represents an abstract IPad device with properties such as case presence and operating system version.
 *
 * @author Bryson, Phyo
 * @version 1.0
 */
abstract public class IPad extends IDevice
{
    private static final String IPAD_PURPOSE = "Learning";
    private static final int OS_MINIMUM      = 13;
    private static final int OS_MAXIMUM      = 18;

    private boolean hasCase;
    private int operatingSystemVersion;

    /**
     * Constructs an IPad with the specified properties.
     *
     * @param hasCase                indicates whether the iPad has a protective case.
     * @param operatingSystemVersion the version of the operating system; must be between {@value #OS_MINIMUM} and {@value #OS_MAXIMUM}.
     * @throws IllegalArgumentException if the operating system version is out of the valid range.
     */
    public IPad(final boolean hasCase,
                final int operatingSystemVersion)
            throws IllegalArgumentException
    {
        super(IPAD_PURPOSE);

        validateOSVersion(operatingSystemVersion);

        this.operatingSystemVersion = operatingSystemVersion;
        this.hasCase = hasCase;
    }

    private void validateOSVersion(final int osVersion)
            throws IllegalArgumentException
    {
        if(osVersion < OS_MINIMUM || osVersion > OS_MAXIMUM)
        {
            throw new IllegalArgumentException(String.format("OS Version: %d invalid. Must be between %d and %d",
                    osVersion,
                    OS_MINIMUM,
                    OS_MAXIMUM));
        }
    }

    /**
     * Determines if the iPad has a protective case.
     *
     * @return {@code true} if the iPad has a case; {@code false} otherwise.
     */
    public boolean hasCase()
    {
        return this.hasCase;
    }

    /**
     * Gets the operating system version of the iPad.
     *
     * @return the operating system version.
     */
    public int getOperatingSystemVersion()
    {
        return this.operatingSystemVersion;
    }

    /**
     * Prints the details of the iPad.
     */
    abstract public void printDetails();
}
