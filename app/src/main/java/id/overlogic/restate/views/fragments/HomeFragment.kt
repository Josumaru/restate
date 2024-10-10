package id.overlogic.restate.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import id.overlogic.restate.R
import id.overlogic.restate.adapters.ListRealEstateAdapter
import id.overlogic.restate.databinding.FragmentHomeBinding
import id.overlogic.restate.models.RealEstate

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var listRealEstate: ArrayList<RealEstate>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        listRealEstate = ArrayList()
        binding.rvRealEstate.setHasFixedSize(true)

        listRealEstate.addAll(getListRealEstate())
        Toast.makeText(requireContext(), "Total estates: ${listRealEstate.size}", Toast.LENGTH_SHORT).show()
        showRecyclerList()
        return binding.root
//        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun getListRealEstate(): ArrayList<RealEstate> {
        val realEstates = ArrayList<RealEstate>()
        realEstates.add(
            RealEstate(
                "150,000",
                "Jakarta",
                75,
                "Luxury Apartement",
                "https://example.com/image1.jpg",
                5.7
            )
        )
        realEstates.add(
            RealEstate(
                "150,000",
                "Jakarta",
                75,
                "Luxury Apartement",
                "https://example.com/image1.jpg",
                5.0
            )
        )

        return realEstates
    }

    private fun showRecyclerList() {
        binding.rvRealEstate.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val listRealEstateAdapter = ListRealEstateAdapter(listRealEstate)
        binding.rvRealEstate.adapter = listRealEstateAdapter

    }

}