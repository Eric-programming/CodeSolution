interface IHtmlButtonNode
{
    public void Click();

}
interface IHtmlInputNode
{
    public void Type();
}

class Button : IHtmlButtonNode
{
    public void Click()
    {
        throw new System.NotImplementedException();
    }
}

class InputBox : IHtmlInputNode
{
    public void Type()
    {
        throw new System.NotImplementedException();
    }
}
