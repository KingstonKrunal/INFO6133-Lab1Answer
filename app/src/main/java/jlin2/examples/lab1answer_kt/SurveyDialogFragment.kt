package jlin2.examples.lab1answer_kt

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import jlin2.examples.lab1answer_kt.R


class SurveyDialogFragment : DialogFragment() {
    private var sendMessages: SendMessages? = null
    var Levels = arrayOf("Level 1", "Level 2", "Level 3", "Level 4")
    var Contents = arrayOf(
        "Immediate Gratification: Pleasure and minimize pain",
        "Comparative/Personal Achievement: Ego Centeredness, better than, gain advantage",
        "Contributive: Do good beyond self, Make an optimal positive difference for others\n",
        "Ultimate Good: Participate in giving and receiving ultimate meaning, goodness, ideals and love."
    )
    var checkedItem = 1
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments!!.getInt("title")
        return AlertDialog.Builder(activity)
            .setTitle(title)
            .setSingleChoiceItems(
                Levels, checkedItem
            ) { dialog, which -> // user checked an item
                sendMessages!!.choiceMade(Levels[which])
            }
            .setPositiveButton(R.string.alert_dialog_ok,
                DialogInterface.OnClickListener { dialog, whichButton ->
                    (activity as MainActivity?)
                        ?.doPositiveClick()
                })
            .setNegativeButton(R.string.alert_dialog_cancel,
                DialogInterface.OnClickListener { dialog, whichButton ->
                    (activity as MainActivity?)
                        ?.doNegativeClick()
                }).create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context!!)
        sendMessages = context as SendMessages?
    }

    //Interface - send message from this fragment to main activity
    internal interface SendMessages {
        fun choiceMade(msg: String?)
    }

    companion object {
        fun newInstance(title: Int): SurveyDialogFragment {
            val frag = SurveyDialogFragment()
            val args = Bundle()
            args.putInt("title", title)
            frag.arguments = args
            return frag
        }
    }
}

