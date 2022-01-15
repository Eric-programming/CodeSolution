class Rectangle : Shape
{
    int width, height;
    public void setWidth(int w)
    {
        width = w;
    }
    public void setHeight(int h)
    {
        height = h;
    }
}

class Square : Shape
{
    int width;
    public void setWidth(int w = 5)
    {
        width = w;
    }
}
class Shape
{
    //Additional Features ... 
}
