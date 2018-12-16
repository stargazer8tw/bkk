package io.romadata.bkk.model

import io.romadata.bkk.db.converter.Converters
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class ConvertersTest {
    @Test
    fun fromTimestamp() {
        val v = Converters().fromTimestamp(System.currentTimeMillis())
        Assert.assertNotNull(v)

        val n = Converters().fromTimestamp(null)
        Assert.assertNull(n)
    }
    @Test
    fun fromString() {
        val v = Converters().fromString("99.999")
        Assert.assertNotNull(v)
        Assert.assertEquals(BigDecimal(99.999).setScale(3, BigDecimal.ROUND_HALF_UP), v)

        val n = Converters().fromString(null)
        Assert.assertNull(n)
    }
}