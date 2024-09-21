package ca.bcit.comp2522.lab03;

abstract public class IDevice
{

    public IDevice()
    {

    }

    abstract public void printDetails();

    public String getPurpose()
    {
        return "";
    }

    public boolean equals(Object obj)
    {
        return false;
    }

    public int hashCode()
    {
        return 0;
    }

    public String toString()
    {
        return "";
    }
}
