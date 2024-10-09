package com.example.yudizapplication.Maps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.yudizapplication.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.Locale

class MapsExample : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mGoogleMap: GoogleMap
    private val MY_PERMISSIONS_REQUEST_LOCATION = 2
    private var mLastLocation: Location? = null
    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    private lateinit var geocoder: Geocoder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_example)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        geocoder = Geocoder(this, Locale.getDefault())

        val btnCurrentLocation = findViewById<Button>(R.id.btn_current_loc)
        btnCurrentLocation.setOnClickListener {
            getCurrentLocation()
        }

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.maps) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
        if (checkLocationPermission()) {
            mGoogleMap.isMyLocationEnabled = true
        } else {
            requestLocationPermission()
        }

        mGoogleMap.setOnMapLongClickListener { latLng ->
            addMarker(latLng)
        }
    }

    private fun getCurrentLocation() {
        if (checkLocationPermission()) {
            mFusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    mLastLocation = location
                    val latLng = LatLng(location.latitude, location.longitude)
                    addMarker(latLng, "You are here", R.drawable.car)
                    mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
                    mGoogleMap.setMyLocationEnabled(false)
                } else {
                    Toast.makeText(this, "Unable to find location", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Toast.makeText(this, "Failed to get location", Toast.LENGTH_SHORT).show()
            }
        } else {
            requestLocationPermission()
        }
    }

    private fun addMarker(latLng: LatLng, title: String? = null, iconResId: Int? = null) {
        val markerOptions = MarkerOptions()
            .flat(true)
            .position(latLng)
            .title(title)
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.car)).anchor(0.5f,0.5f)
        mGoogleMap.clear()
        mGoogleMap.addMarker(markerOptions)

        mGoogleMap.setOnMarkerClickListener { marker ->
            val addresses = geocoder.getFromLocation(marker.position.latitude, marker.position.longitude, 1)
            if (addresses != null) {
                if (addresses.isNotEmpty()) {
                    val address = addresses[0].getAddressLine(0)
                    Toast.makeText(this, address, Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Address not found", Toast.LENGTH_SHORT).show()
                }
            }
            false
        }
    }

    private fun checkLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            AlertDialog.Builder(this)
                .setTitle("Location Permission Needed")
                .setMessage("This app needs the Location permission, please accept the use location functionality")
                .setPositiveButton("ok") { _, _ ->
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), MY_PERMISSIONS_REQUEST_LOCATION)
                }
                .create()
                .show()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), MY_PERMISSIONS_REQUEST_LOCATION)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (checkLocationPermission()) {
                    mGoogleMap.isMyLocationEnabled = true
                    getCurrentLocation()
                }
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Permission Denied")
                    .setMessage("Location permission is required to display your location.")
                    .setPositiveButton("OK", null)
                    .create()
                    .show()
            }
        }
    }
}
