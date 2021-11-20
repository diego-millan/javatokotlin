# Tipos

Antes de entrar em qualquer subtópico, é importante frisar que o Kotlin não possui tipos primitivos, porém, muitos tipos são os que já estamos acostumados a ver no Java.

### Numbers
Byte, Short, Int e Long - Todos esses tipos não possuem diferenças em relação ao que já temos no java, apenas o Integer que passa a se chamar Int, seguem os exemplos abaixo.

```kotlin
val one = 1 // Int
val oneBillion = 1000000000 // Long
val oneAsLong = 1L // Long
val oneAsByte: Byte = 1
```

Floats e Doubles, também com o comportamento semelhante.
```kotlin
val pi = 3.14 // Double
val oneAsFloat = 1.0f
```

Um pequeno truque para deixar números grandes mais legíveis é a possibilidade de usar underscore.
```kotlin
val oneBillion = 1_000_000_000 // Long
```

### Boolean
O Boolean do Kotlin funciona próximo do Java, com a diferença do operador Elvis, que torna mais intuitivo, afirmando que o booleano ser nulo
```kotlin
val isReady : Boolean = true
val nullableBoolean : Boolean? = null

```

### String
O Kotlin criou algumas extension functions (será abordado em outro momento) que facilita o uso de Strings, inicialização, percorrer os chars e a leitura

Utilizando ( """ ) podemos criar Strings com mais de uma linha.
```kotlin
val strMultiline = """
- Hey!
- Hello There!
"""
```

Concatenar Strings com pedaços de código, basta adicionar $
```kotlin
val result = 1
val str = "Result is $result"
```

Se a concatenação envolver atributos de objetos, utilizamos ${valor}
```kotlin
val dog : Pet = Dog().apply {
    name = "barto"
    gender = "male"
}

val petName = "My pet is called ${dog.name}"
```

No Java, essa concatenação de Strings é um pouco mais trabalhosa:
```java
String petName = "My pet is called " + dog.getName();
```

### Casts e Smart Casts
Para checar tipos, ao contrário do _**instanceof**_ do Java, apenas o **_is_** é utilizado.

Java:
```java
boolean isDog = pet instanceof Dog
```

Kotlin:
```kotlin
val isDog = pet is Dog

val isNotDog = pet !is Dog
```

E para realizar um Cast, o Kotlin identifica o is precedente e evita o código desnecessário.

```kotlin
fun bark(x: Any) {
    if (x is Dog) {
        print(x.bark) // x is automatically cast to Dog
    }
}
```

Uma dica muito útil é que o Smart cast também pode ser usado em funções When:
```kotlin
when (x) {
    is Int -> print(x + 1)
    is String -> print(x.length + 1)
    is IntArray -> print(x.sum())
}
```

## Tipos especiais

Seguindo a parte de tipos, existem tipos no Kotlin que representam o topo da hierarquia, ou seja, os demais herdam deles, existem os que representam a parte mais baixa da hierarquia, não tem como herdar dele, há a representação da ausência de tipo (semelhante ao void do java) e, por último, um tipo misterioso que não pode ser instanciado, mas não se preocupe, iremos desvendar esse mistério a seguir.

### Any

Representa o topo da hierarquia, podemos comparar ele com o Object do Java.

```kotlin
fun sumType(x : Any) : Int {
    return when (x) {
        is Int -> (x + 1)
        is String -> (x.length + 1)
        is IntArray -> (x.sum())
        else -> 0
    }
}

    
```

### Unit
Equivalente ao Void do Java, está implícita em todas as funções que não possuem um retorno definido

Por exemplo, a função abaixo pode ser escrita sem o uso do **_: Unit_**
```kotlin
fun sayHello(name : String) : Unit {
    println("Hello $name")
}
```

### Nothing
Pouco utilizado, o Nothing indica que a função nunca irá finalizar normalmente, ou seja, será lançado um erro de forma proposital.

```kotlin
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}
```

