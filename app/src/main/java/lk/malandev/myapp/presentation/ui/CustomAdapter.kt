package lk.malandev.myapp.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import lk.malandev.myapp.domain.models.Datum
import lk.malandev.myapp.R

class CustomAdapter ():RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    private var _userList:List<Datum> = emptyList()

    fun setUserList(users: List<Datum>){
        _userList = emptyList()
        _userList = users
        notifyDataSetChanged()
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textView: TextView
        val textViewAge: TextView
        val textViewAddress: TextView
        val imageViewAvatar:ImageView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.textViewItem)
            textViewAge = view.findViewById(R.id.txtListViewAge)
            textViewAddress = view.findViewById(R.id.txtListViewAddress)
            imageViewAvatar = view.findViewById(R.id.image_view_avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.simple_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return _userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = _userList[position].firstName.toString()
        holder.textViewAge.text = _userList[position].lastName.toString()
        holder.textViewAddress.text = _userList[position].email

        Glide.with(holder.itemView.context)
            .load(_userList[position].avatar)
            .centerCrop()
            .placeholder(R.drawable.lion_image)
            .into(holder.imageViewAvatar);
    }
}