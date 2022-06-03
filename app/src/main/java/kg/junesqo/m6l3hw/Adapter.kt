package kg.junesqo.m6l3hw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.junesqo.m6l3hw.databinding.ImageItemBinding
import kg.junesqo.m6l3hw.extensions.load
import kotlin.reflect.KFunction0

class Adapter(val list: ArrayList<String>, private val onClicked: (image: String) -> Unit?, private val onRemoved: (image: String) -> Unit?): RecyclerView.Adapter<Adapter.ImageViewHolder>() {

//    private lateinit var onClick: OnClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

//    fun setOnClick(onClick: OnClick){
//        this.onClick = onClick
//    }


    inner class ImageViewHolder(private var binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) {
            binding.ivImage.load(image)
            binding.ivImage.setOnClickListener {
                if (binding.background.visibility == View.GONE) {
                    binding.background.visibility = View.VISIBLE
                    onClicked(image)
                } else {
                    binding.background.visibility = View.GONE
                    onRemoved(image)
                }
            }
        }

    }

//    interface OnClick {
//        fun onClicked(position: String)
//        fun onRemoved(position: String)
//    }
}