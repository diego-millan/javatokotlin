package com.drm.learning.javatokt.utils

import java.util.regex.Pattern

class QuantityValidationUtil {
    companion object {
        private fun isNumericWithZeroesDecimals(value: String): Boolean {
            val numericOnlyPattern = Pattern.compile("[0-9]+([.|,]0{1,2})\$")
            return numericOnlyPattern.matcher(value).matches()
        }

        fun isNumericWithDecimals(value: String): Boolean {
            val decimalNumberPattern = Pattern.compile("[0-9]+[.|,]([1-9]([0-9]?)|([0-9][1-9]))\$")
            return decimalNumberPattern.matcher(value).matches()
        }

        private fun isNumberWithDots(value: String): Boolean {
            val decimalNumberPattern = Pattern.compile("(^[0-9]+\$)|(^[0-9]{1,3}([.|,][0-9]{3})+([.|,]0{1,2})?\$)")
            return decimalNumberPattern.matcher(value).matches()
        }

        fun sanitizeStringToLong(value: String?): Long? {
            if (value == null)
                return null

            var result = value

            if (isNumberWithDots(value) || isNumericWithZeroesDecimals(value)) {
                val regexSuffix = "([.|,]0{1,2})\$".toRegex()
                val regexThousandDelimiter = "[.|,]".toRegex()

                result = result
                    .replace(regexSuffix, "")
                    .replace(regexThousandDelimiter,"")
            }

            return result.toLongOrNull()
        }
    }
}