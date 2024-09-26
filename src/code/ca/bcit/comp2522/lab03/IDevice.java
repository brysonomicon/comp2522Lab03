package ca.bcit.comp2522.lab03;

/**
 * Represents an abstract IDevice with a specific purpose.
 *
 * @author Bryson Lindy
 * @author Phyo Thu Kha
 * @version 1.0
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

    /*
       Validates the purpose by checking if it is null first. Then checks if it is empty.
       Throws an IllegalArgumentException if invalid.
     */
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
