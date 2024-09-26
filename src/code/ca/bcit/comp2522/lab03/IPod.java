package ca.bcit.comp2522.lab03;

/**
 * Represents an abstract IPod with a specific purpose.
 *
 * @author Bryson, Phyo
 * @version 1.0
 */
abstract public class IPod extends IDevice
{
    private static final String IPOD_PURPOSE       = "Music";

    private static final int MINIMUM_SONGS         = 0;

    private static final double MIN_VOLUME_DECIBEL = 0.0;
    private static final double MAX_VOLUME_DECIBEL = 100.0;

    private int numOfSongsStored;
    private double maxVolumeDB;

    /**
     * Constructs an IPod with the specified purpose.
     *
     * @param numOfSongsStored the number of songs stored; must not be null
     * @param maxVolumeDB      the maximum volume of the iPod; must not be less than MIN_VOLUME_DECIBEL
     *                         or greater than MAX_VOLUME_DECIBEL
     */
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

    /**
     * Gets the number of songs stored in an IPod.
     *
     * @return the total number of songs
     */
    public int getNumOfSongsStored()
    {
        return this.numOfSongsStored;
    }

    /**
     * Gets the maximum volume in decibel.
     *
     * @return the maximum of volume
     */
    public double getMaxVolumeDecibel()
    {
        return this.maxVolumeDB;
    }

    /**
     * Prints the details of IPod.
     */
    abstract public void printDetails();
}
