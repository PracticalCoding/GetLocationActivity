package com.example.getlocationactivity;



import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener {

	 private LocationManager locationManager;
		
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
			
			
			Button bt=(Button) findViewById(R.id.btn1);
			
			bt.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				
					 // getting GPS status
		            boolean isGPSEnabled = locationManager
		                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
		 

					
		           
		             if(!isGPSEnabled)
		            {
		            	  AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
		                  
		                  // Setting Dialog Title
		                  alertDialog.setTitle("GPS settings");
		            
		                  // Setting Dialog Message
		                  alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");
		            
		                  // On pressing Settings button
		                  alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
		                      public void onClick(DialogInterface dialog,int which) {
		                          Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		                          startActivity(intent);
		                      }
		                  });
		            
		                  // on pressing cancel button
		                  alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
		                      public void onClick(DialogInterface dialog, int which) {
		                      dialog.cancel();
		                      }
		                  });
		            
		                  // Showing Alert Message
		                  alertDialog.show();
		            	
		            }
		             else
		             {
		            	 if (locationManager != null) {
			               Location location = locationManager
			                       .getLastKnownLocation(LocationManager.GPS_PROVIDER);
			               if (location != null) {
			                   double latitude = location.getLatitude();
			                   double longitude = location.getLongitude();
			               Toast.makeText(getApplication(),"latitude: "+ latitude +" longitude: "+longitude, Toast.LENGTH_LONG).show();
			               
			               }
					 }
				}
					 }
			});
			  
		}


		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}

}
