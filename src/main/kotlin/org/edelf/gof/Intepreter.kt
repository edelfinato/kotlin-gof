package org.edelf.gof

import java.util.*

fun calculate(stack:Stack<Int>, function: (Int,Int)->Int) {
    val right = stack.pop()
    val left = stack.pop()
    stack.push(function(left,right))
}

fun evaluate( espression:String): Int? {
    val stack = Stack<Int>()
    espression.split(" ").forEach({
        when(it){
            "+" -> calculate(stack,{a,b-> a+b})
            "-" -> calculate(stack,{a,b-> a-b})
            "*" -> calculate(stack,{a,b-> a*b})
            else -> stack.push(it.toInt())
        }
    })
    return stack.pop()
}