package com.example.mvvmtest.utils

import java.io.IOException

/**
 * Created by Ahsanul Kabir on 8/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
class ApiException(message : String): IOException(message)

class NoInternetException(message: String): IOException(message)