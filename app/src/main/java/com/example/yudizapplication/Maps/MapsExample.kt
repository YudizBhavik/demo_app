package com.example.yudizapplication.Maps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.yudizapplication.R
import com.example.yudizapplication.databinding.ActivityMapsExampleBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsExample : AppCompatActivity(), OnMapReadyCallback {

        private lateinit var mGoogleMap: GoogleMap
        private lateinit var binding: ActivityMapsExampleBinding
        val MY_PERMISSIONS_REQUEST_LOCATION = 99

        var mLastLocation: Location? = null

        var mFusedLocationClient: FusedLocationProviderClient? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMapsExampleBinding.inflate(layoutInflater)
            setContentView(binding.root)

            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
            val mapFragment = supportFragmentManager.findFragmentById(R.id.maps) as SupportMapFragment
            mapFragment.getMapAsync(this)
        }

        @RequiresApi(Build.VERSION_CODES.S)
        override fun onMapReady(googleMap: GoogleMap) {
            mGoogleMap = googleMap

            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                mGoogleMap.setMyLocationEnabled(true)
            } else {
                checkLocationPermission()
            }
        }

        override fun onPause() {
            super.onPause()

            mFusedLocationClient?.removeLocationUpdates(mLocationCallback)
        }

        var mLocationCallback: LocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                val locationList = locationResult.locations
                if (locationList.size > 0) {

                    val location = locationList[locationList.size - 1]
                    mLastLocation = location
                    val latLng = LatLng(location.latitude, location.longitude)
                    val markerOptions = MarkerOptions()
                    markerOptions.position(latLng)
                    markerOptions.title(location.latitude.toString() + " : " + location.longitude)
                    mGoogleMap.clear()

                    mGoogleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng))

                    mGoogleMap.addMarker(markerOptions)
                    val cameraPosition =
                        CameraPosition.Builder().target(LatLng(latLng.latitude, latLng.longitude))
                            .zoom(18f).build()
                    mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
                }
            }
        }
        private fun checkLocationPermission() {
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this, Manifest.permission.ACCESS_FINE_LOCATION
                    )
                ) {
                    AlertDialog.Builder(this).setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton(
                            "OK"
                        ) { _, i ->
                            ActivityCompat.requestPermissions(
                                this@MapsExample,
                                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                                MY_PERMISSIONS_REQUEST_LOCATION
                            )
                        }.create().show()
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                        MY_PERMISSIONS_REQUEST_LOCATION
                    )
                }
            }
        }
    }