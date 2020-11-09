// Author; Nithyanandh Mahalingam | ID: 301162314
// Co-Author: Dhrumil Vipul Malaviya | ID: 301058391
// Assignment: MAPD 711 - Assignment 3
// Date: 11/9/2020
package com.example.assignment_2

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException

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
        // Search Button reference:
        val Search = findViewById<Button>(R.id.Search)
        // Search user entry reference:
        val searchLocation = findViewById<EditText>(R.id.AddressSearch)

        Search.setOnClickListener {
            // Init a string to store the location data
            lateinit var Location: String
            Location = searchLocation.text.toString()

            // Init a list to store the list of user searched places in a timeframe
            var addressList = mutableListOf<Address>()

            // Triggering the geocoder to its current state and make it ready to accept in values
            val geocode = Geocoder(this)

            // Reference the geocoder to the address list and store the user searched locations in the list
            addressList = geocode.getFromLocationName(Location, 10)

            // Reference each address stored in the address list and extract its LAT & LONG using Coarse as well as Fine Location tracking.
            val address = addressList!![0]
            val latLng = LatLng(address.latitude, address.longitude)
            mMap!!.addMarker(MarkerOptions().position(latLng).title(Location))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20f))
        }
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
//        R.id.terrain_map -> {
//            mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
//            true
//        }
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
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mMap!!.isMyLocationEnabled = true
            }
        } else {
            mMap!!.isMyLocationEnabled = true
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            mMap.clear()
            when {

                // Default Selection
                parent.getItemAtPosition(position).toString() == "Select a city" -> {
                    val default = LatLng(51.2538, -85.3232)
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(default, 4.4f))
                }

                // Downtown Toronto Selection
                parent.getItemAtPosition(position).toString() == "Toronto" -> {
                    Toast.makeText(
                        parent.context,
                        "Navigating to Downtown Toronto, Ontario...",
                        Toast.LENGTH_SHORT
                    ).show()

                    // Default placeholder restaurant list:
                    val tor_dwntwn = LatLng(43.65, -79.38)
                    val jz_pizza = LatLng(43.645320, -79.389790)
                    val blaze_pizza = LatLng(43.656601, -79.380638)
                    val pizza_pizza = LatLng(43.656350, -79.377300)
                    val panago_pizza = LatLng(43.658930, -79.384040)
                    // mMap.addMarker(MarkerOptions().position(tor_dwntwn).title("Downtown Toronto"))
                    mMap.addMarker(MarkerOptions().position(jz_pizza).title("Jz's Pizza"))
                    mMap.addMarker(MarkerOptions().position(blaze_pizza).title("Blaze Pizza"))
                    mMap.addMarker(MarkerOptions().position(pizza_pizza).title("Pizza Pizza"))
                    mMap.addMarker(MarkerOptions().position(panago_pizza).title("Panago Pizza"))
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(tor_dwntwn, 13.5f))
                }

                // Scarborough Selection
                parent.getItemAtPosition(position).toString() == "Scarborough" -> {
                    Toast.makeText(
                        parent.context,
                        "Navigating to Scarborough, Ontario...",
                        Toast.LENGTH_SHORT
                    ).show()

                    // Default placeholder restaurant list:
                    val scarborough = LatLng(43.77, -79.23)
                    val pizza_nova = LatLng(43.776430, -79.230020)
                    val dominos_pizza = LatLng(43.766955, -79.227633)
                    val pizza_depot = LatLng(43.776143, -79.234309)
                    val ginos_pizza = LatLng(43.782134, -79.234785)
                    // mMap.addMarker(MarkerOptions().position(scarborough).title("Scarborough"))
                    mMap.addMarker(MarkerOptions().position(pizza_nova).title("Pizza Nova"))
                    mMap.addMarker(MarkerOptions().position(dominos_pizza).title("Dominos Pizza"))
                    mMap.addMarker(MarkerOptions().position(pizza_depot).title("Pizza Depot"))
                    mMap.addMarker(MarkerOptions().position(ginos_pizza).title("Ginos Pizza"))
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(scarborough, 13f))
                }

                // Mississauga Selection
                parent.getItemAtPosition(position).toString() == "Mississauga" -> {
                    Toast.makeText(
                        parent.context,
                        "Navigating to Mississauga, Ontario...",
                        Toast.LENGTH_SHORT
                    ).show()
                    val mississauga = LatLng(43.58, -79.64)
                    // mMap.addMarker(MarkerOptions().position(mississauga).title("Mississauga"))
                    Toast.makeText(
                        parent.context,
                        "Enter a place to goto",
                        Toast.LENGTH_SHORT
                    ).show()
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mississauga, 13f))
                }

                // Oakville Selection
                parent.getItemAtPosition(position).toString() == "Oakville" -> {
                    Toast.makeText(
                        parent.context,
                        "Navigating to Oakville, Ontario...",
                        Toast.LENGTH_SHORT
                    ).show()
                    val oakville = LatLng(43.46, -79.68)
                    // mMap.addMarker(MarkerOptions().position(oakville).title("Oakville"))
                    Toast.makeText(
                        parent.context,
                        "Enter a place to goto",
                        Toast.LENGTH_SHORT
                    ).show()
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(oakville, 13f))
                }

                // North York Selection
                parent.getItemAtPosition(position).toString() == "North York" -> {
                    Toast.makeText(
                        parent.context,
                        "Navigating to North York, Ontario...",
                        Toast.LENGTH_SHORT
                    ).show()
                    val north_york = LatLng(43.76, -79.41)
                    // mMap.addMarker(MarkerOptions().position(north_york).title("North York"))
                    Toast.makeText(
                        parent.context,
                        "Enter a place to goto",
                        Toast.LENGTH_SHORT
                    ).show()
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(north_york, 13f))
                }

                // Vaughan Selection
                parent.getItemAtPosition(position).toString() == "Vaughan" -> {
                    Toast.makeText(
                        parent.context,
                        "Navigating to Vaughan, Ontario...",
                        Toast.LENGTH_SHORT
                    ).show()
                    val vaughan = LatLng(43.85, -79.50)
                    // mMap.addMarker(MarkerOptions().position(vaughan).title("Vaughan"))
                    Toast.makeText(
                        parent.context,
                        "Enter a place to goto",
                        Toast.LENGTH_SHORT
                    ).show()
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(vaughan, 13f))
                }

                // Kitchener Selection
                parent.getItemAtPosition(position).toString() == "Kitchener" -> {
                    Toast.makeText(
                        parent.context,
                        "Navigating to Kitchener, Ontario...",
                        Toast.LENGTH_SHORT
                    ).show()
                    val kitchener = LatLng(43.45, -80.49)
                    // mMap.addMarker(MarkerOptions().position(kitchener).title("Kitchener"))
                    Toast.makeText(
                        parent.context,
                        "Enter a place to goto",
                        Toast.LENGTH_SHORT
                    ).show()
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(kitchener, 13f))
                }
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}

