package fr.dicks.mobile.forumjv.ui.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import fr.dicks.mobile.forumjv.R;
import fr.dicks.mobile.forumjv.ui.fragments.GamePageFragment;

public class MainActivity extends AppCompatActivity implements GamePageFragment.OnFragmentInteractionListener {

    private Boolean connection_status;
    InternalNetworkChangeReceiver internalNetworkChangeReceiver;
    MenuItem item_connectivity;

    private static Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        //should check null because in airplane mode it will be null
        connection_status = (netInfo != null && netInfo.isConnected());

        internalNetworkChangeReceiver = new InternalNetworkChangeReceiver();
        registerReceiver();

        displayGamePageFragment();
    }

    @Override
    protected void onDestroy()
    {
        try
        {
            // Make sure to unregister internal receiver in onDestroy().
            unregisterReceiver(internalNetworkChangeReceiver);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.item_connectivity = menu.findItem(R.id.item_connectivity);
        this.manageConnectivity();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        
        if (id == R.id.item_avatar) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void manageConnectivity() {
        if (item_connectivity != null) {
            if (connection_status) {
                item_connectivity.setIcon(R.drawable.ic_signal_cellular_4_bar_black_24dp);
            } else {
                item_connectivity.setIcon(R.drawable.ic_signal_cellular_connected_no_internet_0_bar_black_24dp);
            }
        }
    }

    private void registerReceiver() {
        try
        {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(internalNetworkChangeReceiver, intentFilter);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class InternalNetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager cm = (ConnectivityManager) MainActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            connection_status = (netInfo != null && netInfo.isConnected());
            //Log.e("Network Availability ", ""+connection_status);

            MainActivity.this.manageConnectivity();
        }
    }

    public void displayGamePageFragment(){
        GamePageFragment fragment = GamePageFragment.newInstance("GamePage", "");
        currentFragment = fragment;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

}
