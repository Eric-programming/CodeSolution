public class ImageStorage
{
    public void store(string fileName, ICompressor compressor)
    {
        compressor.compress();
        //then store the fileName
    }
}
public interface ICompressor
{
    void compress();
}
public class JPEGCompressor : ICompressor
{
    public void compress()
    {
        throw new System.NotImplementedException();
    }
}
public class PNGCompressor : ICompressor
{
    public void compress()
    {
        throw new System.NotImplementedException();
    }
}

public enum Compressor
{
    JPEG,
    PNG,
}
