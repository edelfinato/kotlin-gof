package org.edelf.gof

class Context<I,O>( val strategy: (I)-> O){
    fun operation( input: I) : O{
        return this.strategy(input);
    }
}