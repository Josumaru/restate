package id.overlogic.restate.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.overlogic.restate.databinding.ItemRestateBinding
import id.overlogic.restate.models.RealEstate

class ListRealEstateAdapter(private val listRealEstate: ArrayList<RealEstate>): RecyclerView.Adapter<ListRealEstateAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClick(data: RealEstate)
    }

    class ListViewHolder(val binding: ItemRestateBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val binding = ItemRestateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (price, location, area, detail, image, rating) = listRealEstate[position]
        holder.binding.tvPrice.text = "\$${price}"
        holder.binding.tvArea.text = "${area} sqft"
        holder.binding.tvRating.text = "$rating ⭐"

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClick(listRealEstate[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listRealEstate.size

}