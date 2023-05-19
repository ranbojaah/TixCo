import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tixco.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.text.NumberFormat
import java.util.*

class DetailPembelianFragment : BottomSheetDialogFragment() {
    private var numVvip: Int = 0
    private var numVip: Int = 0
    private var numReg: Int = 0
    private var totalHargaVvip: Int = 0
    private var totalHargaVip: Int = 0
    private var totalHargaReg: Int = 0
    private var totalItem: Int = 0
    private var totalHarga: String? = null
    lateinit var totalvvip : TextView
    lateinit var hrgvvip : TextView
    lateinit var ttlvip : TextView
    lateinit var hrgvip : TextView
    lateinit var ttlreg : TextView
    lateinit var hrgreg : TextView
    lateinit var ttlitem : TextView
    lateinit var ttlharga: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_pembelian, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        totalvvip = view.findViewById(R.id.totalvvip)
        hrgvvip = view.findViewById(R.id.total_harga_vvip)
        ttlvip = view.findViewById(R.id.total_vip)
        hrgvip = view.findViewById(R.id.total_harga_vip)
        ttlreg = view.findViewById(R.id.total_reg)
        hrgreg = view.findViewById(R.id.total_harga_reg)
        ttlitem = view.findViewById(R.id.total_item_frg)
        ttlharga = view.findViewById(R.id.total_harga_frg)


        numVvip = arguments?.getInt(ARG_NUM_VVIP) ?: 0
        numVip = arguments?.getInt(ARG_NUM_VIP) ?: 0
        numReg = arguments?.getInt(ARG_NUM_REG) ?: 0
        totalHargaVvip = arguments?.getInt(ARG_TOTAL_HARGA_VVIP) ?: 0
        totalHargaVip = arguments?.getInt(ARG_TOTAL_HARGA_VIP) ?: 0
        totalHargaReg = arguments?.getInt(ARG_TOTAL_HARGA_REG) ?: 0
        totalItem = arguments?.getInt(ARG_TOTAL_ITEM) ?: 0
        totalHarga = arguments?.getString(ARG_TOTAL_HARGA)

        // Update TextViews
        val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
        format.currency = Currency.getInstance("IDR")
        format.maximumFractionDigits = 0

        totalvvip.text = numVvip.toString()
        hrgvvip.text = format.format(totalHargaVvip)
        ttlvip.text = numVip.toString()
        hrgvip.text = format.format(totalHargaVip)
        ttlreg.text = numReg.toString()
        hrgreg.text = format.format(totalHargaReg)
        ttlitem.text = totalItem.toString()
        ttlharga.text = totalHarga
    }

    companion object {
        private const val ARG_NUM_VVIP = "numVvip"
        private const val ARG_NUM_VIP = "numVip"
        private const val ARG_NUM_REG = "numReg"
        private const val ARG_TOTAL_HARGA_VVIP = "totalHargaVvip"
        private const val ARG_TOTAL_HARGA_VIP = "totalHargaVip"
        private const val ARG_TOTAL_HARGA_REG = "totalHargaReg"
        private const val ARG_TOTAL_ITEM = "totalItem"
        private const val ARG_TOTAL_HARGA = "totalHarga"

        fun newInstance(
            numVvip: Int,
            numVip: Int,
            numReg: Int,
            totalHargaVvip: Int,
            totalHargaVip: Int,
            totalHargaReg: Int,
            totalItem: Int,
            totalHarga: String
        ): DetailPembelianFragment {
            val fragment = DetailPembelianFragment()
            val args = Bundle().apply {
                putInt(ARG_NUM_VVIP, numVvip)
                putInt(ARG_NUM_VIP, numVip)
                putInt(ARG_NUM_REG, numReg)
                putInt(ARG_TOTAL_HARGA_VVIP, totalHargaVvip)
                putInt(ARG_TOTAL_HARGA_VIP, totalHargaVip)
                putInt(ARG_TOTAL_HARGA_REG, totalHargaReg)
                putInt(ARG_TOTAL_ITEM, totalItem)
                putString(ARG_TOTAL_HARGA, totalHarga)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
