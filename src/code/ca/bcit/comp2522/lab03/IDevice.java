package ca.bcit.comp2522.lab03;

/**
 * Represents an abstract IDevice with a specific purpose.
 */
abstract public class IDevice
{

    private final String purpose;

    /**
     * Constructs an IDevice with the specified purpose.
     *
     * @param purpose the purpose of the device; must not be null or empty.
     * @throws IllegalArgumentException if the purpose is null or empty.
     */
    public IDevice(final String purpose)
    {
        validatePurpose(purpose);
        this.purpose = purpose;
    }

    private static void validatePurpose(final String purpose)
    {
        if(purpose == null || purpose.isEmpty())
        {
            throw new IllegalArgumentException("Purpose cannot be null or empty");
        }
    }

    /**
     * Prints the details of the device.
     */
    abstract public void printDetails();

    /**
     * Gets the purpose of the device.
     *
     * @return the purpose of the device.
     */
    public String getPurpose()
    {
        return this.purpose;
    }
}
