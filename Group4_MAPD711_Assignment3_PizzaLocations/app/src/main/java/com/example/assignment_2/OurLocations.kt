package com.example.assignment_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class OurLocations : AppCompatActivity(), OnMapReadyCallback, AdapterView.OnItemSelectedListener {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_our_locations)

        // Map Fragment Implementation:
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.Map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            mMap = it
            // mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(null, 5f))
        })

        // ---- Spinner Implementation for selecting the city: ----- //
        val spinner: Spinner = findViewById(R.id.CitySpinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(this, R.array.Cities, android.R.layout.simple_spinner_item).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
            spinner.onItemSelectedListener = this
        }

        // --------------------------------------------------------- //
    }

    // Create a MenuInflater to control the drop down of the Map Views menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.map_views, menu)
        return true
    }

    // Create the onOptionItemSelected method to control what happens when each Map View Item is selected
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        // Change the map type based on the user's selection.
        R.id.normal_map -> {
            mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            true
        }
        R.id.hybrid_map -> {
            mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
            true
        }
        R.id.satellite_map -> {
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
            true
        }
        R.id.terrain_map -> {
            mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            mMap.clear()
            if(parent.getItemAtPosition(position).toString() == "Toronto")
            {
                Toast.makeText(parent.context, "Navigating to Downtown Toronto, Ontario...", Toast.LENGTH_SHORT).show()
                    val tor_dwntwn = LatLng(43.65,-79.38)
                    mMap.addMarker(MarkerOptions().position(tor_dwntwn).title("Downtown Toronto"))
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(tor_dwntwn, 13f))
            }
            else if(parent.getItemAtPosition(position).toString() == "Scarborough")
            {
                Toast.makeText(parent.context, "Navigating to Scarborough, Ontario...", Toast.LENGTH_SHORT).show()
                val scarborough = LatLng(43.77,-79.23)
                mMap.addMarker(MarkerOptions().position(scarborough).title("Scarborough"))
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(scarborough, 13f))
            }
            else if(parent.getItemAtPosition(position).toString() == "Mississauga")
            {
                Toast.makeText(parent.context, "Navigating to Mississauga, Ontario...", Toast.LENGTH_SHORT).show()
                val mississauga = LatLng(43.58,-79.64)
                mMap.addMarker(MarkerOptions().position(mississauga).title("Mississauga"))
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mississauga, 13f))
            }
            else if(parent.getItemAtPosition(position).toString() == "Oakville")
            {
                Toast.makeText(parent.context, "Navigating to Oakville, Ontario...", Toast.LENGTH_SHORT).show()
                val oakville = LatLng(43.46,-79.68)
                mMap.addMarker(MarkerOptions().position(oakville).title("Oakville"))
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(oakville, 13f))
                mMap.setOnMarkerClickListener()
            }
            else if(parent.getItemAtPosition(position).toString() == "North York")
            {
                Toast.makeText(parent.context, "Navigating to North York, Ontario...", Toast.LENGTH_SHORT).show()
                val north_york = LatLng(43.76,-79.41)
                mMap.addMarker(MarkerOptions().position(north_york).title("North York"))
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(north_york, 13f))
            }
            else if(parent.getItemAtPosition(position).toString() == "Vaughan")
            {
                Toast.makeText(parent.context, "Navigating to Vaughan, Ontario...", Toast.LENGTH_SHORT).show()
                val vaughan = LatLng(43.85,-79.50)
                mMap.addMarker(MarkerOptions().position(vaughan).title("Vaughan"))
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(vaughan, 13f))
            }
            else if(parent.getItemAtPosition(position).toString() == "Kitchener")
            {
                Toast.makeText(parent.context, "Navigating to Kitchener, Ontario...", Toast.LENGTH_SHORT).show()
                val kitchener = LatLng(43.45,-80.49)
                mMap.addMarker(MarkerOptions().position(kitchener).title("Kitchener"))
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(kitchener, 13f))
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}

private fun GoogleMap.setOnMarkerClickListener() {

}
