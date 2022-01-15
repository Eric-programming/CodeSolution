class Rectangle
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
    //...Additional features
}

class Square : Rectangle
{
    int width;
    public void setWidth(int w = 5)
    {
        width = w;
    }
    public void setHeight(int h = 6)
    {
        width = h;
    }
}
