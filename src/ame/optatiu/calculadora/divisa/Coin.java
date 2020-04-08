package ame.optatiu.calculadora.divisa;

public enum Coin {
	Euro(1), 
	USDollar(0.8), 
	Yen(10), 
	Pound(13);
	
	private final double coin;
	
	Coin(double coin) 
	{ 
		this.coin = coin; 
	}
	
	public String toString(){
		return Double.toString(coin);
	}
	
    public double getValue() { return coin; }
    
    
    
    public static String[] names() {
        Coin[] coins = values();
        String[] names = new String[coins.length];

        for (int i = 0; i < coins.length; i++) {
            names[i] = coins[i].name();
        }

        return names;
    }
    
    
}