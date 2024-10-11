package id.overlogic.restate.views.fragments

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import id.overlogic.restate.R
import id.overlogic.restate.databinding.ActivityDetailBinding
import id.overlogic.restate.models.RealEstate

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_REAL_ESTATE = "extra_real_estate"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)

        val estate = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<RealEstate>(EXTRA_REAL_ESTATE, RealEstate::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<RealEstate>(EXTRA_REAL_ESTATE)
        }

        if(estate != null){
            Toast.makeText(this, estate.toString(), Toast.LENGTH_SHORT).show()
        }

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}