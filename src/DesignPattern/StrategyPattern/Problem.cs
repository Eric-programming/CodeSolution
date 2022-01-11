/**
 * Problem: 
 * - This ImageStore violates the SR Principle
 * - Hard to maintain
 * 
 */
public class ImageStorage
{
    private Compressor compressor;

    public ImageStorage(Compressor compressor)
    {
        this.compressor = compressor;
    }

    public void store(string fileName)
    {
        switch (compressor)
        {
            case Compressor.JPEG:
                System.Console.WriteLine("Do something");
                break;
            case Compressor.PNG:
                System.Console.WriteLine("Do something else");
                break;
            default:
                break;
        }
        //then store the fileName
    }
}
public enum Compressor
{
    JPEG,
    PNG,
}
