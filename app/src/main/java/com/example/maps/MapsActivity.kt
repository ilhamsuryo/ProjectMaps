package com.example.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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


        val latitude  = -7.747179
        val longitude =110.355405
        val latMon = -7.749833
        val longMon = 110.369606
        val latPos  = -7.749896
        val longPos = 110.377868
        val zoomlevel =15f
        val overlaySize =110f

        val uty = LatLng(latitude,longitude )
        mMap.addMarker(MarkerOptions()
            .position(uty).title("Universitas Teknologi Yogyakarta").snippet("-7.747179,110.355405").icon(
                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uty,zoomlevel))

        val monjali = LatLng(latMon,longMon)
        mMap.addMarker(MarkerOptions().position(monjali).title("Monumen Jogja Keembali").snippet("-7.749833/110.369606").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        val pos = LatLng(latPos,longPos)
        mMap.addMarker(MarkerOptions().position(pos).title("Kantor Pos Pusat Sleman").snippet("-7.749896/110.377868").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        val googleOverlay= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.uty)).position(uty,overlaySize)
        mMap.addGroundOverlay(googleOverlay)

        val googleOverlay2= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.monjali)).position(monjali,overlaySize)
        mMap.addGroundOverlay(googleOverlay2)

        val googleOverlay3= GroundOverlayOptions().image(BitmapDescriptorFactory.fromResource(R.drawable.pos)).position(pos,overlaySize)
        mMap.addGroundOverlay(googleOverlay3)



    }

}

