package project6.park;

/*

    Name: Rider.java
    Purpose: Represents the basic outline of a rider
    Author: grivera64

*/

public abstract class Rider
{

    private int startOnlineTime;
    private int endOnlineTime;
    private int timeOnLine;
    
    public Rider()
    {
    
        //default constructor
    
    }
    
    public Rider(int startOnlineTime)
    {
    
        this.setStartOnlineTime(startOnlineTime);
    
    }
    
    public void setStartOnlineTime(int startOnlineTime)
    {
    
        this.startOnlineTime = startOnlineTime;
    
    }
    
    public void setEndOnlineTime(int endOnlineTime)
    {
    
        this.endOnlineTime = endOnlineTime;
    
    }
    
    public int getStartOnlineTime()
    {
    
        return this.startOnlineTime;
    
    }
    
    public int getEndOnlineTime()
    {
    
        return this.endOnlineTime;
    
    }
    
    public int getTimeOnLine()
    {
    
        return this.timeOnLine;
    
    }
    
    public abstract void setType();
    public abstract int getType();

}