/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codeCheck

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import jp.co.yumemi.android.codeCheck.TopActivity.Companion.lastSearchDate
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.databinding.FragmentTwoBinding

class TwoFragment : Fragment(R.layout.fragment_two) {

    private val args: TwoFragmentArgs by navArgs()

    private var _binding: FragmentTwoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("検索した日時", lastSearchDate.toString())

        _binding = FragmentTwoBinding.bind(view)

        val item = args.item

        binding.ownerIconView.load(item.ownerIconUrl)
        binding.nameView.text = item.name
        binding.languageView.text = item.language
        binding.starsView.setText(item.stargazersCount + " stars")
        binding.watchersView.setText(item.watchersCount + " watchers")
        binding.forksView.setText(item.forksCount + " forks")
        binding.openIssuesView.setText(item.openIssuesCount + " open issues")
    }
}
