package com.example.botwlistactivity

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class botwAdapter (var dataSet: List<botwItem>) :
    RecyclerView.Adapter<botwAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val botwImage: ImageView
        val botwID: TextView
        val botwName: TextView
        val botwCat: TextView
        val layout : ConstraintLayout

        init {
            botwImage = view.findViewById(R.id.imageView_item_image)
            botwID = view.findViewById(R.id.textView_item_id)
            botwName = view.findViewById(R.id.textView_item_name)
            botwCat = view.findViewById(R.id.textView_item_category)
            layout = view.findViewById(R.id.layout_item)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.activity_botw_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val botw = dataSet[position]
        viewHolder.botwID.text = botw.id.toString()
        viewHolder.botwName.text = botw.name
        viewHolder.botwCat.text = botw.category
        viewHolder.layout.setOnClickListener {
            Toast.makeText(it.context, "Hi, you clicked on ${botw.name}", Toast.LENGTH_SHORT).show()
            val context = viewHolder.layout.context
            val botwDetailIntent = Intent(context, botwDetailActivity::class.java).apply{
                putExtra(botwDetailActivity.EXTRA_BOTW, botw)
            }
            context.startActivity(botwDetailIntent)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}