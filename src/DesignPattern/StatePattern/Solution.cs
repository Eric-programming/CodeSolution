//Why not abstract class?
//We use abstract class if we want to provide common code to child class
public interface ITool
{
    void mouseDown();
    void mouseUp();
}
public class Canvas
{
    private ITool curTool;

    internal ITool CurTool { get => curTool; set => curTool = value; }

    public void mouseDown()
    {
        curTool.mouseDown();
    }
    public void mouseUp()
    {
        curTool.mouseUp();
    }
}

public class SelectionTool : ITool
{
    public void mouseDown()
    {
        throw new System.NotImplementedException();
    }

    public void mouseUp()
    {
        throw new System.NotImplementedException();
    }
}

public class BrushTool : ITool
{
    public void mouseDown()
    {
        throw new System.NotImplementedException();
    }

    public void mouseUp()
    {
        throw new System.NotImplementedException();
    }
}
