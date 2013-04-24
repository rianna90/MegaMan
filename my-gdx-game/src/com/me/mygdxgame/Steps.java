package com.me.mygdxgame;

public class Steps {
	
	private static Steps theInstance;
	public int steps;
	
	private Steps()
	{
		steps = 0;
	}
	
    public static Steps getInstance()
    {
        if (theInstance == null)
        {
        	theInstance = new Steps();
        }
        
        return theInstance;
    }
    
    public void addSteps(int s)
    {
        steps += s;
    }

}
