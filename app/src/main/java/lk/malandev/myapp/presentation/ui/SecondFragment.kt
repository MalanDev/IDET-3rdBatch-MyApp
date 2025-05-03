package lk.malandev.myapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import lk.malandev.myapp.databinding.FragmentSecondBinding
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    private val args by navArgs<SecondFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(layoutInflater,container,false)

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

//        val name = requireArguments().getString("name")
//        val age = requireArguments().getString("age")
//        val email = requireArguments().getString("email")

        val name = args.name
        val age = args.age
        val email = args.email

        binding.txtName.text = name
        binding.txtAge.text = age
        binding.txtEmail.text = email

        return binding.root
    }

}