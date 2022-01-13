//Observable
class Subject
{
    public List<Observer> observers = new List<Observer>();
    public void AddObserver(Observer observer)
    {
        observers.Add(observer);
    }
    public void RemoveObserver(Observer observer)
    {
        observers.Remove(observer);
    }
    public void NotifyObservers()
    {
        foreach (var observer in observers)
        {
            observer.Update();
        }
    }
}
class DataSource : Subject
{
    private int value;

    public int Value
    {
        get => value;
        set
        {
            this.value = value;
            NotifyObservers();
        }
    }
}
interface Observer
{
    void Update();
}
class SpreadSheet : Observer
{
    private readonly DataSource dataSource;

    public SpreadSheet(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }
    public void Update()
    {
        int subscribeVal = dataSource.Value;
    }
}
class Chart : Observer
{
    private readonly DataSource dataSource;

    public Chart(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }
    public void Update()
    {
        int subscribeVal = dataSource.Value;
    }
}
