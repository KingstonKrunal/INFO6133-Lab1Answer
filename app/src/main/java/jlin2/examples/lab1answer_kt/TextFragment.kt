package jlin2.examples.lab1answer_kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import jlin2.examples.lab1answer_kt.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TextFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TextFragment : Fragment() {
    var text: TextView? = null
    var vers: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.text_fragment, container, false)
        text = view.findViewById<View>(R.id.Levels) as TextView
        vers = view.findViewById<View>(R.id.Contents) as TextView
        return view
    }

    fun change(txt: String?, txt1: String?) {
        text!!.text = txt
        vers?.setText(txt1)
    }
}