package ca.bcit.comp2522.lab03;

/**
 * Represents an iPad Air 5 model with specific properties such as memory size and camera resolution.
 */
public class IPadAir5 extends IPad
{
    private static final int[] IPAD_AIR5_VALID_MEMORY = {128, 256, 512};

    private final boolean highResCamera;
    private final int totalMemoryGB;

    /**
     * Constructs a new IPadAir5 with the specified properties.
     *
     * @param hasCase               indicates whether the iPad has a protective case.
     * @param operatingSystemVersion the version of the operating system.
     * @param memory                the total memory in GB; must be one of the valid memory sizes defined in
     *                              the array {@link #IPAD_AIR5_VALID_MEMORY}.
     * @param cameraRes             indicates whether the iPad has a high-resolution camera.
     * @throws IllegalArgumentException if the specified memory is not valid.
     */
    public IPadAir5(final boolean hasCase,
                    final int     operatingSystemVersion,
                    final int     memory,
                    final boolean cameraRes)
    {
        super(hasCase, operatingSystemVersion);

        validateMemory(memory);

        this.totalMemoryGB = memory;
        this.highResCamera = cameraRes;

    }

    private static void validateMemory(final int memory)
    {
        boolean isValid = false;

        for(int i = 0; i < IPAD_AIR5_VALID_MEMORY.length && !isValid; i++)
        {
            if(memory == IPAD_AIR5_VALID_MEMORY[i])
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
     * Gets the total memory of the iPad in gigabytes.
     *
     * @return the total memory in GB.
     */
    public int getTotalMemoryGB()
    {
        return this.totalMemoryGB;
    }

    /**
     * Determines if the iPad has a high-resolution camera.
     *
     * @return {@code true} if the iPad has a high-resolution camera; {@code false} otherwise.
     */
    public boolean isHighResCamera()
    {
        return this.highResCamera;
    }

    /**
     * Prints the details of the iPad to the standard output.
     */
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Returns a hash code value for this iPad. The hash code is based on the operating system version.
     *
     * @return a hash code value for this iPad.
     */
    @Override
    public int hashCode()
    {
        return Double.hashCode(this.getOperatingSystemVersion());
    }


    /**
     * Compares this iPad to the specified object. The result is {@code true} if and only if the argument is not
     * {@code null}, is an {@code IPadAir5}, and has the same operating system version.
     *
     * @param that the object to compare this {@code IPadAir5} against.
     * @return {@code true} if the given object represents an {@code IPadAir5} equivalent to this iPad; {@code false}
     * otherwise.
     */
    @Override
    public boolean equals(Object that)
    {
        if (that == null)
        {
            return false;
        }

        if (!(that instanceof IPadAir5))
        {
            return false;
        }

        if (that == this)
        {
            return true;
        }

        return this.getOperatingSystemVersion() == ((IPadAir5)that).getOperatingSystemVersion();
    }

    /**
     * Returns a string representation of the iPad.
     *
     * @return a string containing the class name, memory size, operating system version, case presence,
     * and camera resolution.
     */
    @Override
    public String toString()
    {
        final StringBuilder sb;

        sb = new StringBuilder();

        sb.append("This ");
        sb.append(this.getClass().getSimpleName());
        sb.append(String.format(" has %dGB of memory\n", this.getTotalMemoryGB()));
        sb.append(String.format("Runs OS version %d\n", this.getOperatingSystemVersion()));

        if (this.hasCase())
        {
            sb.append("Has a protective case\n");
        } else {
            sb.append("Has no protective case\n");
        }

        if (this.isHighResCamera())
        {
            sb.append("Has a high resolution camera.\n");
        } else {
            sb.append("Has no high resolution camera.\n");
        }

        return sb.toString();
    }
}
