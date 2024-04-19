package com.cupp.msu.criminalintentchapter9a

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cupp.msu.criminalintentchapter9a.databinding.ListItemCrimeBinding


class CrimeHolder (
    val binding: ListItemCrimeBinding

): RecyclerView.ViewHolder(binding.root){

fun bind(crime:Crime){

    binding.crimeTitle.text = crime.title
    // binding.crimeDate.text = crime.date.toString()
    val formattedDate = DateFormat.format("MMM dd, yyyy", crime.date)

    binding.crimeDate.text = formattedDate


    binding.root.setOnClickListener{

        Toast.makeText(

            binding.root.context,
            "${crime.title} clicked",
            Toast.LENGTH_SHORT
        ).show()
    }

    binding.crimeSolved.visibility = if (crime.isSolved) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

class CrimeListAdapter(private val crimes: List<Crime>): RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)


    }


    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        /*       holder.apply {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()*/
        holder.bind(crime)

    }

    override fun getItemCount() = crimes.size


}
}