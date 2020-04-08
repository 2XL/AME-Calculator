package ame.optatiu.calculadora.iva;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorIVA extends Activity {
	
	public static final String tag = "CalculadoraIVA";
	
	
	EditText etPrice;
	EditText etIVA;
	EditText etTotal;
	
	Button bCalculate;
	Button bConverter;
	
	double price;
	double iva;
	double total;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initControls();	// initiate controlers, listeners...
 
	}
	
	private void initControls(){
		this.etPrice = (EditText)findViewById(R.id.etPrice);
		this.etIVA = (EditText)findViewById(R.id.etIVA);
		this.etTotal = (EditText)findViewById(R.id.etTotal);
		
		bCalculate =  (Button)findViewById(R.id.bMake);
		bCalculate.setOnClickListener(new OnClickListener(){
		
		
			@Override
			public void onClick(View v) { 
				/*
				 * mostrar per la finestra de log el que esta passat.
				 * 
				 */
				try{
					//   layout d'android només permet input numeric
				Log.i(CalculatorIVA.tag, "onClicked buttonCalculate");
				
				
				// TODO Auto-generated method stub
				price =  Double.parseDouble(etPrice.getText().toString());
				iva =  Double.parseDouble(etIVA.getText().toString());
				total = (1+iva/100) * price; 
				etTotal.setText(Double.toString(total));
				} catch (NumberFormatException e) {
					// TODO: handle exception
					e.printStackTrace();
					etTotal.setText("Math ERROR");
					
				}catch (Exception e){
					 
					Log.e(CalculatorIVA.tag, "Error en el calcul del iva" + e.getMessage());
					e.printStackTrace(); // mostrar la escalada recursiva del error (propagació)
					etTotal.setText("Math ERROR");
				 
				} 
			}
			
		});
		
		bConverter = (Button)findViewById(R.id.bCConverter);
		bConverter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			 
				String appClass = "CoinConverter";
				Class ourClass;
				try {
					ourClass = Class.forName("ame.optatiu.calculadora.iva."+appClass);
					Intent ourIntent = new Intent(CalculatorIVA.this, ourClass); // carregar aquesta activitat 
					startActivity(ourIntent);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	// string for the path starting point
				 
			}
		});
	}
	
	 



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
