package com.example.seminar4_hozu_gabriel

import java.io.Serializable

// Obiect din realitate pentru Hozu Gabriel -> Hangar (conține inițialele H și G)
data class Hangar(
    var nume: String = "",
    var capacitate: Int = 0,
    var esteDisponibil: Boolean = false,
    var tip: String = "",
    var locatie: String = "",
    var rating: Float = 0f,
    var arePaza: Boolean = false
) : Serializable {
    override fun toString(): String {
        return "Hangar: nume='$nume', capacitate=$capacitate, disponibil=$esteDisponibil, tip='$tip', locatie='$locatie', rating=$rating, arePaza=$arePaza"
    }
}
