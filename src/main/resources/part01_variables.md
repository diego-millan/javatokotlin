# Inicialização de Variáveis com Kotlin

## Como inicializar variáveis, utilizar var, val, lateinit e modificar setters

### Variáveis

A linguagem Kotlin possui várias formas de inicializar variáveis, modificadores de inicialização e formas mais enxutas de escrever código.
O que difere a grosso modo é apenas que o nome da variável vem antes do tipo, e obrigatoriamente o modificador deve ser inserido.

Exemplo Java:
```java
String str = ""; 
```

Exemplo em Kotlin:
```kotlin
var str : String = "" 
```


### Inferência de tipo

Diferente do Java, se a variável é inicializada, o seu tipo pode ser omitido.

Exemplo em Kotlin:
```kotlin
var str = "hello!" // Seu tipo será String
```

### Variáveis Read-Only 

Semelhante ao modificador **final** no Java, o Kotlin possui a inicialização **val**. 
Esse modificador torna variáveis imutáveis, evitando NullPointerException ou modificações acidentais.

Exemplo em Java: 
```java
 final String str = ""; 
```

Exemplo em Kotlin:
```kotlin 
val str : String = "" 
```

### Valores nulos

Uma das maiores dores de cabeça em Java é a exceção NullPointerException, como muitos sabem.
No Kotlin, para evitar ao máximo problema, variáveis só podem ter valores nulos quando indicado de forma explícita através do "?" após indicar o tipo da variável.

Exemplo em Kotlin:
```kotlin 
var str : String? = null 
var number : Int = null // Erro de Sintaxe
```

