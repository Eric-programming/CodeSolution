 class UIControl
{

}
class ListBox : UIControl
{
    private string selection;

    public string Selection { get => selection; set => selection = value; }
}
class TextBox : UIControl
{
    private string content;

    public string Content { get => content; set => content = value; }
}

class Button : UIControl
{
    private bool isEnabled;

    public bool IsEnabled { get => isEnabled; set => isEnabled = value; }
}
