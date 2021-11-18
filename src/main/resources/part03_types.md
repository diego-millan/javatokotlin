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
### Casts e Smart Casts

### Any
### Unit
### Object
### Nothing
