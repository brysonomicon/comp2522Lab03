package ca.bcit.comp2522.lab03;

abstract public class IPod extends IDevice
{
    private static final String IPOD_PURPOSE       = "Music";

    private static final int MINIMUM_SONGS         = 0;

    private static final double MIN_VOLUME_DECIBEL = 0.0;
    private static final double MAX_VOLUME_DECIBEL = 100.0;

    private int numOfSongsStored;
    private double maxVolumeDB;

    public IPod(final int numOfSongsStored,
                final double maxVolumeDB)
    {
        super(IPOD_PURPOSE);

        validateNumOfSongs(numOfSongsStored);
        validateVolume(maxVolumeDB);

        this.numOfSongsStored = numOfSongsStored;
        this.maxVolumeDB      = maxVolumeDB;
    }

    private void validateNumOfSongs(final int numOfSongsStored)
    {
        if(numOfSongsStored < MINIMUM_SONGS)
        {
            throw new IllegalArgumentException(String.format("Invalid number of songs: %d", numOfSongsStored));
        }
    }

    private void validateVolume(final double maxVolumeDB)
    {
        if(maxVolumeDB < MIN_VOLUME_DECIBEL || maxVolumeDB > MAX_VOLUME_DECIBEL)
        {
            throw new IllegalArgumentException(String.format("Volume cannot be less than %f or greater than %f",
                    MIN_VOLUME_DECIBEL, MAX_VOLUME_DECIBEL));
        }
    }

    public int getNumOfSongsStored()
    {
        return this.numOfSongsStored;
    }

    public double getMaxVolumeDecibel()
    {
        return this.maxVolumeDB;
    }

    abstract public void printDetails();
}
