package com.project.kumpulandoa

import com.google.gson.annotations.SerializedName

data class ResponseDoaAlquran(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("nama_doa")
	val namaDoa: Int? = null
)

data class DataItem(

	@field:SerializedName("id_kategori")
	val idKategori: Int? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("isi_doa")
	val isiDoa: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("nama_doa")
	val namaDoa: String? = null
)
