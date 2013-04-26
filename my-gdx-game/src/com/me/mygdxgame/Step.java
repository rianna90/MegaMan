package com.me.mygdxgame;

//Singleton voor het bijhouden van alle stappen
public class Step {
	
	private static Step theInstance;
	public int steps;
	
	private Step()
	{
		steps = 0;
	}
	
    public static Step getInstance()
    {
        if (theInstance == null)
        {
        	theInstance = new Step();
        }
        
        return theInstance;
    }
    
    public void addSteps(int s)
    {
        steps += s;
    }
}
