package ame.optatiu.calculadora.divisa;
 

//import java.util.Map;

public class CoinManager
{
	//private static Map<Coins, Float> coinMap;
	
	public static double convert(double base, double sourceCoin, double targetCoin)
	{
		/*
		 * 1r convertir a euro luego 
		 */
		if(sourceCoin == targetCoin)	
			return base;
		
		if(sourceCoin == 1)
			return base * targetCoin;
		
		return convert(base/sourceCoin, 1, targetCoin);
		
	}

}
