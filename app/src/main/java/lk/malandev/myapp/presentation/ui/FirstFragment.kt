package lk.malandev.myapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import lk.malandev.myapp.presentation.viewmodels.MainViewModel
import lk.malandev.myapp.domain.models.User
import lk.malandev.myapp.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(layoutInflater,container,false)

        mainViewModel.userData.observe(viewLifecycleOwner, Observer {
            binding.editTextName.setText(it.name.toString())
            binding.editTextAge.setText(it.age.toString())
            binding.editTextEmail.setText(it.email.toString())
        })

        var user = User(0,"Malan",23,"abc def","abc@g.com")
        mainViewModel.setData(user)

        binding.btnNext.setOnClickListener {

          val name = binding.editTextName.text.toString()
            val age = binding.editTextAge.text.toString()
            val email = binding.editTextEmail.text.toString()
//
//            val args = bundleOf(
//                "name" to name,
//                "age" to age,
//                "email" to email
//            )
//
//           findNavController().navigate(R.id.action_firstFragment_to_secondFragment,args)
//
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(name, age, email)
            findNavController().navigate(action)
        }



        return binding.root

    }

}