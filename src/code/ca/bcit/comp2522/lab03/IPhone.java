package ca.bcit.comp2522.lab03;

/**
 * Represents an abstract IPhone device with properties such as number of minutes remaining and carrier.
 *
 * @author Bryson, Phyo, Nam Anh
 * @version 1.0
 */
abstract public class IPhone extends IDevice
{
    private static final String[] IPHONE_VALID_CARRIERS = {"Telus", "Bell", "Rogers"};
    private static final String IPHONE_PURPOSE = "Talking";
    private static final int MINIMUM_MINUTES   = 0;

    private double numOfMinsRemaining;
    private String carrier;

    /**
     * Constructs an IPhone with the specified properties.
     *
     * @param numOfMinsRemaining the number of minutes remaining; must be greater than or equal to {@value #MINIMUM_MINUTES}.
     * @param carrier            the carrier of the iPhone; must not be null or empty.
     * @throws IllegalArgumentException if the number of minutes remaining is negative or the carrier is null or empty.
     */
    public IPhone(final double numOfMinsRemaining,
                  final String carrier)
    {
        super(IPHONE_PURPOSE);

        validateNumOfMinsRemainding(numOfMinsRemaining);
        validateCarrier(carrier);

        this.numOfMinsRemaining = numOfMinsRemaining;
        this.carrier            = carrier;
    }

    private static void validateNumOfMinsRemainding(final double numOfMinsRemaining)
    {
        if (numOfMinsRemaining < MINIMUM_MINUTES)
        {
            throw new IllegalArgumentException("The number of minutes remaining cannot be negative.");
        }
    }

    private static void validateCarrier(final String carrier)
    {
        boolean isValid;

        isValid = false;

        if (carrier == null || carrier.isEmpty())
        {
            throw new IllegalArgumentException("The carrier cannot be null or empty.");
        }

        for(int i = 0; i < IPHONE_VALID_CARRIERS.length && !isValid; ++i)
        {
            if (carrier.trim().equalsIgnoreCase(IPHONE_VALID_CARRIERS[i]))
            {
                isValid = true;
            }
        }

        if(!isValid)
        {
            throw new IllegalArgumentException("The carrier is invalid must be an approved carrier.");
        }
    }

    /**
     * Gets the number of minutes remaining.
     *
     * @return the number of minutes remaining.
     */
    public double getNumOfMinsRemaining()
    {
        return this.numOfMinsRemaining;
    }

    /**
     * Gets the carrier of the iPhone.
     *
     * @return the carrier.
     */
    public String getCarrier()
    {
        return this.carrier;
    }

    /**
     * Prints the details of the iPhone.
     */
    abstract public void printDetails();
}
