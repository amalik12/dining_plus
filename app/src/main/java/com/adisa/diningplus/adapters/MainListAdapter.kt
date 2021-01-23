package com.adisa.diningplus.adapters

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.adisa.diningplus.R
import com.adisa.diningplus.db.entities.Hall
import java.text.DecimalFormat
import java.util.*

class MainListAdapter(private val context: Context) : BaseAdapter() {
    private val preferences: SharedPreferences
    private val shieldMap = HashMap<String, Int>()
    private var halls = ArrayList<Hall>()
    private var openHalls = ArrayList<Hall>()
    private var closedHalls = ArrayList<Hall>()
    private val hallSort = Comparator<Hall> { o1, o2 -> java.lang.Double.compare(o1.distance, o2.distance) }

    internal inner class ViewHolder {
        var shield: ImageView? = null
        var name: TextView? = null
        var distance: TextView? = null
        var occupancy: TextView? = null
    }

    override fun notifyDataSetChanged() {
        halls = ArrayList()
        Collections.sort(openHalls, hallSort)
        Collections.sort(closedHalls, hallSort)
        halls.addAll(openHalls)
        halls.addAll(closedHalls)
        super.notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val viewHolder: ViewHolder
        val item = getItem(position)
        if (convertView == null) {
            viewHolder = ViewHolder()
            convertView = inflater.inflate(R.layout.hall_list, null)
            viewHolder.shield = convertView.findViewById(R.id.shield)
            viewHolder.name = convertView.findViewById(R.id.hall_name)
            viewHolder.distance = convertView.findViewById(R.id.hall_distance)
            viewHolder.occupancy = convertView.findViewById(R.id.hall_occupancy)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }
        val shieldId = shieldMap[item.id]
        if (shieldId != null) {
            viewHolder.shield!!.setImageDrawable(context.resources.getDrawable(shieldId))
        } else {
            viewHolder.shield!!.setImageDrawable(context.resources.getDrawable(R.drawable.commons))
        }
        viewHolder.name!!.text = item.name
        val numberFormat = DecimalFormat("0.00")
        var distance = item.distance
        var unit = " "
        when (preferences.getString("units", "Imperial")) {
            "Metric" -> unit += "km"
            "Imperial" -> {
                distance *= 0.621371
                unit += "mi"
            }
        }
        if (distance > 50) {
            viewHolder.distance!!.text = "> 50$unit"
        } else {
            viewHolder.distance!!.text = "" + numberFormat.format(distance) + unit
        }
        val occupancy = item.occupancy * 10
        if (!item.open) {
            viewHolder.occupancy!!.setTextColor(Color.parseColor("#A8030303"))
        } else if (occupancy >= 80) {
            viewHolder.occupancy!!.setTextColor(Color.parseColor("#d62b2b"))
        } else if (occupancy >= 30) {
            viewHolder.occupancy!!.setTextColor(Color.parseColor("#eb9438"))
        } else {
            viewHolder.occupancy!!.setTextColor(Color.parseColor("#64dd17"))
        }
        viewHolder.occupancy!!.text = if (item.open) "$occupancy%" else "Closed"
        // Gray out closed halls
        convertView!!.alpha = if (item.open) 1f else 0.4f
        return convertView!!
    }

    fun setLists(openHalls: ArrayList<Hall>, closedHalls: ArrayList<Hall>) {
        this.openHalls = openHalls
        this.closedHalls = closedHalls
    }

    override fun getCount(): Int {
        return halls.size
    }

    override fun getItem(position: Int): Hall {
        return halls[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getViewTypeCount(): Int {
        return 2
    }

    init {
        preferences = PreferenceManager.getDefaultSharedPreferences(context)
        shieldMap["BK"] = R.drawable.berkeley
        shieldMap["BR"] = R.drawable.branford
        shieldMap["GH"] = R.drawable.hopper
        shieldMap["ES"] = R.drawable.stiles
        shieldMap["DC"] = R.drawable.davenport
        shieldMap["BF"] = R.drawable.franklin
        shieldMap["MY"] = R.drawable.murray
        shieldMap["JE"] = R.drawable.je
        shieldMap["MC"] = R.drawable.morse
        shieldMap["PC"] = R.drawable.pierson
        shieldMap["SY"] = R.drawable.saybrook
        shieldMap["SM"] = R.drawable.silliman
        shieldMap["TD"] = R.drawable.td
        shieldMap["TC"] = R.drawable.trumbull
    }
}