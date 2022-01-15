interface IHtmlNode
{
    public void Click();

    public void Type();
}

class Button : IHtmlNode
{
    public void Click()
    {
        throw new System.NotImplementedException();
    }

    public void Type()
    {
        throw new System.NotImplementedException();
    }
}

class InputBox : IHtmlNode
{
    public void Click()
    {
        throw new System.NotImplementedException();
    }

    public void Type()
    {
        throw new System.NotImplementedException();
    }
}
