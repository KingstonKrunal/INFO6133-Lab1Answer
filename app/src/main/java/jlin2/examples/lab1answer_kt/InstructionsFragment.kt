package jlin2.examples.lab1answer_kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import jlin2.examples.lab1answer_kt.R


class InstructionsFragment : ListFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    var Levels = arrayOf("Level 1", "Level 2", "Level 3", "Level 4")
    var Contents = arrayOf(
        "Immediate Gratification: Pleasure and minimize pain",
        "Comparative/Personal Achievement: Ego Centeredness, better than, gain advantage",
        "Contributive: Do good beyond self, Make an optimal positive difference for others\n",
        "Ultimate Good: Participate in giving and receiving ultimate meaning, goodness, ideals and love."
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.list_fragment, container, false)
        val adapter = ArrayAdapter(
            activity!!,
            android.R.layout.simple_list_item_1, Levels
        )
        listAdapter = adapter
        return view
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        val txt = requireFragmentManager().findFragmentById(R.id.fragmentContainerView3) as TextFragment?
        txt!!.change(Levels[position], Contents[position])
        listView.setSelector(android.R.color.holo_blue_dark)
    }

}