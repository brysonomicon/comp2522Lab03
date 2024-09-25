package ca.bcit.comp2522.lab03;

/**
 * Represents an iPhone SE 3 model with specific properties such as memory size and camera resolution.
 */
public class IPhoneSE3 extends IPhone
{
    private static final boolean IPHONE_SE3_CAMERA_RESOLUTION = false;
    private static final int[] IPHONE_SE3_VALID_MEMORY        = {32, 64};

    private static final int INT_CONVERSION_FACTOR            = 10;

    private final boolean highResCamera;
    private final int totalMemoryGB;

    /**
     * Constructs a new IPhoneSE3 with the specified properties.
     *
     * @param numOfMinsRemaining the number of minutes remaining; must be greater than or equal to {@value IPhone#MINIMUM_MINUTES}.
     * @param carrier            the carrier of the iPhone; must not be null or empty.
     * @param memory             the total memory in GB; must be one of the valid memory sizes defined in
     *                           the array {@link #IPHONE_SE3_VALID_MEMORY}.
     * @throws IllegalArgumentException if the number of minutes remaining is negative, the carrier is null or empty,
     *                                  or the memory size is invalid.
     */
    public IPhoneSE3(final double numOfMinsRemaining,
                     final String carrier,
                     final int    memory)
    {
        super(numOfMinsRemaining, carrier);

        validateMemory(memory);

        this.highResCamera      = IPHONE_SE3_CAMERA_RESOLUTION;
        this.totalMemoryGB      = memory;
    }

    private static void validateMemory(final int memory)
            throws IllegalArgumentException
    {
        boolean isValid;

        isValid = false;

        for(int i = 0; i < IPHONE_SE3_VALID_MEMORY.length && !isValid; i++) // leaves loop if isValid become true
        {
            if(memory == IPHONE_SE3_VALID_MEMORY[i])
            {
                isValid = true;
            }
        }

        if (!isValid)
        {
            throw new IllegalArgumentException(String.format("Invalid memory: %d", memory));
        }
    }

    /**
     * Gets the total memory of the iPhone in gigabytes.
     *
     * @return the total memory in GB.
     */
    public int getTotalMemoryGB()
    {
        return this.totalMemoryGB;
    }

    /**
     * Compares this iPhone to the specified object. The result is {@code true} if and only if the argument is not
     * {@code null}, is an {@code IPhoneSE3}, and has the same sized memory.
     *
     * @param that the object to compare this {@code IPhoneSE3} against.
     * @return {@code true} if the given object represents an {@code IPhoneSE3} equivalent to this iPhone; {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object that)
    {
        if (that == null)
        {
            return false;
        }

        if (!(that instanceof IPhoneSE3))
        {
            return false;
        }

        if (this == that)
        {
            return true;
        }

        return this.getTotalMemoryGB() == ((IPhoneSE3)that).getTotalMemoryGB();
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode()
    {
        return Double.hashCode(this.getNumOfMinsRemaining()) * INT_CONVERSION_FACTOR;
    }

    /**
     * Prints the details of the iPhone to the standard output.
     */
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Returns a string representation of the iPhone.
     *
     * @return a string containing the class name, memory size, carrier, number of minutes remaining, and camera resolution.
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;

        sb = new StringBuilder();

        sb.append("The ");
        sb.append(this.getClass().getSimpleName());
        sb.append(String.format(" has %dGB of memory.\n", this.getTotalMemoryGB()));
        sb.append(String.format("Uses %s ", this.getCarrier()));
        sb.append(String.format(" and has %f number of minutes remaining.", this.getNumOfMinsRemaining()));
        if (highResCamera)
        {
            sb.append(String.format(" And %s has a high-resolution camera.", this.getClass().getSimpleName()));
        }
        else
        {
            sb.append(String.format(" And %s has a low-resolution camera.", this.getClass().getSimpleName()));
        }

        return sb.toString();
    }
}
