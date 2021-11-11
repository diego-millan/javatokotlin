package com.drm.learning.javatokt.classes

import com.drm.learning.javatokt.domain.Person
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat

class DataClassTest {

    @Test
    fun `when try to copy a data class only deserved attribute must change`(){
        val person = Person(
            "Diego",
            "Rua do Hospicio, 257",
            "52041-302",
            29,
            SimpleDateFormat("dd/MM/yyyy").parse("21/01/1987")
        )

        val copiedPerson = person.copy(address = "Rua Salvador de Sá, 470")

        Assertions.assertEquals(person.address, "Rua do Hospicio, 257")
        Assertions.assertEquals(copiedPerson.address, "Rua Salvador de Sá, 470")
        Assertions.assertEquals(person.name, copiedPerson.name)
    }
}