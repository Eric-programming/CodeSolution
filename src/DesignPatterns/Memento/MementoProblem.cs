class MementoProblem
{
    static void Main(string[] args)
    {
        var contentEditor = new ContentEditor();
        contentEditor.Content = "1";
        contentEditor.Content = "2";
        contentEditor.Content = "3";
        contentEditor.Undo(); //<= What if I also want to add header with undo?
    }
    public class ContentEditor
    {
        private string _content;

        private List<string> prevContents = new List<string>();
        public string Content
        {
            get { return _content; }
            set
            {
                _content = value;
                prevContents.Add(_content);
            }
        }

        public void Undo()
        {
            int lastIndex = prevContents.Count - 1;
            _content = prevContents[lastIndex];
            prevContents.RemoveAt(lastIndex);
        }
    }
}
