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
    public void NotifyObservers(int value)
    {
        foreach (var observer in observers)
        {
            observer.Update(value);
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
            NotifyObservers(value);
        }
    }
}
interface Observer
{
    void Update(int value);
}
class SpreadSheet : Observer
{
    public void Update(int value)
    {
        throw new System.NotImplementedException();
    }
}
class Chart : Observer
{
    public void Update(int value)
    {
        throw new System.NotImplementedException();
    }
}
