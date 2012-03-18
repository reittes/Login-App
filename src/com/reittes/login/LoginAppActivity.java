package com.reittes.login;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAppActivity extends Activity {
    /** Called when the activity is first created. */
	
//	public static SharedPreferences settings;
//	public static SharedPreferences.Editor editor;
	private String sUsername="";
	private String sPassword="";
	
	//data for post to server
		private ArrayList<NameValuePair> postParameters; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign);
        
 //     settings= getSharedPreferences("SettingsFile", MODE_WORLD_READABLE);
        postParameters= new ArrayList<NameValuePair>();        
        final EditText user= (EditText)findViewById(R.id.fieldUser);
        final EditText pass= (EditText)findViewById(R.id.fieldPass);
        
        final Button signButton= (Button)findViewById(R.id.btnSign);
        signButton.setText("Login");
        signButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Checking !!", Toast.LENGTH_LONG).show();
				if((TextUtils.isEmpty(user.getText().toString()))  || (TextUtils.isEmpty(pass.getText().toString()))){
					Toast.makeText(getApplicationContext(), "Field cannot be empty !!", Toast.LENGTH_LONG).show();
				}else{
					postParameters.add(new BasicNameValuePair("username", "ritesh"));
					postParameters.add(new BasicNameValuePair("password", "pass"));
					
					try{
						String response = CustomHttpClient.executeHttpPost("http://theneolinx.info/clients/capricon/include/welcome.php", postParameters);
						System.out.println("Response="+response);
			/*			char c[]= s.toCharArray();
						for(int i=0; i<c.length;i++){
							System.out.println("Response "+i+"=  "+c[i]);
						}
						boolean isok= false;
						for(int j=0; j< c.length; j++){
							if(j==0&&c[j]=='O'){
								if(c[j+1]=='K'){
									Log.d("RESPONSE", "OK");
									isok= true;
									break;
								}
							}
						}
				*/		
						if(response.toString()=="OK"){
							
							Toast.makeText(getApplicationContext(), "Eureka !!!!", Toast.LENGTH_LONG).show();
						}else{
							Toast.makeText(getApplicationContext(), "Uh Huh !! Try Again !!", Toast.LENGTH_LONG).show();

						}
					}catch(Exception e){

					}
				}
				
			}});
        
        
    }
}