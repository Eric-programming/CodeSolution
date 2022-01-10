public class Canvas
{
    private ToolType toolType;

    public ToolType ToolType { get => toolType; set => toolType = value; }

    public void mouseDown()
    {
        switch (toolType)
        {
            case ToolType.SELECTION:
                System.Console.WriteLine("Do something....");
                break;
            case ToolType.BRUSH:
                System.Console.WriteLine("Do something....");
                break;
            case ToolType.EARSER:
                System.Console.WriteLine("Do something....");
                break;
            default:
                System.Console.WriteLine("Do something....");
                break;
        }
    }
    public void mouseUp()
    {
        switch (toolType)
        {
            case ToolType.SELECTION:
                System.Console.WriteLine("Do something....");
                break;
            case ToolType.BRUSH:
                System.Console.WriteLine("Do something....");
                break;
            case ToolType.EARSER:
                System.Console.WriteLine("Do something....");
                break;
            default:
                System.Console.WriteLine("Do something....");
                break;
        }
    }
}

public enum ToolType
{
    SELECTION,
    BRUSH,
    EARSER
}
