package ca.bcit.comp2522.lab03;

/**
 * Represents an iPod Touch 7 with specific properties such as memory size and camera resolution.
 *
 * @author Bryson
 * @author Phyo
 * @version 1.0
 */
public class IPodTouch7 extends IPod
{
    private static final boolean IPOD_TOUCH7_CAMERA_RESOLUTION = false;
    private static final int[] IPOD_TOUCH7_VALID_MEMORY        = {16, 32};

    private final boolean highResCamera;
    private final int     totalMemoryGB;

    /**
     * Constructs a new IPodTouch7 with the specific properties.
     *
     * @param numOfSongsStored the number of songs stored; must be more than MINIMUM_SONGS
     * @param maxVolumeDB      the maximum volume of the iPod; must not be less than MIN_VOLUME_DECIBEL
     *                         or greater than MAX_VOLUME_DECIBEL
     * @param memory           the total memory in GB; must be one of the valid memory sizes defined in the array
     *                         {@link #IPOD_TOUCH7_VALID_MEMORY}
     * @throws IllegalArgumentException if the number of songs is negative; the maximum volume is invalid or
     *                                  the memory size is invalid.
     */
    public IPodTouch7(final int    numOfSongsStored,
                      final double maxVolumeDB,
                      final int    memory)
    {
        super(numOfSongsStored, maxVolumeDB);

        validateMemory(memory);

        this.highResCamera = IPOD_TOUCH7_CAMERA_RESOLUTION;
        this.totalMemoryGB = memory;
    }

    private static void validateMemory(final int memory)
    {
        boolean isValid;

        isValid = false;

        for(int i = 0; i < IPOD_TOUCH7_VALID_MEMORY.length && !isValid; i++)
        {
            if(memory == IPOD_TOUCH7_VALID_MEMORY[i])
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
     * Gets the total memory of the iPod in gigabytes.
     *
     * @return the total memory in GB.
     */
    public int getTotalMemoryGB()
    {
        return totalMemoryGB;
    }

    /**
     * Compares this iPod to the specified object. The result is {@code true} if and only if the argument is not
     * {@code null}, is an {@code IPodTouch7}, and has the same number of songs stored.
     *
     * @param that the object to compare this {@code IPodTouch7} against.
     * @return {@code true} if the given object represents an {@code IPodTouch7} equivalent to this iPod;
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object that)
    {
        if (that == null)
        {
            return false;
        }

        if (!(that instanceof IPodTouch7))
        {
            return false;
        }

        if (this == that)
        {
            return true;
        }

        return (this.getNumOfSongsStored() == ((IPodTouch7) that).getNumOfSongsStored());
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode()
    {
        return Integer.hashCode(this.getNumOfSongsStored());
    }

    /**
     * Prints the details of the iPod to the standard output.
     */
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Returns a string representation of the iPod.
     *
     * @return a string containing the class name, memory size, the max volume, number of minutes remaining, and camera resolution.
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;

        sb = new StringBuilder();

        sb.append("The ");
        sb.append(this.getClass().getSimpleName());
        sb.append(String.format(" has %dGB of memory.\n", this.getTotalMemoryGB()));
        sb.append(String.format("The max volume is %fdB", this.getMaxVolumeDecibel()));
        sb.append(String.format(" and has %d songs.\n", this.getNumOfSongsStored()));
        if (highResCamera)
        {
            sb.append(String.format("And %s has a high-resolution camera.", this.getClass().getSimpleName()));
        }
        else
        {
            sb.append(String.format("And %s has a low-resolution camera.", this.getClass().getSimpleName()));
        }

        return sb.toString();
    }

}
