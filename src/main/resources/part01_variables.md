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

### Lateinit

Sabe aquele trecho de código que você vai utilizar uma variável mas só precisa inicializar ela depois?

Vamos a um exemplo:
```java
String str = null;

if (condition()){
    str = "Thank you!"
} else {
    str = "Gracias!!" 
}

return str;
```

Existem situações onde as variáveis só vão atribuir valor no decorrer do código, pensando nesses cenários o Kotlin criou o lateinit.

Ele funciona basicamente para avisar que a variável será inicializada posteriormente.

Um uso comum ocorre em casos de fazer injeção de dependências.

```kotlin
class MyServiceTest {
    @Mock
    lateinit var myClient : MyClient
    
    lateinit var myService : MyService
    
    @BeforeEach
    fun before() {
        myService = MyService(myClient)
    }
}
```
