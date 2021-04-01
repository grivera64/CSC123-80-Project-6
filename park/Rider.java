package project6.park;

/*

    Name: Rider.java
    Purpose: Represents the basic outline of a rider
    Author: grivera64

*/

public abstract class Rider
{

	//private fields
    private int startOnlineTime;
    private int endOnlineTime;
    private int timeOnLine;
    
    //default constructor
    public Rider()
    {
    
        //do nothing
    
    }
    
    //constructor 2 setting startOnlineTime
    public Rider(int startOnlineTime)
    {
    
        this.setStartOnlineTime(startOnlineTime);
    
    }
    
    /* Mutators and Accessors */
    public void setStartOnlineTime(int startOnlineTime)
    {
    
        this.startOnlineTime = startOnlineTime;
    
    }
    
    public void setEndOnlineTime(int endOnlineTime)
    {
    
        this.endOnlineTime = endOnlineTime;
        
        this.timeOnLine = this.getEndOnlineTime() - this.getStartOnlineTime();
    
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
    
    //abstract methods
    public abstract void setType();
    public abstract int getType();

}