package ca.bcit.comp2522.lab03;

/**
 * Represents an iPad Pro 6 model with specific properties such as memory size and camera resolution.
 *
 * @author Bryson, Phyo, Nam Anh
 * @version 1.0
 */
public class IPadPro6 extends IPad
{
    private static final boolean IPAD_PRO6_CAMERA_HIRES = true;
    private static final int[] IPAD_PRO6_VALID_MEMORY   = {256, 512, 1024};

    private final boolean highResCamera;
    private final int totalMemoryGB;

    /**
     * Constructs a new IPadPro6 with the specified properties.
     *
     * @param hasCase                indicates whether the iPad has a protective case.
     * @param operatingSystemVersion the version of the operating system.
     * @param memoryGB               the total memory in GB; must be one of the valid memory sizes defined in
     *                               the array {@link #IPAD_PRO6_VALID_MEMORY}.
     * @throws IllegalArgumentException if the specified memory is not valid.
     */
    public IPadPro6(final boolean hasCase,
                    final int     operatingSystemVersion,
                    final int     memoryGB)
    {
        super(hasCase, operatingSystemVersion);

        validateMemory(memoryGB);

        this.totalMemoryGB = memoryGB;
        this.highResCamera = IPAD_PRO6_CAMERA_HIRES;
    }

    private static void validateMemory(final int memory)
    {
        boolean isValid = false;

        for(int i = 0; i < IPAD_PRO6_VALID_MEMORY.length && !isValid; i++) // leaves loop if isValid becomes true
        {
            if(memory == IPAD_PRO6_VALID_MEMORY[i])
            {
                isValid = true;
            }
        }

        if(!isValid)
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
     * Prints the details of the iPad to the standard output.
     */
    public void printDetails()
    {
        System.out.println(this);
    }

    /**
     * Returns a hash code value for this iPad. The hash code is based on the total memory in giga bytes.
     * Since IPadPro6 objects are compared by their total memory, all objects can simply return their
     * memory size to satisfy the hashCode - equals contract.
     *
     * @return a hash code value for this iPad.
     */
    @Override
    public int hashCode()
    {
        return this.getTotalMemoryGB();
    }

    /**
     * Compares this iPad to the specified object. The result is {@code true} if and only if the argument is not
     * {@code null}, is an {@code IPadPro6}, and has the same total memory in GB.
     *
     * @param that the object to compare this {@code IPadPro6} against.
     * @return {@code true} if the given object represents an {@code IPadPro6} equivalent to this iPad; {@code false}
     * otherwise.
     */
    @Override
    public boolean equals(final Object that)
    {
        if(that == null)
        {
            return false;
        }

        if(!(that instanceof IPadPro6))
        {
            return false;
        }

        if(this == that)
        {
            return true;
        }

        return this.getTotalMemoryGB() == ((IPadPro6)that).getTotalMemoryGB();
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

        sb.append("The ");
        sb.append(this.getClass().getSimpleName());
        sb.append(String.format(" has %dGB of memory\n", this.getTotalMemoryGB()));
        sb.append(String.format("Runs OS version %d\n", this.getOperatingSystemVersion()));
        if(this.hasCase())
        {
            sb.append("Has a protective case\n");
        }
        else
        {
            sb.append("Has no protective case\n");
        }
        sb.append(String.format("And every %s has a high resolution camera.", this.getClass().getSimpleName()));

        return sb.toString();
    }
}
