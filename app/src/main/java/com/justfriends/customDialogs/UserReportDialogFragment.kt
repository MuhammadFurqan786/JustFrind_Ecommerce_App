package com.justfriends.customDialogs

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.justfriends.R
import com.justfriends.databinding.FragmentDialogUserReportBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.preference.PreferenceHelper
import com.justfriends.utils.Global
import com.justfriends.utils.PrefKeys
import com.justfriends.utils.ReportType
import com.justfriends.viewModel.ReportViewModel

private val KEY_REMOTE_USER_ID = "key_remote_user_id"

class UserReportDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentDialogUserReportBinding
    private val reportViewModel: ReportViewModel by viewModels()
    private var reportType = ReportType.REPORT_TYPE_OTHER
    private var mIMainActivity: IMainActivity? = null
    private var mUserId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mUserId = it.getLong(KEY_REMOTE_USER_ID, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDialogUserReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            it.setCancelable(false)
            it.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT
            )
            it.window?.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.bg_dialog_inset
                )
            )
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
        setupObserver()
    }

    private fun setupListener() {
        binding.btCancel.setOnClickListener { dismiss() }
        binding.btSend.setOnClickListener {
            reportUser()
        }
        binding.rgReport.setOnCheckedChangeListener { _, checkedId ->
            reportType = when (checkedId) {
                R.id.rb_inappropriate_profile_picture -> ReportType.REPORT_USER_INAPPROPRIATE_PROFILE_PICTURE
                R.id.rb_user_threatening_me -> ReportType.REPORT_USER_THIS_USER_IS_THREATENING_ME
                R.id.rb_user_insulting_me -> ReportType.REPORT_USER_USER_IS_INSULTING_ME
                R.id.rb_spam -> ReportType.REPORT_USER_SPAM
                R.id.rb_fraud -> ReportType.REPORT_USER_FRAUD
                else -> ReportType.REPORT_USER_OTHER

            }
        }
    }

    private fun setupObserver() {
        reportViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        reportViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            Global.showMessage(binding.root, it)
        }

        reportViewModel.getReportObserver.observe(viewLifecycleOwner) {
            MaterialAlertDialogBuilder(requireContext())
                .setMessage(it.message)
                .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                    dialog.dismiss()
                    dismiss()
                }.show()
        }

    }

    private fun reportUser() {
        val comments = binding.etComments.text.toString().trim()
        reportViewModel.reportUser(
            mIMainActivity?.getPreference()?.getStringValue(PrefKeys.KEY_USER_TOKEN) ?: "",
            mUserId,
            reportType,
            comments
        )


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mIMainActivity = context as IMainActivity
    }

    override fun onDetach() {
        super.onDetach()
        mIMainActivity = null
    }

    fun newInstance(userId: Long): UserReportDialogFragment {
        return UserReportDialogFragment().apply {
            arguments = Bundle().apply {
                putLong(KEY_REMOTE_USER_ID, userId)
            }
        }
    }


}