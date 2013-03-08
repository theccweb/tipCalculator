package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	protected static final double TIP_RATE = 0.12;
	protected static final String COIN = "$";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		final EditText input = (EditText)findViewById(R.id.edtBillAmount);
		final CheckBox needRound = (CheckBox)findViewById(R.id.chkRound);
		final TextView tip = (TextView)findViewById(R.id.txtTipResult);
		final Button calcTipButton = (Button)findViewById(R.id.btnCalculate);
		
		calcTipButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				double bill = Double.parseDouble(input.getText().toString());
				double calculatedTip = bill * TIP_RATE;
				if(needRound.isChecked()){
					calculatedTip = Math.round(calculatedTip);
				}
				tip.setText(String.format("Tip: " + COIN + "%.2f", calculatedTip));
			}
		});
	}
}
