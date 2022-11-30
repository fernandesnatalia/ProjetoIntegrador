package com.example.projetointegrador.ui.qrcode

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetointegrador.databinding.ActivityQrcodeBinding
import com.example.projetointegrador.ui.baseActivity.MainActivity
import com.google.zxing.integration.android.IntentIntegrator

class QRCodeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQrcodeBinding

    companion object {
        const val RESULT = "RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrcodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initScanner()
    }

    private fun initScanner() {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
        integrator.setPrompt("posicione o leitor no qr code")
        integrator.setTorchEnabled(true)
        integrator.setBeepEnabled(true)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}