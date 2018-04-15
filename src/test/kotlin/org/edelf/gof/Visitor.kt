package org.edelf.gof

sealed class Figure {
    fun area():Double = when(this){
        is Square -> this.side * this.side
        is Circle -> this.radius * this.radius * Math.PI
        is Rectangle -> this.height * this.weidht
    }

    fun perimeter():Double = when(this){
        is Square -> 4 * this.side
        is Circle -> this.radius * 2 * Math.PI
        is Rectangle -> 2 * this.height + 2 * this.weidht
    }
}

data class Square(val side: Double) : Figure()

data class Circle(val radius: Double) : Figure()

data class Rectangle(val weidht: Double, val height: Double) : Figure()

fun perimeter(figure: Figure) = figure.perimeter()




