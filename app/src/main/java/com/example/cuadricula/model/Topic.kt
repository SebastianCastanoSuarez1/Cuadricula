package com.example.cuadricula.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    @IntegerRes val vacantes: Int,
    @DrawableRes val foto: Int,


    )
