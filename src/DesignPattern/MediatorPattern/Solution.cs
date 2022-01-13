abstract class DialogBox
{
    public abstract void Change(UIControl control);
}
class ArticlesDialogBox : DialogBox
{
    private ListBox listBox;
    private TextBox textBox;
    private Button saveButton;
    public ArticlesDialogBox()
    {
        listBox = new ListBox(this);
        textBox = new TextBox(this);
        saveButton = new Button(this);
    }
    public override void Change(UIControl control)
    {
        if (control == listBox)
        {

        }
        else if (control == textBox)
        {

        }
        else
        {

        }
    }
}
class UIControl
{
    protected DialogBox owner;

    public UIControl(DialogBox owner)
    {
        this.owner = owner;
    }
}
class ListBox : UIControl
{
    private string selection;

    public ListBox(DialogBox owner) : base(owner)
    {
    }

    public string Selection
    {
        get => selection;
        set
        {
            selection = value;
            owner.Change(this);
        }
    }
}
class TextBox : UIControl
{
    private string content;

    public TextBox(DialogBox owner) : base(owner)
    {
    }

    public string Content
    {
        get => content;
        set
        {
            content = value;
            owner.Change(this);
        }
    }
}

class Button : UIControl
{
    private bool isEnabled;

    public Button(DialogBox owner) : base(owner)
    {
    }

    public bool IsEnabled
    {
        get => isEnabled;

        set
        {
            isEnabled = value;
            owner.Change(this);
        }
    }
}
