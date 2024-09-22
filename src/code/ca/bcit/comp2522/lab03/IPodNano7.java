package ca.bcit.comp2522.lab03;

public class IPodNano7 extends IPod
{
    private static final boolean IPOD_NANO7_CAMERA_RESOLUTION = false;
    private static final int[] IPOD_NANO7_VALID_MEMORY        = {8, 16};

    private final boolean highResCamera;
    private final int totalMemoryGB;

    public IPodNano7(final int    numOfSongsStored,
                     final double maxVolumeDB,
                     final int    memory)
    {
        super(numOfSongsStored, maxVolumeDB);

        validateMemory(memory);

        this.highResCamera = IPOD_NANO7_CAMERA_RESOLUTION;
        this.totalMemoryGB = memory;
    }

    private static void validateMemory(final int memory)
    {
        boolean isValid;

        isValid = false;

        for(int i = 0; i < IPOD_NANO7_VALID_MEMORY.length && !isValid; i++) // leaves loop if isValid becomes true
        {
            if(memory == IPOD_NANO7_VALID_MEMORY[i])
            {
                isValid = true;
            }
        }

        if (!isValid)
        {
            throw new IllegalArgumentException(String.format("Invalid memory: %d", memory));
        }
    }

    public int getTotalMemoryGB()
    {
        return this.totalMemoryGB;
    }

    @Override
    public boolean equals(final Object that)
    {
        if (that == null)
        {
            return false;
        }

        if (!(that instanceof IPodNano7))
        {
            return false;
        }

        if (this == that)
        {
            return true;
        }

        return (this.getNumOfSongsStored() == ((IPodNano7) that).getNumOfSongsStored());
    }

    @Override
    public int hashCode()
    {
        return Integer.hashCode(this.getNumOfSongsStored());
    }

    public void printDetails()
    {
        System.out.println(this);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb;

        sb = new StringBuilder();

        sb.append("The ");
        sb.append(this.getClass().getSimpleName());
        sb.append(String.format(" has %dGB of memory.\n", this.getTotalMemoryGB()));
        sb.append(String.format("The max volume is %fdB.", this.getMaxVolumeDecibel()));
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
