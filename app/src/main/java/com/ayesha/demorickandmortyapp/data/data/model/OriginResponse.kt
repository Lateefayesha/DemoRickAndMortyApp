package com.ayesha.demorickandmortyapp.data.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by merttoptas on 11.03.2022
 */

@Parcelize
data class OriginResponse(
    val name: String?,
    val url: String?,
) : Parcelable