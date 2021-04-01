package com.adisa.diningplus.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class StatusDialogFragment(private val message: String) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the Builder class for convenient dialog construction
        val builder = AlertDialog.Builder(activity!!)
        builder.setTitle("Notice")
                .setMessage(message)
                .setPositiveButton("OK") { dialog, id -> }
        // Create the AlertDialog object and return it
        return builder.create()
    }
}