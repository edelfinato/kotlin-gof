package org.edelf.gof

import java.util.function.DoubleUnaryOperator
import java.util.function.Function

/**
 *
 * The Decorator [3] design pattern is one of the twenty-three well-known GoF design patterns that describe how to solve recurring design problems to design flexible and reusable object-oriented software, that is, objects that are easier to implement, change, test, and reuse.
 *
 * What problems can the Decorator design pattern solve? [4]
 *
 * Responsibilities should be added to (and removed from) an object dynamically at run-time.
 * A flexible alternative to subclassing for extending functionality should be provided.
 * When using subclassing, different subclasses extend a class in different ways. But an extension is bound to the class at compile-time and can't be changed at run-time.
 *
 * What solution does the Decorator design pattern describe?
 *
 * Define Decorator objects that
 *
 * implement the interface of the extended (decorated) object (Component) transparently by forwarding all requests to it and
 * perform additional functionality before/after forwarding a request.
 * This enables to work through different Decorator objects to extend the functionality of an object dynamically at run-time.
 * See also the UML class and sequence diagram below.
 *
 * */

class Taxes{
    companion object {
        fun regional(salary : Double):Double{
            println("regional")
            return  salary * 0.95
        }
        fun healtyInsurance(salary : Double):Double{
            println("healtyInsurance")
            return  salary - 100
        }
        fun country(salary : Double):Double{
            println("country")
            return  salary * 0.90
        }
    }
}

//decoretor or function composition extesion
fun <P1,P2,R> ((P1) -> R).compose(function: (P2)-> P1 ): ((P2) -> R) {
    return {
        this(function(it))
    }
}

class DefaultSalaryCalculator : DoubleUnaryOperator {
    override fun applyAsDouble(operand: Double): Double {
        println("default java")
        return operand / 12
    }

}

val defaultSalaryCalculator = { salary: Double ->  println("default kotlin")
    salary / 12
}

fun main(args: Array<String>) {

    //pure Kotlin
    println(
         defaultSalaryCalculator
                 .compose( Taxes.Companion::country )
                    .compose( Taxes.Companion::regional )
                        . compose( Taxes.Companion::healtyInsurance)(30_000.0)
    )
    //java8
    print(DefaultSalaryCalculator()
            .compose(Taxes.Companion::country)
                .compose(Taxes.Companion::regional)
                    .compose(Taxes.Companion::healtyInsurance).applyAsDouble(30_000.0)
    )
}