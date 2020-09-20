package com.example.madlevel3task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_portal.*


const val REQ_PORTAL_KEY = "req_reminder"
const val BUNDLE_PORTAL_TITLE = "bundle_portal_title"
const val BUNDLE_PORTAL_URL = "bundle_portal_url"

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddPortal.setOnClickListener {
            onAddPortal()
        }
    }

    private fun onAddPortal() {
        val portalTitle = txtFieldPortalTitle.text.toString();
        val portalUrl = txtFieldPortalUrl.text.toString();

        if (portalTitle.isNotBlank() && portalUrl.isNotBlank()) {
            // set the data as fragment result, we are listening  for REQ_REMINDER_KEY in RemindersFragment
            val listOfPairBundles = bundleOf(
                Pair(BUNDLE_PORTAL_TITLE, portalTitle),
                Pair(BUNDLE_PORTAL_URL, portalUrl)
            )
            setFragmentResult(REQ_PORTAL_KEY, listOfPairBundles)

            //"pop" the backstack, this means we destroy
            //this fragment and go back to the RemindersFragment
            findNavController().popBackStack()
        } else {
            Toast.makeText(activity, "Please check fields!", Toast.LENGTH_SHORT).show()
        }
    }

}