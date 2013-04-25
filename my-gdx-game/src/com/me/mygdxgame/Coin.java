package com.me.mygdxgame;

public class Coin {
	
	private static Coin theInstance;
	public int coins;
	
	private Coin()
	{
		coins = 0;
	}
	
    public static Coin getInstance()
    {
        if (theInstance == null)
        {
        	theInstance = new Coin();
        }
        
        return theInstance;
    }
    
    public void addCoins(int c)
    {
        coins += c;
    }
}
