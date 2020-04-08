package ame.optatiu.calculadora.iva;

  

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView; 
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner; 
import ame.optatiu.calculadora.divisa.*;



public class CoinConverter extends Activity {

	public static final String tag = "CoinConverter";
	
	double base = 0; 
	double result; 	// input value by user
	double sourceCoin;		// source exponent
	double targetCoin;	// target exponent
	
	Button bCalculadoraIVA; // the user can always use the default back button...
	
	EditText etBase;
	EditText etResult;
	
	Spinner sSourceCoin;
	Spinner sTargetCoin;
	
	/*
	 * seria convenient implementar un menú pero ya veurem 
	 */
	
	private void initCoinConverterLayout(){ 
		 
		bCalculadoraIVA = (Button) findViewById(R.id.bCalculadoraIVA);
		
		etBase = (EditText) findViewById(R.id.etBase);
		etResult = (EditText) findViewById(R.id.etResultDivisa);
  
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Coin.names());
		
		sSourceCoin = (Spinner) findViewById(R.id.sSouceCoin);	
		sSourceCoin.setAdapter(adapter); 
		sTargetCoin = (Spinner) findViewById(R.id.sTargetCoin); 
		sTargetCoin.setAdapter(adapter); 
		
	}
	
	
	// called when the activity is first created
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.cconverter);
		
		// init variables  
		initCoinConverterLayout();
		 
		 
	
		sSourceCoin.setOnItemSelectedListener(
				
	               new AdapterView.OnItemSelectedListener() {
	            	    
	                   public void onItemSelected(
	                           AdapterView<?> parent, 
	                           View view, 
	                           int position, 
	                           long id) {
	                	   
	         
	                  	  Log.i(CoinConverter.tag, "Souce Coin Spinner Item Selected: "+result+" = "+ sourceCoin+" * "+ targetCoin +" * "+base);
	                  	try{ 
	                  	  base = Double.parseDouble(etBase.getText().toString()); 
	            		} catch (NumberFormatException e) {
	    					// TODO: handle exception
	    					e.printStackTrace();
	    					etResult.setText("Math ERROR");
	    					
	    				}
	                  	  sourceCoin = Coin.valueOf(sSourceCoin.getSelectedItem().toString()).getValue();
	                  	  targetCoin = Coin.valueOf(sTargetCoin.getSelectedItem().toString()).getValue();
	                  	  result = CoinManager.convert(base, sourceCoin, targetCoin);
		                	etResult.setText(Double.toString(result));
	                   }

	                   public void onNothingSelected(AdapterView<?> parent) {
	                	   
	                   }
	               }
	           );
		
		 
		 sTargetCoin.setOnItemSelectedListener(
					
	               new AdapterView.OnItemSelectedListener() {
	            	    
	                   public void onItemSelected(
	                           AdapterView<?> parent, 
	                           View view, 
	                           int position, 
	                           long id) {
	                	  
	         
	                  	  Log.i(CoinConverter.tag, "Souce Coin Spinner Item Selected: "+result+" = "+ sourceCoin+" * "+ targetCoin +" * "+base);
	                  	try{ 
	                  	  base = Double.parseDouble(etBase.getText().toString()); 
	            		} catch (NumberFormatException e) {
	    					// TODO: handle exception
	    					e.printStackTrace();
	    					etResult.setText("Math ERROR");
	    					
	    				}
	                  	  sourceCoin = Coin.valueOf(sSourceCoin.getSelectedItem().toString()).getValue();
	                  	  targetCoin = Coin.valueOf(sTargetCoin.getSelectedItem().toString()).getValue();
	                  	  result = CoinManager.convert(base, sourceCoin, targetCoin);
		                	etResult.setText(Double.toString(result));
	                   }

	                   public void onNothingSelected(AdapterView<?> parent) {
	                	   
	                   }
	               }
	           );
	           
		
		

		 
		 bCalculadoraIVA.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish(); 
			}
		});
		
		 
		 
		 
	}  
	
	
	
}
