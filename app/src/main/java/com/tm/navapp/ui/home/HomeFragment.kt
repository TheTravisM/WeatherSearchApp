package com.tm.navapp.ui.home

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.tm.navapp.SharedViewModel
import com.tm.navapp.data.Weather
import com.tm.navapp.databinding.FragmentHomeBinding
import com.tm.navapp.data.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var viewModel: SharedViewModel? = null
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private fun Fragment.hideKeyboard() {
        val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btn = binding.btnGetWeather

        btn.setOnClickListener {
            hideKeyboard()
            // On click grabs text from input assigns to ViewModel
            val cityText = binding.textInputCitySearch.text.toString()
            // IO Making a network call for the UI event
            CoroutineScope(Dispatchers.IO).launch {
                viewModel?.updateWeather(cityText)
            }
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = activity?.run {
            ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        }

        val viewModel = activity?.run {
            ViewModelProvider(this)[SharedViewModel::class.java]
        }

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        // Onclick pulls data from weather API
        viewModel?.weather?.observe(viewLifecycleOwner, Observer {
                weatherData ->
            Log.i("Home Frag", weatherData.toString())
            val output = """Current Weather in ${weatherData.location.name}
                    Temp: ${weatherData.current.temperature}
                    Feels Like: ${weatherData.current.feelslike}
                    Humidity: ${weatherData.current.humidity}
                    Precipitation: ${weatherData.current.precip}"""

            textView.text = output
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
